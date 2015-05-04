package it.unical.mat.embasp.dlv;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import java.util.ArrayList;

import it.unical.mat.embasp.base.ASPHandler;
import it.unical.mat.embasp.base.AnswerSetCallback;
import it.unical.mat.embasp.mapper.ASPMapper;

/**
 * <p>DLVHandler is an implementation of an {@link it.unical.mat.andlv.base.ASPHandler} used for a DLV ASP solver execution handling.It uses
 * an class that notify a result from a {@link it.unical.mat.andlv.base.ASPService} implementation class that provides a native method invoching DLV in an appropriate
 * working thread. An {@link it.unical.mat.andlv.base.AnswerSetCallback} class is used for result handling.
 * .</p>
 * @see android.app.IntentService
 * @see android.content.BroadcastReceiver
 */
public class DLVHandler extends ASPHandler{
    private AnswerSetCallback asCallback; //callback for result

    private StringBuilder predicateToFilter;

    /**
     * Constructor inizialize the {@link DLVService}
     */
    public DLVHandler(){
        super();
        predicateToFilter=new StringBuilder();
    }

    /** Starts DLVService and initialize Application {@link android.content.Context} and {@link it.unical.mat.andlv.base.AnswerSetCallback}
     * @param asCallback AnswerSetCallback object
     * @param context Context object
     * @see it.unical.mat.andlv.base.AnswerSetCallback
     * @see android.content.Context
     */
    @Override
    public void start(Context context, AnswerSetCallback asCallback) {
        this.asCallback = asCallback;
        stopDlvService(context);
        Intent intent = new Intent(context, DLVService.class);
        intent.setAction(DLVService.ACTION_SOLVE);
        intent.putExtra(DLVService.PROGRAM, this.program.toString());
        if(predicateToFilter.length()>0)
            this.options.append(" -filter="+predicateToFilter.toString());
        intent.putExtra(DLVService.FILES, (ArrayList<String>)this.filesPaths);
        intent.putExtra(DLVService.OPTION, this.options.toString());
        context.registerReceiver(this, new IntentFilter(DLVService.RESULT_NOTIFICATION));
        Log.i(getClass().getName(), " start service");
        context.startService(intent);
    }

    @Override
    public void setFilter(String... predicates) {
        predicateToFilter=new StringBuilder();
        for(int i=0;i<predicates.length;i++) {
            if (i == 0)
                predicateToFilter.append(predicates[i]);
            else
                predicateToFilter.append(","+predicates[i]);
        }

    }

    @Override
    public void addFilter(String predicate) {
        if(predicateToFilter.length()==0)
            predicateToFilter.append(predicate);
        else
            predicateToFilter.append(","+predicate);
    }

    @Override
    public void setFilter(Class<?>... classes) {
        predicateToFilter=new StringBuilder();
        ASPMapper mapper=ASPMapper.getInstance();
        for(int i=0;i<classes.length;i++) {
            if (i == 0)
                predicateToFilter.append(mapper.registerClass(classes[i]));
            else
                predicateToFilter.append(","+mapper.registerClass(classes[i]));
        }
    }

    @Override
    public void addFilter(Class<?> aClass) {
        ASPMapper mapper=ASPMapper.getInstance();
        if(predicateToFilter.length()==0)
            predicateToFilter.append(mapper.registerClass(aClass));
        else
            predicateToFilter.append(","+mapper.registerClass(aClass));
    }

    /**
     * Calls the {@link it.unical.mat.andlv.base.AnswerSetCallback} callback function for result handling.
     * @param aspServiceOut
     * @see it.unical.mat.andlv.base.AnswerSetCallback
     */
    @Override
    protected void receive(String aspServiceOut){
        asCallback.callback(new DLVAnswerSets(aspServiceOut));
    }

    /**
     * Check if a service is already running and waits until service is stopped.
     * @see android.app.ActivityManager
     */
    void stopDlvService(Context context){

        boolean isServiceRunning = true;

        while (isServiceRunning) {

            //get device active service list
            ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

            isServiceRunning = false;
            //see if DLVService is in running service list
            for (ActivityManager.RunningServiceInfo processInfo : manager.getRunningServices(Integer.MAX_VALUE)) {
                if (processInfo.service.getClassName().equals(DLVService.class.getName())) {
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
