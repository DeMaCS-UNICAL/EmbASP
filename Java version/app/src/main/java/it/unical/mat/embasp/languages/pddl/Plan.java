package it.unical.mat.embasp.languages.pddl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unical.mat.embasp.base.Output;
import it.unical.mat.parsers.pddl.PDDLDataCollection;

/** A simplified solution to a PDDL problem */

public abstract class Plan extends Output implements PDDLDataCollection {
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
		if(actionsObjects == null) {
			actionsObjects = new ArrayList <> ();

			for(final Action action : getActions()) {
				final Object obj = PDDLMapper.getInstance().getObject(action.getName());
				
				if (obj != null)
					actionsObjects.add(obj);
			}
		}

		return actionsObjects;
	}
	
	@Override
	public void storeAction(final String action) {
		actionSequence.add(new Action(action));
	}
}
