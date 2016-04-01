package it.unical.mat.embasp.dlv;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import it.unical.mat.embasp.base.ASPService;
import it.unical.mat.embasp.base.Service;

/**
 */

/**
 * <p>DLVService extends {@link it.unical.mat.embasp.base.ASPService} and contains specific method for a DLV Solver execution.</p>
 *
 */


public class DLVService extends ASPService implements Service{

    private static final String FILENAME = "tmp_program";


    //load the static library that contains DLV code compiled for arm processors
    static{
        System.loadLibrary("dlvJNI");
    }

    public DLVService() {super();}


    @Override
    protected String handleActionSolve(String program, String options, List<String> filesPath) {
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

        for(String s:filesPath)
            completeProgram.append(s).append(" ");

        long startTime = System.nanoTime();
        String result = dlvMain(completeProgram.toString());
        long stopTime = System.nanoTime();
        return result;
    }


    private native String dlvMain(String filePath);


    @Override
    public void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}

