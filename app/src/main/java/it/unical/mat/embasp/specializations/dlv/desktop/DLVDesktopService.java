package it.unical.mat.embasp.specializations.dlv.desktop;

import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.dlv.DLVAnswerSets;

/** DLV Solver for Desktop platforms */

public class DLVDesktopService extends DesktopService {

	public DLVDesktopService(final String exe_path) {
		super(exe_path);
		load_from_STDIN_option = "--";
	}

	@Override
	protected Output getOutput(final String output, final String error) {
		return new DLVAnswerSets(output, error);
	}

}
