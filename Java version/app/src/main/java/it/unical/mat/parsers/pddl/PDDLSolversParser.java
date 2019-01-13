package it.unical.mat.parsers.pddl;

import it.unical.mat.parsers.pddl.solver_planning_domains.SPDGrammarBaseVisitorImplementation;

public final class PDDLSolversParser {
	private PDDLSolversParser() {
		
	}
	
	public static String parseSolverPlanningDomains(final PDDLDataCollection actions, final String spdOutput, final boolean two_stageParsing) {
		return SPDGrammarBaseVisitorImplementation.parse(actions, spdOutput, two_stageParsing);
	}
}
