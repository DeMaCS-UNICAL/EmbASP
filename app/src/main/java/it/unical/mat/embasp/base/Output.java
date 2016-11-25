package it.unical.mat.embasp.base;

/** represents a generic output for a solver*/
public abstract class Output implements Cloneable {
	/**Variable in which results are stored*/
	protected String output;
	/**The errors thrown by the solver*/
	protected String errors;

	public Output(String initial_output) {
		output = initial_output;
	}

	public Output() {
		output = new String();
	}

	public Output(String out, String err) {
		output = out;
		errors = err;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String err) {
		this.errors = err;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
