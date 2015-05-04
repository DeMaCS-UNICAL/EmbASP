package it.unical.mat.embasp.base;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unical.mat.embasp.mapper.ASPMapper;

/**
 * <p>AnswerSet class rapresents an Answer Set and contains get and set methods to handle it.</p>
 * @see java.util.HashMap
 */
public class AnswerSet {
    private List<String> answerSet;//String representing the Answer Set
    private HashMap<Integer,Integer> weightMap;//Answer sets weights
    private Set<Object> objectsAtoms;

    /**
     * Constructor intialize an AnswerSet object with a String containing the Answer Set
     * and an {@link java.util.HashMap} containing Answer Set weight
     * @param outputString String representing an Answer Set
     */
    public AnswerSet(List<String> outputString){
        this.answerSet = outputString;
        this.weightMap = new HashMap<Integer, Integer>();
    }

    /**
     * Get function for the Answer Set in String format
     * @return answerSet Answer Set in String format
     */
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
