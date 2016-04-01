package it.unical.mat.embasp.base;
/* Output class rapresents a generic ASP output */
public abstract class Output {
    /*Output formatted in ASP style*/
	protected String Output;

	public Output(String initial_output) {
		Output = initial_output;
	}

	public Output(){
		Output = new String();
	}

	public String getOutput() {
		return Output;
	}

	public void setOutput(String output) {
		Output = output;
	}

}
