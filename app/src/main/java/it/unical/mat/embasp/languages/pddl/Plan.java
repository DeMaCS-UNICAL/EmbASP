package it.unical.mat.embasp.languages.pddl;

import java.util.Collections;
import java.util.List;

import it.unical.mat.embasp.base.Output;

/** A simplified solution to a PDDL problem */

public abstract class Plan extends Output implements Cloneable {
	/** Where the solution is stored */
	protected List<Action> actionSequence;


	public Plan(final List<Action> actions) {
		super();
		this.actionSequence = actions;
	}

	public List<Action> getActions() {
		return Collections.unmodifiableList(actionSequence);
	}
}
