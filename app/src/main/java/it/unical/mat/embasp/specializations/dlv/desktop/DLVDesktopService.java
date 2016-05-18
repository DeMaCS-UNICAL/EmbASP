package it.unical.mat.embasp.specializations.dlv.desktop;

import java.util.List;

import it.unical.mat.embasp.asp.AnswerSets;
import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.dlv.DLVAnswerSets;

public class DLVDesktopService extends DesktopService{



	public DLVDesktopService(String exe_path) {
		super(exe_path);
	}




	@Override
	protected AnswerSets getAnswerSet(String output) {
		return new DLVAnswerSets(output);
	}


}
