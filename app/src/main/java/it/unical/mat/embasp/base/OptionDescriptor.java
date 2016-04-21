package it.unical.mat.embasp.base;


/* This class rapresents options for a program */
public class OptionDescriptor {
	/*Variable in wich options are stored*/
	protected String options;

	public OptionDescriptor(String initial_option) {
		options = new String(initial_option);
	}
	
	public OptionDescriptor() {
		options = new String();
	}

	public String getOptions(){
		return options;
	}

	public void setOption(String option){ 
		options = option;
	}

	/*Clears options variable*/
	public void clear(){
		
		options = "";
	}
}
