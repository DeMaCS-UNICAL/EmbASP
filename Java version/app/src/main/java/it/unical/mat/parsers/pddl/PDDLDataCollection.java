package it.unical.mat.parsers.pddl;

import it.unical.mat.parsers.pddl.solver_planning_domains.SPDGrammarBaseVisitorImplementation;

public interface PDDLDataCollection {
	public void storeAction(final String action);
	
	public static String parseSolverPlanningDomains(final PDDLDataCollection actions, final String spdOutput) {
		return SPDGrammarBaseVisitorImplementation.parse(actions, spdOutput);
	}
}
