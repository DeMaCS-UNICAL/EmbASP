package it.unical.mat.embasp.specializations.dlv2.android;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import static it.unical.mat.embasp.specializations.dlv.android.DLVAndroidReasoner.ACTION_SOLVE;
import static it.unical.mat.embasp.specializations.dlv.android.DLVAndroidReasoner.FILES;
import static it.unical.mat.embasp.specializations.dlv.android.DLVAndroidReasoner.OPTION;
import static it.unical.mat.embasp.specializations.dlv.android.DLVAndroidReasoner.PROGRAM;
import static it.unical.mat.embasp.specializations.dlv.android.DLVAndroidReasoner.RESULT_NOTIFICATION;
import static it.unical.mat.embasp.specializations.dlv.android.DLVAndroidReasoner.SOLVER_RESULT;

public class DLV2AndroidReasoner extends IntentService {

    //load the static library that contains DLV code compiled for arm processors
    static{
        System.loadLibrary("dlv2jni");
    }

    public DLV2AndroidReasoner() {
        super("dlv2_service");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("DLV2",(intent!=null)+"");
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_SOLVE.equals(action)) {
                //get a String with PROGRAM tag that indentify program String
                //get a String with OPTION tag that indentify options String
                //call the abstract method that handle a specific solve action
                //Send the result with a Broadcast Intent
                final String program = intent.getStringExtra(DLVAndroidReasoner.PROGRAM);
                final String options = intent.getStringExtra(DLVAndroidReasoner.OPTION);
                final String files = intent.getStringExtra(DLVAndroidReasoner.FILES);
                final String result = handleActionSolve(program, options, files);
                publishResults(result);
            }
        }
    }

    private void publishResults(String result) {
        Intent intent = new Intent(DLVAndroidReasoner.RESULT_NOTIFICATION);
        intent.putExtra(DLVAndroidReasoner.SOLVER_RESULT, result);
        sendBroadcast(intent);
    }

    public String handleActionSolve(String program, String options, String filesPath) {
        Log.i("DLV2", "Launching DLV2");
        File file = new File(this.getFilesDir(), DLVAndroidReasoner.FILENAME);

        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(program.getBytes());
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder completeProgram = new StringBuilder();
        completeProgram.append(options).append(" ");
        completeProgram.append(file.getAbsolutePath()).append(" ");

        completeProgram.append(filesPath).append(" ");

        long startTime = System.nanoTime();
        String result = dlv2main(completeProgram.toString());
        long stopTime = System.nanoTime();
        Log.i("DLV2", "Execution Time: "+Long.toString(TimeUnit.NANOSECONDS.toMillis(stopTime - startTime)));
        return result;
    }


    private native String dlv2main(String filePath);

    @Override
    public void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());//kill the process corresponding to this DLV2Service
    }

}
