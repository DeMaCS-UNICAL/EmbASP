package it.unical.mat.embasp.platforms.desktop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;

public class DesktopHandler extends Handler{
	private DesktopService service;

	public DesktopHandler(DesktopService service) {
		this.service = service;
	}
	
	@Override
	public void startAsync(Callback c, List<Integer> program_index,
			List<Integer> option_index) {
		

		List<InputProgram> input_programs = new ArrayList<InputProgram>();
		
		        if(program_index.isEmpty() || program_index == null) {
		
		            for (Map.Entry<Integer, InputProgram> program : this.programs.entrySet()) {
		                input_programs.add(this.programs.get(program.getKey()));
		            }
		
		        }else{
		            for(int index : program_index){
		                input_programs.add(this.programs.get(index));
		
		            }
		        }
		
		        List<OptionDescriptor> input_option = new ArrayList<OptionDescriptor>();
		
		        if(option_index.isEmpty()|| option_index == null){
		
		            for (Map.Entry<Integer, OptionDescriptor> option: this.options.entrySet()) {
		                input_option.add(this.options.get(option.getKey()));
		            }
		
		        }else{
		
		            for(int index : option_index ){
		                input_option.add(this.options.get(index));
		            }
		
		        }
		       
		        service.startAsync(c, input_programs, input_option);
		        
	}
	
	
	@Override
	public Output startSync(List<Integer> program_index,
			List<Integer> option_index) {
		
		List<InputProgram> input_programs = new ArrayList<InputProgram>();
		
        if(program_index.isEmpty() || program_index == null) {

            for (Map.Entry<Integer, InputProgram> program : this.programs.entrySet()) {
                input_programs.add(this.programs.get(program.getKey()));
            }

        }else{
            for(int index : program_index){
                input_programs.add(this.programs.get(index));

            }
        }

        List<OptionDescriptor> input_option = new ArrayList<OptionDescriptor>();

        if(option_index.isEmpty()|| option_index == null){

            for (Map.Entry<Integer, OptionDescriptor> option: this.options.entrySet()) {
                input_option.add(this.options.get(option.getKey()));
            }

        }else{

            for(int index : option_index ){
                input_option.add(this.options.get(index));
            }

        }
		
      return service.startSync(input_programs, input_option);
	}
}
