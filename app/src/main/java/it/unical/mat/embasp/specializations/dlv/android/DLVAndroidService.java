package it.unical.mat.embasp.specializations.dlv.android;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.platforms.android.AndroidService;
import it.unical.mat.embasp.specializations.dlv.DLVAnswerSets;


public class DLVAndroidService extends AndroidService {

    public DLVAndroidService() {
        binder = new DLVBinder();

    }

    //load the static library that contains DLV code compiled for arm processors
    static{
        System.loadLibrary("dlvJNI");
    }

    /*Returns the current Service class , can be used to interact directly with the Service*/
    public class DLVBinder extends AndroidBinder {
        public AndroidService getService(){
            return DLVAndroidService.this;
        }
    }

    @Override
    public Output startSync(List<InputProgram> programs, List<OptionDescriptor> options) {
        return null;
    }
//    check multiple execution
    @Override
    public void startAsync(final Callback callback,final List <InputProgram> programs, final List<OptionDescriptor> options) {
        new Thread(new Runnable() {
            public void run() {

                StringBuilder input_data = new StringBuilder();

                input_data.append("-silent ");

                for (OptionDescriptor o :options) {

                    input_data.append(o.getOptions());

                }


                String final_program = new String();

                for (InputProgram p : programs) {
                    final_program += p.getProgram();
                    String program_file = p.getFiles();

                    if(program_file != null) {
                        if(input_data.length()==0) {

                            input_data.append(program_file);

                        }else{

                            input_data.append(program_file);

                        }

                    }
                }

                System.out.println(final_program);
                File tmp_file = new File(getFilesDir(),"tmp_file");
                Writer outputStream;

                try {
                    outputStream = new BufferedWriter(new FileWriter(tmp_file));
                    outputStream.append(final_program);
                    outputStream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


                input_data.append(tmp_file.getAbsolutePath());

                long startTime = System.nanoTime();
                String result = dlvMain(input_data.toString());
                long stopTime = System.nanoTime();
                Log.i("DLV Execution Time", Long.toString(TimeUnit.NANOSECONDS.toMillis(stopTime - startTime)));
                callback.callback(new DLVAnswerSets(result));
                stopSelf();
            }
        }).start();

    }

    /**
     * Native function for DLV invocation
     * @param filePath the path of a temporary file storing DLV program
     * @return String result computed from DLV
     */
    private native String dlvMain(String filePath);

}
