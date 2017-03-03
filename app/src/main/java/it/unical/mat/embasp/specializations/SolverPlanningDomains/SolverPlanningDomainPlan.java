package it.unical.mat.embasp.specializations.SolverPlanningDomains;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.unical.mat.embasp.languages.pddl.Action;
import it.unical.mat.embasp.languages.pddl.Plan;

public class SolverPlanningDomainPlan extends Plan {
	
	public SolverPlanningDomainPlan(String plan,String error) {
		super(plan,error);
	}
	
	@Override
	protected void parse(){
		if(errors!="" || output=="")return;
		
		JSONParser parser=new JSONParser();
		Object obj;
		try {
			obj = parser.parse(output);
			JSONArray arrayPlan = (JSONArray) ((JSONObject) ((JSONObject)obj).get("result")).get("plan");
			for(int i=0;i<arrayPlan.size();i++)
				actionSequence.add(new Action(((JSONObject)arrayPlan.get(i)).get("name").toString()));
		} catch (ParseException e) {
			errors+=" ParseException : "+e.getMessage();
		}
	}

}
