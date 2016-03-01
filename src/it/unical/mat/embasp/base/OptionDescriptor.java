package it.unical.mat.embasp.base;

public abstract class OptionDescriptor {
	
	protected StringBuilder options;

	OptionDescriptor(String s) {
		options = new StringBuilder(s);
	}
	
	public OptionDescriptor() {
		options = new StringBuilder();
	}
	
	
	public void addOption(String s){
		options.append(s);
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
