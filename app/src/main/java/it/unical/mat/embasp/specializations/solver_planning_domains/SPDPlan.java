package it.unical.mat.embasp.specializations.solver_planning_domains;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import it.unical.mat.embasp.languages.pddl.Action;
import it.unical.mat.embasp.languages.pddl.Plan;

public class SPDPlan extends Plan {

	public SPDPlan(final String plan, final String error) {
		super(plan, error);
	}

	@Override
	protected void parse() {
		if (errors != "" || output == "")
			return;
		JsonObject obj;
		try {
			obj = (JsonObject) Jsoner.deserialize(output);
			final String status = (String) obj.get("status");
			if (status.contains("ok")) {
				final JsonArray arrayPlan = (JsonArray) ((JsonObject) obj.get("result")).get("plan");
				for (int i = 0; i < arrayPlan.size(); i++)
					actionSequence.add(new Action(((JsonObject) arrayPlan.get(i)).get("name").toString()));
			} else {
				final Object resultObj = obj.get("result");
				errors += resultObj instanceof JsonObject ? " " + (String) ((JsonObject) resultObj).get("error") : resultObj.toString();
			}
		} catch (final DeserializationException e) {
			errors += " ParseException : " + e.getMessage();
		}
	}

}
