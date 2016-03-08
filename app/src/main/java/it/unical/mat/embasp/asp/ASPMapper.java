package it.unical.mat.embasp.asp;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ASPMapper {

	private static ASPMapper mapper;

	private Map<String,Class<?>> predicateClass;
	private Map<Class, Map<String,Method>> classSetterMethod;

	private ASPMapper(){
		predicateClass = new HashMap<>();
		classSetterMethod = new HashMap<>();
	}

	public ASPMapper getInstance(){
		if(mapper == null){
			mapper = new ASPMapper();
		}
		return mapper;
	}
}
