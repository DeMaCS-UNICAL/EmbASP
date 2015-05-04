package it.unical.mat.embasp.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.unical.mat.embasp.mapper.ASPMapper;
import it.unical.mat.embasp.mapper.IllegalTermException;

/**
 * <p>ASPHandler is an Abstract class. It provides generic methods for an Answer Set Program execution handling.
 * Get an Answer Set Program and its options for the execution. Provide a public methos to start the Answer Set Program execution. </p>
 */
public abstract class ASPHandler extends BroadcastReceiver {

    protected StringBuilder options;//stores program options
    protected StringBuilder program;//store an entire ASP program
    protected List<String> filesPaths;

    public ASPHandler(){
        this.options = new StringBuilder();
        this.program = new StringBuilder();
        this.filesPaths = new ArrayList<String>();
    }

    /** Execute the Answer Set Program and get AnswerSetCallback implemented
     * that is called for the result handling
     * @param asCallback
     * @param context
     * @see it.unical.mat.andlv.base.AnswerSetCallback
     * @see android.content.Context
     */
    public abstract void start(Context context,AnswerSetCallback asCallback);

    /**
     * Add an Answer Set Program option for sexecution
     * @param options
     */
    public void addOption(String options){
        this.options.append(options);
    }

    abstract public void setFilter(String... predicates);

    abstract public void addFilter(String predicate);

    abstract public void setFilter(Class<?>... classes);

    abstract public void addFilter(Class<?> aClass);

    public void addInput(Object inputObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalTermException {
        program.append(ASPMapper.getInstance().getString(inputObj)).append(".");
    }

    public void addInput(Set<Object> inputObjs) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalTermException {
        for(Object inputObj:inputObjs)
            addInput(inputObj);
    }

    public void addFileInput(String filePath) throws FileNotFoundException {
        File f=new File(filePath);
        if(f.exists() && f.isFile())
            this.filesPaths.add(filePath);
        else
            throw new FileNotFoundException();
    }

    /**
     *  Add an Answer Set Program input
     * @param rawInput
     */
    public void addRawInput(String rawInput){
        program.append(rawInput);
    }

    /**
     * onReceive method get a Broadcast {@link android.content.Intent} sent, then send result to {@link it.unical.mat.andlv.base.ASPService}
     * @param context Application Context
     * @param intent get ASPService execution result when it is ready
     * @see android.content.Context
     * @see android.content.Intent
     * @see android.os.Bundle
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String ASPResult = bundle.getString(ASPService.SOLVER_RESULT);
            if (ASPResult != null) {
                receive(ASPResult);
            }
        }
    }


    /**
     * Abstract method called from an when a result is notify
     * @param aspServiceOut
     */
    abstract protected void receive(String aspServiceOut);


}
