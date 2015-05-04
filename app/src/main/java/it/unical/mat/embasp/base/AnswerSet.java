package it.unical.mat.embasp.base;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unical.mat.embasp.mapper.ASPMapper;

/**
 * <p>AnswerSet class represents an Answer Set and contains get and set methods to handle it.</p>
 *
 */
public class AnswerSet {
    private List<String> answerSet;//String representing the Answer Set
    private HashMap<Integer,Integer> weightMap;//Answer sets weights
    private Set<Object> objectsAtoms;

    public AnswerSet(List<String> outputString){
        this.answerSet = outputString;
        this.weightMap = new HashMap<Integer, Integer>();
    }

    public List<String> getAnswerSet(){
        return Collections.unmodifiableList(this.answerSet);
    }

    public Set<Object> getAnswerObjects() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(objectsAtoms ==null) {
            objectsAtoms = new HashSet<>();
            ASPMapper mapper = ASPMapper.getInstance();
            for (String atom : answerSet) {
                    Object obj=mapper.getObject(atom);
                    if(obj!=null)
                        objectsAtoms.add(obj);
            }
        }
        return objectsAtoms;
    }

}
