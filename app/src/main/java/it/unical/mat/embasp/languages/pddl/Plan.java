package it.unical.mat.embasp.languages.pddl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unical.mat.embasp.base.Output;

/** A simplified solution to a PDDL problem */

public abstract class Plan extends Output implements Cloneable {
	protected List<Action> actionSequence;

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
}
