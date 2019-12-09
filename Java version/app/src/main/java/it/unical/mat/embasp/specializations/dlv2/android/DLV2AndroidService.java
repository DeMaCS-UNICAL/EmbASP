package it.unical.mat.embasp.specializations.dlv2.android;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.platforms.android.AndroidService;
import it.unical.mat.embasp.specializations.dlv.android.DLVAndroidReasoner;
import it.unical.mat.embasp.specializations.dlv2.DLV2AnswerSets;

/**DLV2 solver for Android platforms*/

public class DLV2AndroidService extends AndroidService {

    public DLV2AndroidService(Context c) {
        super(c);
    }


    private class Receiver extends BroadcastReceiver {
        private Callback asCallback;
        public Receiver(Callback callback){
            asCallback = callback;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            context.unregisterReceiver(this);
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String ASPResult = bundle.getString(DLVAndroidReasoner.SOLVER_RESULT);
                if (ASPResult != null) {
                    asCallback.callback(new DLV2AnswerSets(ASPResult));
                }
            }
        }
    }



    @Override
    public void startAsync(Callback callback, List<InputProgram> programs, List<OptionDescriptor> options) {
        stopDlv2Service(context);
        Intent intent = new Intent(context, DLV2AndroidReasoner.class);
        String input_options = new String();

        input_options+="--silent";

        for (OptionDescriptor o : options) {

            input_options+= o.getOptions();
        }

        intent.putExtra(DLVAndroidReasoner.OPTION,input_options);


        String final_program = new String();
        String files = new String();

        for (InputProgram p : programs) {
            final_program += p.getPrograms();
            String program_file = p.getStringOfFilesPaths();

            if (program_file != null) {
                files += program_file;
            }
        }

        intent.setAction(DLVAndroidReasoner.ACTION_SOLVE);
        intent.putExtra(DLVAndroidReasoner.PROGRAM, final_program);
        intent.putExtra(DLVAndroidReasoner.FILES, files);
        context.registerReceiver(new Receiver(callback), new IntentFilter(DLVAndroidReasoner.RESULT_NOTIFICATION));
        context.startService(intent);
    }


    void stopDlv2Service(Context context){

        boolean isServiceRunning = true;
        while (isServiceRunning) {
            //get device active service list
            ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

            isServiceRunning = false;
            //see if DLV2Service is in running service list
            for (ActivityManager.RunningServiceInfo processInfo : manager.getRunningServices(Integer.MAX_VALUE)) {
                if (processInfo.service.getClassName().equals(DLV2AndroidReasoner.class.getName())) {
                    isServiceRunning = true;
                    break;
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
