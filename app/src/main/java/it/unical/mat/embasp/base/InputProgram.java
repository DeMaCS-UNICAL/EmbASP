package it.unical.mat.embasp.base;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.asp.IllegalTermException;
import it.unical.mat.embasp.languages.asp.PredicateNotValidException;

/** Represents a generic option */

public class InputProgram {
	/** where programs data is stored */
	protected String programs;
	/** where associated files are stored */
	protected List<String> files_paths;
	/** used as separator for programs */
	protected String separator;

	/** Creates a new programs , setting space as default separator */
	public InputProgram() {
		init();
		separator = " ";
	}

	/**
	 * instantiate a new {@link InputProgram}
	 * 
	 * @param inputObj
	 *            Object used to retrieve data from
	 * @see #addObjectInput(Object)
	 */
	public InputProgram(final Object inputObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, IllegalTermException, PredicateNotValidException, IllegalAnnotationException {
		init();
		addObjectInput(inputObj);
	}

	public InputProgram(final String initial_program) {
		init();
		programs = initial_program;
	}

	/**
	 * add a new file path into {@link #files_paths}
	 * 
	 * @param file_path
	 *            a new file path
	 */
	public void addFilesPath(final String file_path) {
		files_paths.add(file_path);
	}

	/**
	 * @throws IllegalAccessException
	 *             , IllegalArgumentException , InvocationTargetException , NoSuchMethodException , SecurityException , IllegalTermException
	 */
	public void addObjectInput(final Object inputObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, IllegalTermException, IllegalAnnotationException, PredicateNotValidException {
		throw new UnsupportedOperationException("functionality not implemented");
	}

	/** @see #addObjectInput(Object) */
	public void addObjectsInput(final Set<Object> inputObjs) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, IllegalTermException, PredicateNotValidException, IllegalAnnotationException {
		for (final Object inputObj : inputObjs)
			addObjectInput(inputObj);
	}

	/**
	 * Adds a new instruction directly into {@link #programs}
	 * 
	 * @param new_instruction
	 *            a new programs instruction
	 */
	public void addProgram(final String new_instruction) {
		if (programs.isEmpty())
			programs = new_instruction;
		else
			programs += separator + new_instruction;
	}

	/** After this method both {@link #files_paths} and {@link #programs} will be empty */
	public void clearAll() {
		clearFilesPaths();
		clearPrograms();
	}

	/** After this method {@link #files_paths} will be empty */
	public void clearFilesPaths() {
		files_paths.clear();
	}

	/** After this method {@link #programs} will be empty */
	public void clearPrograms() {
		programs = "";
	}

	/**
	 * Returns files paths for this programs
	 * 
	 * @return String concatenating files paths
	 */
	public String getFilesPaths() {

		final StringBuilder to_return = new StringBuilder();

		for (final String paths : files_paths)
			if (paths.length() != 0)
				to_return.append(paths).append(" ");

		return to_return.toString();
	}

	/** Returns data stored in {@link #programs} */
	public String getPrograms() {
		return programs;
	}

	/**
	 * get separator character
	 * 
	 * @return separator
	 */
	public String getSeparator() {
		return separator;
	}

	private void init() {
		programs = new String();
		files_paths = new ArrayList<>();
	}

	/**
	 * sets {@link #programs } value to the new given one
	 * 
	 * @parm programs new value
	 */
	public void setPrograms(final String programs) {
		this.programs = programs;
	}

	/**
	 * Set programs separator to current value
	 * 
	 * @param separator
	 *            used as new separator
	 */
	public void setSeparator(final String separator) {
		this.separator = separator;
	}

	public void setPDDLDomainFile(final String domain){
		throw new UnsupportedOperationException("functionality not implemented");
	}
	
	public void setPDDLProblemFile(final String problem){
		throw new UnsupportedOperationException("functionality not implemented");
	}
	
	public void setPDDLDomainAsString(final String domain){
		throw new UnsupportedOperationException("functionality not implemented");
	}
	
	public void setPDDLProblemAsString(final String problem){
		throw new UnsupportedOperationException("functionality not implemented");
	}
	
	public String getPDDLProblemString() {
		throw new UnsupportedOperationException("functionality not implemented");
	}

	public String getPDDLDomainString() {
		throw new UnsupportedOperationException("functionality not implemented");
	}
	
	public String getPDDLProblemFile() {
		throw new UnsupportedOperationException("functionality not implemented");
	}

	public String getPDDLDomainFile() {
		throw new UnsupportedOperationException("functionality not implemented");
	}
	
	

}
