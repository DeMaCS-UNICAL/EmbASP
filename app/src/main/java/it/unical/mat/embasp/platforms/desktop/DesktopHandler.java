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


		List<InputProgram>input_programs = collect_programs();
		List<OptionDescriptor> input_options = collect_options();



		service.startAsync(c, input_programs, input_option);

	}


	@Override
	public Output startSync(List<Integer> program_index,
							List<Integer> option_index) {


		List<InputProgram>input_programs = collect_programs();
		List<OptionDescriptor> input_options = collect_options();

		return service.startSync(input_programs, input_option);
	}
}
