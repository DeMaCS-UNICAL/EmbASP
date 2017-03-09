package it.unical.mat.embasp.specializations.dlv2.desktop;

import java.util.List;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.dlv2.DLV2AnswerSets;

/** is an extention of {@link DesktopService} for DLV2 's solver */

public class DLV2DesktopService extends DesktopService {

	private final OptionDescriptor competitionOutputOption;

	public DLV2DesktopService(final String exe_path) {
		super(exe_path);
		load_from_STDIN_option = "--stdin";
		competitionOutputOption = new OptionDescriptor("--competition-output");
	}

	@Override
	protected Output getOutput(final String output, final String error) {
		return new DLV2AnswerSets(output, error);
	}

	@Override
	public void startAsync(final Callback callback, final List<InputProgram> programs, final List<OptionDescriptor> options) {
		super.startAsync(callback, programs, options);
	}

	@Override
	public Output startSync(final List<InputProgram> programs, final List<OptionDescriptor> options) {
		options.add(competitionOutputOption);
		return super.startSync(programs, options);
	}
}
