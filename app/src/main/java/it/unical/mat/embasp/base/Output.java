package it.unical.mat.embasp.base;

/** represents a generic output for a solver*/
public abstract class Output implements Cloneable {
	/**Variable in witch results are stored*/
	protected String output;

	public Output(String initial_output) {
		output = initial_output;
	}

	public Output() {
		output = new String();
	}


	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
