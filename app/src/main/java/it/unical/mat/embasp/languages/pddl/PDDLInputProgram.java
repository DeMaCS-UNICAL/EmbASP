package it.unical.mat.embasp.languages.pddl;


import it.unical.mat.embasp.base.InputProgram;


public class PDDLInputProgram extends InputProgram {
	
	private PDDLProgramType programsType;

	public PDDLInputProgram(PDDLProgramType type) {
		super();
		programsType=type;
	}

	public PDDLProgramType getProgramsType() {
		return programsType;
	}
		
}
