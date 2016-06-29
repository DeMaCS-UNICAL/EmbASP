package it.unical.mat.embasp.asp;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import it.unical.mat.embasp.base.InputProgram;


/**a generic ASP program , with the capabilities of retrieve data by objects */

public class ASPInputProgram extends InputProgram {


    public ASPInputProgram() {
    }

    public ASPInputProgram(String initial_program) {
        super(initial_program);
    }

    public ASPInputProgram(Object inputObj) throws InvocationTargetException, NoSuchMethodException, IllegalTermException, IllegalAccessException {
        super(inputObj);
    }

    @Override
    public void addObjectInput(Object inputObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalTermException {
        addProgram(ASPMapper.getInstance().getString(inputObj) + ".");
    }

    @Override
    public void addObjectsInput(Set<Object> inputObjs) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalTermException {
        for (Object inputObj : inputObjs)
            addObjectInput(inputObj);
    }
}
