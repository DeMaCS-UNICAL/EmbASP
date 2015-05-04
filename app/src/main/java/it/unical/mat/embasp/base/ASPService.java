package it.unical.mat.embasp.base;

import android.app.IntentService;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>ASPService is an {@link android.app.IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread. ASPService class provides the basic functions
 * starting an Answer Set Program generic execution with its options.</p>
 */
public abstract class ASPService extends IntentService {
    //Intent messages/actions/extras for ASPService start and BroadcastReceiver communication
    public static final String ACTION_SOLVE = "it.unical.embasp.SOLVE";

    public static final String PROGRAM = "it.unical.mat.embasp.PROGRAM";
    public static final String OPTION = "it.unical.mat.embasp.OPTION";
    public static final String FILES = "it.unical.mat.embasp.FILES";
    public static final String SOLVER_RESULT = "it.unical.mat.embasp.SOLVER_RESULT";

    public static final String RESULT_NOTIFICATION = "it.unical.mat.embsp.RESULT_NOTIFICATION";


    public ASPService() {
        super("ASPService");//worker thread named "ASPService"
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_SOLVE.equals(action)) {
                //get a String with PROGRAM tag that indentify program String
                //get a String with OPTION tag that indentify options String
                //call the abstract method that handle a specific solve action
                //Send the result with a Broadcast Intent
                final String program = intent.getStringExtra(PROGRAM);
                final String options = intent.getStringExtra(OPTION);
                final ArrayList<String> files = intent.getStringArrayListExtra(FILES);
                final String result = handleActionSolve(program, options, files);
                publishResults(result);
            }
        }
    }


    private void publishResults(String result) {
        Intent intent = new Intent(RESULT_NOTIFICATION);
        intent.putExtra(SOLVER_RESULT, result);
        sendBroadcast(intent);
    }

    protected abstract String handleActionSolve(String program, String option, List<String> filesPath) ;

}
