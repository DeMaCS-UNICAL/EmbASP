package it.unical.mat.embasp.specializations.dlv.desktop;


import it.unical.mat.embasp.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.dlv.DLVAnswerSets;


/**DLV Solver for Desktop platforms*/


public class DLVDesktopService extends DesktopService{



	public DLVDesktopService(String exe_path) {
		super(exe_path);
	}




	@Override
	protected AnswerSets getAnswerSet(String output) {
		return new DLVAnswerSets(output);
	}


}
