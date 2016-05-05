package it.unical.mat.embasp.base;

import it.unical.mat.embasp.asp.ASPMapper;
import it.unical.mat.embasp.asp.IllegalTermException;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;




//TODO SUBCLASS with ojbects
public class InputProgram {
	/*The variable in wich ASP program is stored*/
	protected String program;
	/*The varible in wich ASP files are stored*/
	protected List<String> files_paths;

	public InputProgram() {
		init();
	}


	public InputProgram(Object inputObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalTermException{
		init();
		addObjectInput(inputObj);
	}

	public InputProgram (String initial_program ){
		init();
		program = initial_program;
	}

	private void init(){
		program = new String();
		files_paths = new ArrayList<>();
	}

	//TODO constructor with objects

	/*This function is used to add a single Object as input */
	public void addObjectInput(Object inputObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalTermException {
		program += ASPMapper.getInstance().getString(inputObj)+".";
	}

	/*This function is used to add a set of Objects as input*/
	public void addObjectsInput(Set<Object> inputObjs) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalTermException {
		for(Object inputObj:inputObjs)
			addObjectInput(inputObj);
	}

	/*Returns the stored program*/
	public String getProgram (){
		return program;
	}

	/*Returns a string rapresentigs all files paths for this program*/
	public String getFiles(){

		StringBuilder to_return = new StringBuilder();

		for(String paths : files_paths)
			if(paths.length()!= 0)
				to_return.append(paths).append(" ");

		return to_return.toString();
	}

	/*Add a new istruction directly into program */
	public void addRawInput(String raw_input){
		program += raw_input;
	}

	/* add a new file to be processed with the program*/
	public void addFilesPath(String file_path){
		files_paths.add(file_path);
	}

	/*change program value to the new one*/
	public void addProgram(String program){
		this.program = program;
	}

	/*clears file's list*/
	public void clearFilesPaths(){
		files_paths.clear();
	}

	/*clears files value*/
	public void clearProgram(){
		program = "";
	}

	/*clears both program and files_paths*/
	public void clearAll(){
		clearFilesPaths();
		clearProgram();
	}

}
