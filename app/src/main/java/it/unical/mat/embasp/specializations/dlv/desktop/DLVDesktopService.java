package it.unical.mat.embasp.specializations.dlv.desktop;

import java.util.List;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.dlv.DLVAnswerSets;

public class DLVDesktopService extends DesktopService{



	public DLVDesktopService(String exe_path) {
		this.exe_path = exe_path;
	}



	@Override
	public Output startSync(List<InputProgram> programs,
			List<OptionDescriptor> options) {

		return new DLVAnswerSets(super.startSync(programs, options).getOutput());
	}


	@Override
	public void startAsync(final Callback callback, final List<InputProgram> programs,
			final List<OptionDescriptor> options) {

		startAsync(callback, programs, options);
	}
}
