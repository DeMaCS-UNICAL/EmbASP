package it.unical.mat.embasp.base;

import java.util.ArrayList;
import java.util.List;

public abstract class InputProgram {

	protected String program; 
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

	public void addRawInput(String raw_input){
		program += raw_input;
	}

	public void addFilesPath(String file_path){
		files_paths.add(file_path);
	}
	public void addProgram(String program){
		this.program = program;
	}

	public void clearFilesPaths(){
		files_paths.clear();
	}

	public void clearProgram(){
		program = "";
	}

	public void clearAll(){
		clearFilesPaths();
		clearProgram();
	}

}
