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
 * Get an Answer Set Program and its options for the execution. Provide a public method to start the Answer Set Program execution. </p>
 */
public abstract class ASPHandler extends BroadcastReceiver {

    protected StringBuilder options;
    protected StringBuilder program;
    protected List<String> filesPaths;

    public ASPHandler(){
        this.options = new StringBuilder();
        this.program = new StringBuilder();
        this.filesPaths = new ArrayList<String>();
    }

    public abstract void start(Context context,AnswerSetCallback asCallback);

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

    public void addRawInput(String rawInput){
        program.append(rawInput);
    }

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

    abstract protected void receive(String aspServiceOut);

    public void clearProgram(){
        program.setLength(0);
        program.trimToSize();
    }

    public void clearOptions(){
        options.setLength(0);
        options.trimToSize();
    }

    public void clearFilesPaths(){
    filesPaths.clear();
    }


    public void clearAll(){
        clearOptions();
        clearFilesPaths();
        clearProgram();
    }
}
