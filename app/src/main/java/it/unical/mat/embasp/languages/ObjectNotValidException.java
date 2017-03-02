package it.unical.mat.embasp.languages;

public class ObjectNotValidException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotValidException() {
		super("Value of the object is not valid");
	}

}
