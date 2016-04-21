package it.unical.mat.embasp.base;

import java.util.ArrayList;
import java.util.List;

import it.unical.mat.embasp.asp.ASPMapper;
/*This class rappresents a generic ASP program, it have a string rapresenting the entire ASP program
* and a list of files */


//TODO SUBCLASS with ojbects
public class InputProgram {
	/*The variable in wich ASP program is stored*/
	protected String program;
	/*The varible in wich ASP files are stored*/
	protected List<String> files_paths; 

	public InputProgram() {
		init();
	}

	public InputProgram (String initial_program ){
		init();
		program = initial_program;
	}
	
	private void init(){
		program = new String();
		files_paths = new ArrayList<>();
	}


	public void addObjectInput(Object inputObj){
		program += " " + ASPMapper.getInstance().getString();
	}

	public String getProgram (){
		return program;
	}

	public String getFiles(){
	return files_paths.toString();
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
