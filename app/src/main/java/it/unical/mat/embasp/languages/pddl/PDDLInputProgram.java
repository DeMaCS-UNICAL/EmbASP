package it.unical.mat.embasp.languages.pddl;

import it.unical.mat.embasp.base.InputProgram;


public class PDDLInputProgram extends InputProgram {
	
	private String PDDLproblem;
	private String PDDLdomain;
	private final int DOMAIN_INDEX=0;
	private final int PROBLEM_INDEX=1;

	public PDDLInputProgram() {
		super();
		files_paths.add("");
		files_paths.add("");
		PDDLdomain="";
		PDDLproblem="";
	}
	
	public PDDLInputProgram(final String domainFilePath, final String problemFilePath) {
		super();
		addFilesPath(domainFilePath);
		addFilesPath(problemFilePath);
		PDDLdomain="";
		PDDLproblem="";
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
	public void clearFilesPaths() {
		super.clearFilesPaths();
		files_paths.add("");
		files_paths.add("");
	}
	
	@Override
	public void clearAll() {
		super.clearAll();
		PDDLdomain="";
		PDDLproblem="";
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
	public void setPDDLDomainFile(final String domain){
		files_paths.set(DOMAIN_INDEX, domain);
	}
	@Override
	public void setPDDLProblemFile(final String problem){
		files_paths.set(PROBLEM_INDEX, problem);
	}
	@Override
	public void setPDDLDomainAsString(final String domain){
		PDDLdomain=domain;
	}
	@Override
	public void setPDDLProblemAsString(final String problem){
		PDDLproblem=problem;
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
		return (files_paths.size()>PROBLEM_INDEX)?files_paths.get(PROBLEM_INDEX):"";
	}

	@Override
	public String getPDDLDomainFile() {
		return (files_paths.size()>DOMAIN_INDEX)?files_paths.get(DOMAIN_INDEX):"";
	}

}
