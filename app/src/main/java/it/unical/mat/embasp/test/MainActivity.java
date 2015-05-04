package it.unical.mat.embasp.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import it.unical.mat.embasp.base.ASPHandler;
import it.unical.mat.embasp.base.AnswerSet;
import it.unical.mat.embasp.base.AnswerSetCallback;
import it.unical.mat.embasp.base.AnswerSets;
import it.unical.mat.embasp.dlv.DLVHandler;

/**
 * <p>Test MainActivity for it.unical.mat.andlv </p>
 */
public class MainActivity extends Activity implements AnswerSetCallback{

    ASPHandler handler;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text = new TextView(this);

        handler = new DLVHandler();

        handler.addRawInput("col(N,red) | col(N,green) | col(N,blue) :- node(N).");
        handler.addRawInput(":- col(N1,C1), col(N2,C1), edge(N1,N2).");
        String filepath=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ File.separator+ "edb_edge.txt";
        /*
            edb_edge.txt:
            node("node_1").
            node("node_2").
            node("node_3").
        */
        try {
            handler.addFileInput(filepath);
            handler.setFilter(Col.class);



            Edge edge1 = new Edge("node_1","node_2");
            Edge edge2 = new Edge("node_1","node_3");
            Edge edge3 = new Edge("node_3","node_2");
            handler.addInput(edge1);
            handler.addInput(edge2);
            handler.addInput(edge3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        handler.start(getApplicationContext(), this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void callback(AnswerSets answerSets) {
       List<AnswerSet> answerSetList=answerSets.getAnswerSetsList();
       String text="";

       for(AnswerSet answerSet:answerSetList){
            try {
                for(Object obj:answerSet.getAnswerObjects())
                    text+=obj.toString()+",";
            } catch (Exception e) {
                e.printStackTrace();
            }
           text+="\n\n";
        }
        this.text.setText(text);
        setContentView(this.text);
    }
}
