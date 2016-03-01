package it.unical.mat.embasp.base;

public abstract class Output {

	protected String Output;

	public Output(String o) {
		Output = o;
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
