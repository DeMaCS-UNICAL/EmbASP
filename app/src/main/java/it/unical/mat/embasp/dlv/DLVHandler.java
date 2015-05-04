package it.unical.mat.embasp.dlv;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import java.util.ArrayList;

import it.unical.mat.embasp.base.ASPHandler;
import it.unical.mat.embasp.base.AnswerSetCallback;
import it.unical.mat.embasp.mapper.ASPMapper;

/**
 * <p>DLVHandler is an implementation of an {@link it.unical.mat.embasp.base.ASPHandler} used for a DLV ASP solver execution handling.
 * .</p>
 */
public class DLVHandler extends ASPHandler{
    private AnswerSetCallback asCallback; //callback for result

    private StringBuilder predicateToFilter;

    public DLVHandler(){
        super();
        predicateToFilter=new StringBuilder();
    }


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

    @Override
    protected void receive(String aspServiceOut){
        asCallback.callback(new DLVAnswerSets(aspServiceOut));
    }

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
