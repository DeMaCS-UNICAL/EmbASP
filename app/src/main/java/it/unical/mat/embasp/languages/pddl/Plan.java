package it.unical.mat.embasp.languages.pddl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unical.mat.embasp.base.Output;

/** A simplified solution to a PDDL problem */

public abstract class Plan extends Output implements Cloneable {
	protected List<Action> actionSequence;
	protected String plan;

	public Plan(final String plan) {
		super();
		this.plan = plan;
		actionSequence = new ArrayList<>();
	}
	
	protected  abstract void parse();

	public List<Action> getActions() {
		parse();
		return Collections.unmodifiableList(actionSequence);
	}
}
