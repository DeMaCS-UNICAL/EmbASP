package it.unical.mat.embasp.specializations.dlv.android;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

public class DLVAndroidReasoner extends IntentService {


    private static final String FILENAME = "tmp_program";


    //load the static library that contains DLV code compiled for arm processors
    static{
        System.loadLibrary("dlvJNI");
    }

    public DLVAndroidReasoner() {
        super("dlv_service");
    }



    //Intent messages/actions/extras for ASPService start and BroadcastReceiver communication
    // TODO change package name
    public static final String ACTION_SOLVE = "it.unical.mat.embasp.SOLVE";
    public static final String PROGRAM = "it.unical.mat.embasp.PROGRAM";
    public static final String OPTION = "it.unical.mat.embasp.OPTION";
    public static final String FILES = "it.unical.mat.embasp.FILES";
    public static final String SOLVER_RESULT = "it.unical.mat.embasp.SOLVER_RESULT";
    public static final String RESULT_NOTIFICATION = "it.unical.mat.embasp.RESULT_NOTIFICATION";

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
                final String files = intent.getStringExtra(FILES);
                final String result = handleActionSolve(program, options, files);
                Log.i("result", result);
                publishResults(result);
            }
        }
    }

    private void publishResults(String result) {
        Intent intent = new Intent(RESULT_NOTIFICATION);
        intent.putExtra(SOLVER_RESULT, result);
        sendBroadcast(intent);
    }

    protected String handleActionSolve(String program, String options, String filesPath) {
        Log.i("DlvSevice", "Launch service");
        File file = new File(this.getFilesDir(), FILENAME);

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
        String result = dlvMain(completeProgram.toString());
        long stopTime = System.nanoTime();
        Log.i("DLV Execution Time", Long.toString(TimeUnit.NANOSECONDS.toMillis(stopTime - startTime)));
        return result;
    }


    private native String dlvMain(String filePath);

    @Override
    public void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());//kill the process corresponding to this DLVService
    }

}
