package it.unical.mat.embasp.languages;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.unical.mat.embasp.languages.asp.IllegalTermException;

/**
 * Base class
 * Contains methods used to transform Objects into {@link it.unical.mat.embasp.base.InputProgram}
 */

public abstract class Mapper {

	protected final Map<String, Class<?>> predicateClass = new HashMap<>();

	protected final Map<Class<?>, Map<String, Method>> classSetterMethod = new HashMap<>();

	protected abstract String getActualString(String predicate, HashMap<Integer, Object> parametersMap) throws IllegalTermException;

	public Class<?> getClass(final String predicate) {
		return predicateClass.get(predicate);
	}
	
	/**
	 * Returns a Set of Objects for the given string representing a list of atoms
	 *
	 * @param string
	 *            String from witch data are extrapolated
	 * @return Set of Objects for the given String data
	 * @throws IllegalAccessException, InstantiationException, InvocationTargetException
	 */
	public Set<Object> getObjects(final String atomsList) throws IllegalAccessException, InstantiationException, InvocationTargetException {
		buildParseTree(atomsList);
		
		final Set <Object> objects = new HashSet <> ();
		String predicate = getId();
		
		while(predicate != null) {
			final Class<?> cl = getClass(predicate);
			final String[] parameters = getParam();
			predicate = getId();
			
			if (cl == null || parameters == null)
				continue;
			
			final Object obj = cl.newInstance();

			populateObject(cl, parameters, obj);
			objects.add(obj);
		}

		return objects;
	}
	
	/**
	 * @param string
	 *            The string representing a list of atoms received as parameter of getObjects
	 */
	protected abstract void buildParseTree(final String atomsList);
	
	/**
	 * @return The predicate name
	 */
	protected abstract String getId();
	
	/**
	 * @return All the Terms
	 */
	protected abstract String[] getParam();
	
	/**
	 * Returns an Object for the given string
	 *
	 * @param string
	 *            String from witch data are extrapolated
	 * @return Object for the given String data
	 * @throws IllegalAccessException,
	 *             IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalTermException
	 */
	public Object getObject(final String string) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, InstantiationException {

		final String predicate = getPredicate(string);

		if (predicate == null)
			return null;

		final Class<?> cl = getClass(predicate);

		// Not exist mapping between the predicate and the class
		if (cl == null)
			return null;

		final String[] parameters = getParameters(string);

		if (parameters == null)
			return null;

		final Object obj = cl.newInstance();

		populateObject(cl, parameters, obj);

		return obj;

	}

	/**
	 * @param string
	 *            The full value received as parameter of getObject
	 * @return All the Terms
	 */
	protected abstract String[] getParameters(final String string);

	/**
	 * @param string
	 *            The full value received as parameter of getObject
	 * @return The predicate name
	 * @throws IllegalArgumentException
	 */
	protected abstract String getPredicate(final String string) throws IllegalArgumentException;

	/**
	 * Returns data for the given Object
	 *
	 * @param obj
	 *            Object from witch data are extrapolated
	 * @return String data for the given Object in a String format
	 * @throws IllegalAccessException,
	 *             IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalTermException, IllegalTermException
	 */
	public String getString(final Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, ObjectNotValidException, IllegalAnnotationException, IllegalTermException {
		final String predicate = registerClass(obj.getClass());

		final HashMap<Integer, Object> parametersMap = new HashMap<>();
		for (final Field field : obj.getClass().getDeclaredFields()) {
			if (field.isSynthetic())
				continue;
			if (field.isAnnotationPresent(Param.class)) {
				final Object value = obj.getClass().getMethod("get" + Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1))
						.invoke(obj);
				parametersMap.put(field.getAnnotation(Param.class).value(), value);
			}
		}
		return getActualString(predicate, parametersMap);
	}

	private void populateObject(final Class<?> cl, final String[] parameters, final Object obj) throws IllegalAccessException, InvocationTargetException {
		for (final Field field : cl.getDeclaredFields())
			if (field.isAnnotationPresent(Param.class)) {

				final int term = field.getAnnotation(Param.class).value();
				final String nameMethod = "set" + Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1);
				final Method method = classSetterMethod.get(cl).get(nameMethod);

				if (method.getParameterTypes()[0].getName().equals(int.class.getName())
						|| method.getParameterTypes()[0].getName().equals(Integer.class.getName()))
					method.invoke(obj, Integer.valueOf(parameters[term]));
				else
					method.invoke(obj, parameters[term]);

			}
	}

	/**
	 * insert an object into {@link #predicateClass} and {@link #classSetterMethod}
	 *
	 * @return String representing pairing key of {@link #predicateClass}
	 */
	public String registerClass(final Class<?> cl) throws ObjectNotValidException, IllegalAnnotationException {

		final Annotation annotation = cl.getAnnotation(Id.class);

		if (annotation == null)
			throw new IllegalAnnotationException();

		final String predicate = ((Id) annotation).value();

		if (predicate.contains(" "))
			throw new ObjectNotValidException();

		// String predicate = cl.getAnnotation(Predicate.class).value();
		predicateClass.put(predicate, cl);
		final Map<String, Method> namesMethods = new HashMap<>();
		for (final Method method : cl.getMethods())
			if (method.getName().startsWith("set"))
				namesMethods.put(method.getName(), method);
		classSetterMethod.put(cl, namesMethods);
		return predicate;
	}

	public void unregisterClass(final Class<?> cl) throws IllegalAnnotationException {

		final Annotation annotation = cl.getAnnotation(Id.class);

		if (annotation == null)
			throw new IllegalAnnotationException();

		final String predicate = ((Id) annotation).value();

		predicateClass.remove(predicate);
		classSetterMethod.remove(cl);

	}

}
