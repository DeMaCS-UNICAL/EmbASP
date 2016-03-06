package it.unical.mat.embasp.base;

public abstract class OptionDescriptor {
	
	protected String options;

	OptionDescriptor(String initial_option) {
		options = new String(initial_option);
	}
	
	public OptionDescriptor() {
		options = new String();
	}
	
	
	public void setOption(String option){ 
		options = option;
	}
	
	public void removeOption(String option){
		
		options = "";
	}
	
	public void clearAll(){
		options = "";
	}
}
