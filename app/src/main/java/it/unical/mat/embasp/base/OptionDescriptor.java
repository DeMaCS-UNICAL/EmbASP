package it.unical.mat.embasp.base;

public abstract class OptionDescriptor {
	
	protected StringBuilder options;

	OptionDescriptor(String initial_option) {
		options = new StringBuilder(initial_option);
	}
	
	public OptionDescriptor() {
		options = new StringBuilder();
	}
	
	
	public void addOption(String option){
		options.append(option);
	}
	
	public void removeOption(String option){
		int start_point = options.indexOf(option);
		int end_point = start_point + option.length();
		options.delete(start_point, end_point);
	}
	
	public void clearAll(){
		options.setLength(0);
		options.trimToSize();
	}
}
