package it.unical.mat.embasp.specializations.clingo.desktop;

import java.util.List;

import it.unical.mat.embasp.asp.AnswerSets;
import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.clingo.ClingoAnswerSets;

public class ClingoDesktopService extends DesktopService {

	public ClingoDesktopService(String exe_path) {
		this.exe_path = exe_path;
	}

    @Override
    public Output startSync(List<InputProgram> programs, List<OptionDescriptor> options) {

        return super.startSync(programs, options);
    }

    @Override
    protected AnswerSets getAnswerSet(String output) {
        return new ClingoAnswerSets(output);
    }

    @Override
    public void startAsync(final Callback callback, final List<InputProgram> programs, final List<OptionDescriptor> options) {
    	super.startAsync(callback, programs, options);
    }
}
