package it.unical.mat.embasp.base;

/** Represents options for a generic ASP programs */
public class OptionDescriptor {
	/**used as option separator */
	protected String separator;
	/**where options are stored*/
	protected String options;


	public OptionDescriptor(String initial_option) {
		options = new String(initial_option);
	}

	public OptionDescriptor() {
		options = new String();
	}

	/**Returns values stored in {@link #options}
	 * @return {@link #options}'s data in a String format*/
	public String getOptions() {

		return options;
	}

	/**Set {@link #separator} character with new separator*/
	public void setSeparator(String separator){
		this.separator = separator;
	}

	/**concatenate a new option in a String format to the current {@link #options}
	 * @param option String to be concatenated */
	public void addOption(String option){
		if(option.isEmpty()){
			this.options = option;
		}else{
			options +=separator+option;
		}

	}

	/**get separator character*/
	public String getSeparator(){
		return separator;
	}

	public void setOptions(String option) {
		options = option;
	}

	/**after using this method the {@link #options} variable will be empty*/
	public void clear() {

		options = "";
	}
}
