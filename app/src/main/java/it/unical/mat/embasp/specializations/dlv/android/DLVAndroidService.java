package it.unical.mat.embasp.specializations.dlv.android;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Service;
import it.unical.mat.embasp.platforms.android.AndroidReciver;
import it.unical.mat.embasp.specializations.dlv.DLVAnswerSets;

//TODO Extend broadCast
public class DLVAndroidService extends AndroidReciver implements Service {

    private Callback asCallback;
    private Context c;
    public DLVAndroidService(Callback callback,Context c) {
        super(new DLVServiceReasoner("solver"));
        asCallback = callback;
        this.c = c;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String ASPResult = bundle.getString(DLVServiceReasoner.SOLVER_RESULT);
            if (ASPResult != null) {
                asCallback.callback(new DLVAnswerSets(ASPResult));
            }
        }
    }

    @Override
    public Output startSync(List<InputProgram> programs, List<OptionDescriptor> options) {
        return null;
    }

    @Override
    public void startAsync(Callback callback, List<InputProgram> programs, List<OptionDescriptor> options) {
        stopDlvService(c);
        asCallback = callback;
        Intent intent = new Intent(c, DLVServiceReasoner.class);
        intent.setAction(DLVServiceReasoner.ACTION_SOLVE);
        intent.putExtra(DLVServiceReasoner.PROGRAM, programs.toString());
        intent.putExtra(DLVServiceReasoner.OPTION,options.toString());
        c.registerReceiver(this, new IntentFilter(DLVServiceReasoner.RESULT_NOTIFICATION));
        Log.i(getClass().getName(), " start service");
        c.startService(intent);

    }


    void stopDlvService(Context context){

        boolean isServiceRunning = true;

        while (isServiceRunning) {

            //get device active service list
            ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

            isServiceRunning = false;
            //see if DLVService is in running service list
            for (ActivityManager.RunningServiceInfo processInfo : manager.getRunningServices(Integer.MAX_VALUE)) {
                if (processInfo.service.getClassName().equals(DLVServiceReasoner.class.getName())) {
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
