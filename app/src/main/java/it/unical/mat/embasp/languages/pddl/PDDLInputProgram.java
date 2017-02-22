package it.unical.mat.embasp.languages.pddl;

import it.unical.mat.embasp.base.InputProgram;

/** a generic ASP program , with the capabilities of retrieve data by objects */

public class PDDLInputProgram extends InputProgram {

	public PDDLInputProgram() {
		super();
	}

	public PDDLInputProgram(final String domainFilePath, final String problemFilePath) {
		super();
		addFilesPath(domainFilePath);
		addFilesPath(problemFilePath);
	}

}
