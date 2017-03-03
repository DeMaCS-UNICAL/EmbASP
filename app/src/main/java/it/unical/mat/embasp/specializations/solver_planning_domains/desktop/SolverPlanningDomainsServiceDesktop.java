package it.unical.mat.embasp.specializations.solver_planning_domains.desktop;

import java.util.List;

import org.json.simple.JSONObject;

import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.pddl.PDDLInputProgram;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.solver_planning_domains.SolverPlanningDomainPlan;
import it.unical.mat.embasp.specializations.solver_planning_domains.SolverPlanningDomainsUtility;

public class SolverPlanningDomainsServiceDesktop extends DesktopService {

	private final SolverPlanningDomainsUtility spdu;

	public SolverPlanningDomainsServiceDesktop() {
		super("");
		spdu = new SolverPlanningDomainsUtility();
	}

	@Override
	protected Output getOutput(final String output, final String error) {
		return new SolverPlanningDomainPlan(output, error);
	}

	@Override
	public Output startSync(final List<InputProgram> programs, final List<OptionDescriptor> options) {

		if (programs.isEmpty())
			return getOutput("", "PDDLInputProgram not defined");

		if (programs.size() > 1)
			return getOutput("", "For PDDL you must specify just a PDDLInputProgram");

		final InputProgram ip = programs.get(0);
		if (!(ip instanceof PDDLInputProgram))
			return getOutput("", "InputProgram is not of type PDDLInputProgram");

		final PDDLInputProgram pddlIp = (PDDLInputProgram) ip;
		try {
			final JSONObject json = spdu.createJson(pddlIp);
			return getOutput(spdu.postJsonToURL(json.toString()), "");
		} catch (final Exception e) {
			return getOutput("", "Error : " + e.getMessage());
		}
	}

}
