package it.unical.mat.embasp.asp;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import it.unical.mat.embasp.asp.ASPMapper;

public abstract class AnswerSet {

	private List<String> value;
	private Map<Integer,Integer> weight_map;
	private Set<Object> atoms;


	public AnswerSet (List<String> output) {
		value = output;
		weight_map = new HashMap<>();
	}

	public List<String> getAnswerSet() { 
		return Collections.unmodifiableList(value);
	}

	public Set<Object> getAtoms() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException{
		if(atoms == null){
			atoms = new HashSet<>();
			ASPMapper mapper = ASPMapper.getInstance();
			for(String atom : value){
				Object obj = mapper.getObject(atom);
				if(obj ==null )
					atoms.add(obj);
			}
		}
		return atoms;
	}

}
