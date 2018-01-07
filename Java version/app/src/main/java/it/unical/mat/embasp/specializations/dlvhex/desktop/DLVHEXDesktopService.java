package it.unical.mat.embasp.specializations.dlvhex.desktop;

import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.dlvhex.DLVHEXAnswerSets;

public class DLVHEXDesktopService extends DesktopService {

	public DLVHEXDesktopService(final String exe_path) {
		super(exe_path);
		
		load_from_STDIN_option = "--";
	}

	@Override
	protected Output getOutput(final String output, final String error) {
		return new DLVHEXAnswerSets(output, error);
	}
}
