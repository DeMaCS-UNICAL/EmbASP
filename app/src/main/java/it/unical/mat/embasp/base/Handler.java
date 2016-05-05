package it.unical.mat.embasp.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
*   The Handler class substitute the previously ASPHandler class.
*   It contains two types of data, the programs (InputProgram class) and the options (OptionDescriptor),
*   that rapresents a generic ASP program and options.
* */

public abstract class Handler {
	/*The variable in which programs are stored*/
	protected Map<Integer, InputProgram> programs;
	/*The variable in wich options are stored*/
	protected Map<Integer, OptionDescriptor> options;

	public Handler() {
		programs = new HashMap<>();
		options = new HashMap<>();
	}
	/*This method is used to add a new program to the programs set.*/
	public int addProgram(InputProgram i){

		int last_index = programs.size();
		int current_value = last_index;
		programs.put(last_index++, i);
		return current_value;
	}

	/*This method is used to add a new option to the options set.*/
	public int addOption(OptionDescriptor o){

		int last_index = options.size();
		int current_value = last_index;
		options.put(last_index++, o);
		return current_value;
	}

	/* This method is used to remove a single program from the programs set.*/
	public void removeProgram(int program_id){

		programs.remove(program_id);
	}

	/* Given an InputProgram P this method removes every InputProgram instance that returns equals to P.*/
	public boolean removeProgram(InputProgram p){

		boolean result = false;
		for( Map.Entry<Integer, InputProgram> entry : programs.entrySet()){
			if(entry.getValue().equals(p)){
				programs.remove(entry.getKey());
				result=true;
			}
		}
		return result;
	}

	/* This method removes a single options from the options set.*/
	public void removeOption(int option_id){

		options.remove(option_id);

	}

	/*Given an OptionDescriptor O this method removes every OptionDescriptor instance that results equal to O.*/
	public boolean removeOption(OptionDescriptor o){

		boolean result = false;
		for( Map.Entry<Integer, OptionDescriptor> entry : options.entrySet()){
			if(entry.getValue().equals(o)){
				options.remove(entry.getKey());
				result = true;
			}
		}

		return result;

	}

	/* Clear every element in InputProgram and OptionDescriptor sets.*/
	public void removeAll(){

		programs.clear();
		options.clear();

	}

	/*Returns program associated with the key value*/
	public InputProgram getInputProgram (int key){
		return programs.get(key);
	}



	public Output startSync(){

		return startSync((List<Integer>) null, (List<Integer>) null);
	}


	//TO EXPORT
	/*This method have to be implemented by subclasses to execute solver in a syncronous way*/
	public Output startSync(List<Integer> program_index,List<Integer> option_index){
		return null;
	}



	public void startAsync(Callback c){
		startAsync(c, (List<Integer>)null, (List<Integer>)null);
	}
	/*This method have to be implemented by subclasses to execute solver in a asyncronous way*/
	public void startAsync(Callback c ,List<Integer> program_index,List<Integer> option_index){
	}



	protected List<InputProgram> collect_programs(){

		List<InputProgram> input_programs = new ArrayList<InputProgram>();

		if(program_index == null) {

			for (Map.Entry<Integer, InputProgram> program : this.programs.entrySet()) {
				input_programs.add(this.programs.get(program.getKey()));
			}

		}else{
			for(int index : program_index){
				input_programs.add(this.programs.get(index));

			}
		}
		return input_programs;
	}


	protected List<OptionDescriptor> collect_options(){
		List<OptionDescriptor> input_option = new ArrayList<OptionDescriptor>();

		if(option_index == null){

			for (Map.Entry<Integer, OptionDescriptor> option: this.options.entrySet()) {
				input_option.add(this.options.get(option.getKey()));
			}

		}else{

			for(int index : option_index ){
				input_option.add(this.options.get(index));
			}

		}
		return input_option;
	}
}

