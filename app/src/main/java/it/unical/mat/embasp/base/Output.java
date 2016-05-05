package it.unical.mat.embasp.base;
/* output class rapresents a generic output */
public abstract class Output {

	protected String output;

	public Output(String initial_output) {
		output = initial_output;
	}

	public Output(){
		output = new String();
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

}
