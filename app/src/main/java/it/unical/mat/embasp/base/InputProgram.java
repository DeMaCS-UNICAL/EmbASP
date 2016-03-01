package it.unical.mat.embasp.base;

public abstract class InputProgram {

	protected StringBuilder program;
	protected StringBuilder files_paths;

	InputProgram() {
		program = new StringBuilder();
		files_paths = new StringBuilder();
	}

	InputProgram (String initial_program ){
		program = new StringBuilder(initial_program);
		files_paths = new StringBuilder();
	}

	public void addRawInput(String raw_input){
		program.append(raw_input);
	}

	public void addFilesPath(String file_path){
		files_paths.append(file_path);
	}
	public void addProgram(String program){
		this.program.append(program);
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
