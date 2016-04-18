package it.unical.mat.embasp.base;

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
		programs.put(last_index++, i);
		return last_index;
	}

    /*This method is used to add a new option to the options set.*/
	public int addOption(OptionDescriptor o){
		
		int last_index = options.size();
		options.put(last_index++, o);
		return last_index;
	}

    /* This method is used to remove a single program from the programs set.*/
	public void removeProgram(int program_id){
		
		programs.remove(program_id);
	}

    /* Given an InputProgram P this method removes every InputProgram that returns equals to P.*/
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

    /*Given an OptionDescriptor O this method removes every OptionDescriptor that results equal to O.*/
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


	public InputProgram getInputProgram (int key){
	return programs.get(key);
	}

	public void startSync(List<Integer> program_index,List<Integer> option_index){
	}


	public void startAsync(Callback c ,List<Integer> program_index,List<Integer> option_index){
    }
}

