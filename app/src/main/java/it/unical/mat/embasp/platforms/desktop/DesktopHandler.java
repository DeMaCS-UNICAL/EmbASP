package it.unical.mat.embasp.platforms.desktop;

import java.util.List;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;

/**
 * is a specialization for a Desktop platform
 *
 * @see Handler
 */

public class DesktopHandler extends Handler {

	private final DesktopService service;

	public DesktopHandler(final DesktopService service) {
		this.service = service;
	}

	/** @see it.unical.mat.embasp.base.Service#startAsync(Callback, List, List) */
	@Override
	public void startAsync(final Callback c, final List<Integer> program_index, final List<Integer> option_index) {

		final List<InputProgram> input_programs = collect_programs(program_index);
		final List<OptionDescriptor> input_options = collect_options(option_index);

		service.startAsync(c, input_programs, input_options);

	}

	/** @see it.unical.mat.embasp.base.Service#startAsync(Callback, List, List) */
	@Override
	public Output startSync(final List<Integer> program_index, final List<Integer> option_index) {

		final List<InputProgram> input_programs = collect_programs(program_index);
		final List<OptionDescriptor> input_options = collect_options(option_index);

		return service.startSync(input_programs, input_options);
	}
}
