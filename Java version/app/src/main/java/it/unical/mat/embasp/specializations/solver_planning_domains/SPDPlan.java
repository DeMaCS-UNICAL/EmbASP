package it.unical.mat.embasp.specializations.solver_planning_domains;

import it.unical.mat.embasp.languages.pddl.Plan;
import it.unical.mat.parsers.pddl.PDDLSolversParser;

public class SPDPlan extends Plan {

	public SPDPlan(final String plan, final String error) {
		super(plan, error);
	}

	@Override
	protected void parse() {
		if((errors != null && !errors.isEmpty()) || (output != null && output.isEmpty()))
		    return;
		
		errors += PDDLSolversParser.parseSolverPlanningDomains(this, output, true);
	}

}
