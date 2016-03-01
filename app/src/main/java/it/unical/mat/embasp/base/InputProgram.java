package it.unical.mat.embasp.base;

public abstract class InputProgram {

	protected StringBuilder program;
	protected StringBuilder files_paths;

	InputProgram() {
		program = new StringBuilder();
		files_paths = new StringBuilder();
	}

	InputProgram (String s ){
		program = new StringBuilder(s);
		files_paths = new StringBuilder();
	}

	public void addRawInput(String s){
		program.append(s);
	}

	public void addFilesPath(String s){
		files_paths.append(s);
	}
	public void addProgram(String s){
		program.append(s);
	}

	public void clearFilesPaths(){
		files_paths.setLength(0);
		files_paths.trimToSize();
	}

	public void clearProgram(){
		program.setLength(0);
		program.trimToSize();
	}

	public void clearAll(){
		clearFilesPaths();
		clearProgram();
	}

}
