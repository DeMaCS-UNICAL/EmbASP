package it.unical.mat.embasp.languages.pddl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unical.mat.embasp.base.Output;

/** A simplified solution to a PDDL problem */

public abstract class Plan extends Output {
	protected List<Action> actionSequence;

	private List<Object> actionsObjects;

	public Plan(final String plan, final String error) {
		super(plan, error);
	}

	public List<Action> getActions() {
		if (actionSequence == null) {
			actionSequence = new ArrayList<>();
			parse();
		}

		return Collections.unmodifiableList(actionSequence);
	}

	public List<Object> getActionsObjects() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		if (actionsObjects == null) {
			String atomsList = "";
			
			for(final Action action : actionSequence)
				atomsList += action.getName() + '\n';
			
			actionsObjects = (List<Object>) PDDLMapper.getInstance().getObjects(atomsList);
		}

		return actionsObjects;
	}
}
