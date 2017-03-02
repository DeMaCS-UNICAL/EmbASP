package it.unical.mat.embasp.languages.pddl;

import it.unical.mat.embasp.base.InputProgram;


public class PDDLInputProgram extends InputProgram {
	
	private String PDDLproblem;
	private String PDDLdomain;

	public PDDLInputProgram() {
		super();
	}
	
	public PDDLInputProgram(final String domainFilePath, final String problemFilePath) {
		super();
		addFilesPath(domainFilePath);
		addFilesPath(problemFilePath);
	}
	
	@Override
	public void addProgram(final String new_instruction) {
		throw new UnsupportedOperationException("functionality not implemented");
	}

	@Override
	public void clearPrograms() {
		throw new UnsupportedOperationException("functionality not implemented");
	}

	@Override
	public String getPrograms() {
		throw new UnsupportedOperationException("functionality not implemented");
	}

	@Override
	public void setPrograms(final String programs) {
		throw new UnsupportedOperationException("functionality not implemented");
	}

	@Override
	public void setPDDLDomainAndProblemFiles(final String d,final String s){
		clearFilesPaths();
		addFilesPath(d);
		addFilesPath(s);
	}
	
	@Override
	public void setPDDLDomainAndProblemAsStrings(final String p,final String d){
		PDDLproblem=p;
		PDDLdomain=d;
	}

	@Override
	public String getPDDLProblemString() {
		return PDDLproblem;
	}

	@Override
	public String getPDDLDomainString() {
		return PDDLdomain;
	}


	@Override
	public String getPDDLProblemFile() {
		return (files_paths.size()>1)?files_paths.get(1):"";
	}

	@Override
	public String getPDDLDomainFile() {
		return (files_paths.size()>0)?files_paths.get(0):"";
	}

}
