package it.unical.mat.embasp.languages.asp;

public class PredicateNotValidException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public PredicateNotValidException() {
		super("Value of predicate is not valid");
	}

}
