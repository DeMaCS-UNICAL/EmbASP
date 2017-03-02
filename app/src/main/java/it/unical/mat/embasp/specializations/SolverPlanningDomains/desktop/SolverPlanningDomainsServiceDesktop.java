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
		//TODO DOMANI LO SISTEMIAMO
		if(programs.isEmpty())
			return null;
		InputProgram ip = programs.get(0);
		if(!(ip instanceof PDDLInputProgram))
			return null;

		PDDLInputProgram pddlIp = (PDDLInputProgram) ip;
		try {
			JSONObject json =  spdu.createJson(pddlIp);
			return getOutput(spdu.postJsonToURL(json.toString()),"");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	protected Output getOutput(String output, String error) {
		return new SolverPlanningDomainPlan(output,error);
	}

}
