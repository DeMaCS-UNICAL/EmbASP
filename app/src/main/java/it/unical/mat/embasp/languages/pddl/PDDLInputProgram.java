package it.unical.mat.embasp.languages.pddl;

import it.unical.mat.embasp.base.InputProgram;

public class PDDLInputProgram extends InputProgram {

	private final PDDLProgramType programsType;

	public PDDLInputProgram(final PDDLProgramType type) {
		super();
		programsType = type;
	}

	public PDDLProgramType getProgramsType() {
		return programsType;
	}

}
