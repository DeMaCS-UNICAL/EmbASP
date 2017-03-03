package it.unical.mat.embasp.specializations.SolverPlanningDomains.desktop;

import java.util.List;

import org.json.simple.JSONObject;

import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.pddl.PDDLInputProgram;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.SolverPlanningDomains.SolverPlanningDomainPlan;
import it.unical.mat.embasp.specializations.SolverPlanningDomains.SolverPlanningDomainsUtility;

public class SolverPlanningDomainsServiceDesktop extends DesktopService {

	private SolverPlanningDomainsUtility spdu;
	
	public SolverPlanningDomainsServiceDesktop() {
		super("");
		spdu = new SolverPlanningDomainsUtility();
	}

	@Override
	public Output startSync(List<InputProgram> programs, List<OptionDescriptor> options) {
		String error="";
		if(programs.isEmpty())
			return getOutput("","PDDLInputProgram not defined");
		
		if(programs.size()>1)
			return getOutput("", "For PDDL you must specify just a PDDLInputProgram");
		
		InputProgram ip = programs.get(0);
		if(!(ip instanceof PDDLInputProgram))
			return getOutput("", "InputProgram is not of type PDDLInputProgram");

		PDDLInputProgram pddlIp = (PDDLInputProgram) ip;
		try {
			JSONObject json =  spdu.createJson(pddlIp);
			return getOutput(spdu.postJsonToURL(json.toString()),"");
		} catch (Exception e) {
			return getOutput("", "Error : "+e.getMessage());
		}
	}

	@Override
	protected Output getOutput(String output, String error) {
		return new SolverPlanningDomainPlan(output,error);
	}

}
