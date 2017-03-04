package it.unical.mat.embasp.languages.asp;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.languages.IllegalAnnotationException;

/** a generic ASP program , with the capabilities of retrieve data by objects */

public class ASPInputProgram extends InputProgram {

	public ASPInputProgram() {
		super();
	}

	public ASPInputProgram(final Object inputObj) throws InvocationTargetException, NoSuchMethodException, IllegalTermException, IllegalAccessException,
			IllegalAnnotationException, PredicateNotValidException {
		super(inputObj);
	}

	public ASPInputProgram(final String initial_program) {
		super(initial_program);
	}

	/**
	 * transforms a given Object class into a {@link InputProgram} and adds it to the current {@link #programs}
	 *
	 * @param inputObj
	 *            an object to be transformed
	 * @see ASPMapper
	 * @throws IllegalAccessException
	 *             , IllegalArgumentException , InvocationTargetException , NoSuchMethodException , SecurityException , IllegalTermException
	 */
	@Override
	public void addObjectInput(final Object inputObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, IllegalTermException, IllegalAnnotationException, PredicateNotValidException {
		addProgram(ASPMapper.getInstance().getString(inputObj) + ".");
	}

	/** transforms a set of objects @see #addObjectInput(Object) */
	@Override
	public void addObjectsInput(final Set<Object> inputObjs) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, IllegalTermException, PredicateNotValidException, IllegalAnnotationException {
		for (final Object inputObj : inputObjs)
			addObjectInput(inputObj);
	}
}
