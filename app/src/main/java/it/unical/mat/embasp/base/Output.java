package it.unical.mat.embasp.base;
/* output class rapresents a generic ASP output */
public abstract class Output {

    /*output formatted in ASP fashion*/
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
