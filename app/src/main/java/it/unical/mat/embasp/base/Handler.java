package it.unical.mat.embasp.base;

import java.util.HashMap;
import java.util.Map;

public abstract class Handler {

	protected Map<Integer, InputProgram> programs;
	protected Map<Integer, OptionDescriptor> options;

	public Handler() {
		programs = new HashMap<>();
		options = new HashMap<>();
	}

	public int addProgram(InputProgram i){

		int last_index = programs.size();
		programs.put(last_index++, i);
		return last_index;
	}

	public int addOption(OptionDescriptor o){
		
		int last_index = options.size();
		options.put(last_index++, o);
		return last_index;
	}

	public void removeProgram(int program_id){
		
		programs.remove(program_id);
	}

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

	public void removeOption(int option_id){
		
		options.remove(option_id);
		
	}

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

	public void removeAll(){
		
		programs.clear();
		options.clear();
		
	}

	public void startSync(){} // TODO


	public void startAsync(){} // TODO
}

