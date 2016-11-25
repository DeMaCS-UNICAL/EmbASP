package it.unical.mat.embasp.specializations.dlv.desktop;


import it.unical.mat.embasp.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.dlv.DLVAnswerSets;


/**DLV Solver for Desktop platforms*/


public class DLVDesktopService extends DesktopService{



	public DLVDesktopService(String exe_path) {
		super(exe_path);
		this.load_from_STDIN_option = "--";
	}




	@Override
	protected Output getOutput(String output, String error) {
		return new DLVAnswerSets(output, error);
	}


}
