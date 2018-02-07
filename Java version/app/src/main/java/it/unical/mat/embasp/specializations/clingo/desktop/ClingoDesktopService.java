package it.unical.mat.embasp.specializations.clingo.desktop;

import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.clingo.ClingoAnswerSets;

/** is an extention of {@link DesktopService} for Clingo 's solver */

public class ClingoDesktopService extends DesktopService {

	public ClingoDesktopService(final String exe_path) {
		super(exe_path);
		load_from_STDIN_option = "";
	}

	@Override
	protected Output getOutput(final String output, final String error) {
		return new ClingoAnswerSets(output, error);
	}

}
