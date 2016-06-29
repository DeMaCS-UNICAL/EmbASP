package it.unical.mat.embasp.base;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.unical.mat.embasp.asp.ASPMapper;
import it.unical.mat.embasp.asp.IllegalTermException;


/**Represents a generic ASP option*/

public class InputProgram {
	/**where ASP programs data is stored*/
	protected String programs;
	/**where associated files are stored*/
	protected List<String> files_paths;
	/**used as separator for programs*/
	protected String separator;


	/**Creates a new programs , setting space " " as separator*/
	public InputProgram() {
		init();
		separator = " ";
	}

	/**instantiate a new {@link InputProgram}
	 * @param inputObj Object used to retrieve data from
	 * @see #addObjectInput(Object) */
	public InputProgram(Object inputObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalTermException {
		init();
		addObjectInput(inputObj);
	}

	public InputProgram(String initial_program) {
		init();
		programs = initial_program;
	}

	private void init() {
		programs = new String();
		files_paths = new ArrayList<>();
	}

	/**Set programs separator to current value
	 * @param separator used as new separator*/
	public void setSeparator(String separator){
		this.separator = separator;
	}


	/**get separator character
	 * @return separator*/
	public String getSeparator(){
		return separator;
	}


	/**transforms a given Object class into a {@link InputProgram} and adds it to the current {@link #programs}
	 * @param inputObj an object to be transformed
	 * @see ASPMapper
	 * @throws IllegalAccessException , IllegalArgumentException , InvocationTargetException , NoSuchMethodException , SecurityException , IllegalTermException*/
	public void addObjectInput(Object inputObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalTermException {
		throw new UnsupportedOperationException("functionality not implemented");
	}

	/**transforms a set of Object class into a {@link InputProgram} and adds them to the current {@link #programs}
	 * @param inputObjs a set of Objects to be transformed
	 * @see #addObjectInput(Object)
	 */
	public void addObjectsInput(Set<Object> inputObjs) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalTermException {
		for (Object inputObj : inputObjs)
			addObjectInput(inputObj);
	}

	/**Returns data stored in {@link #programs}*/
	public String getPrograms() {
		return programs;
	}

	/** Returns files paths for this programs
	 * @return String concatenating files paths*/
	public String getFilesPaths() {

		StringBuilder to_return = new StringBuilder();

		for (String paths : files_paths)
			if (paths.length() != 0)
				to_return.append(paths).append(" ");

		return to_return.toString();
	}

	/**Adds a new instruction directly into {@link #programs}
	 * @param new_instruction a new programs instruction*/
	public void addProgram(String new_instruction) {
		if(programs.isEmpty()){
			programs = new_instruction;
		}else{
			programs +=separator+new_instruction;
		}
	}

	/** add a new file path into {@link #files_paths}
	 * @param file_path a new file path*/
	public void addFilesPath(String file_path) {
		files_paths.add(file_path);
	}

	/**sets {@link #programs } value to the new given one
	 * @parm programs new value
	 */
	public void setPrograms(String programs) {
		this.programs = programs;
	}

	/**After this method {@link #files_paths} will be empty*/
	public void clearFilesPaths() {
		files_paths.clear();
	}

	/**After this method {@link #programs} will be empty*/
	public void clearPrograms() {
		programs = "";
	}

	/**After this method both {@link #files_paths} and {@link #programs} will be empty*/
	public void clearAll() {
		clearFilesPaths();
		clearPrograms();
	}

}
