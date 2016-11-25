package it.unical.mat.embasp.specializations.clingo.desktop;

import java.util.List;

import it.unical.mat.embasp.asp.AnswerSets;
import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.clingo.ClingoAnswerSets;

/**is an extention of {@link DesktopService} for Clingo 's solver*/

public class ClingoDesktopService extends DesktopService {

    public ClingoDesktopService(String exe_path) {
        super(exe_path);
		this.load_from_STDIN_option = "";
    }

    @Override
    public Output startSync(List<InputProgram> programs, List<OptionDescriptor> options) {

        return super.startSync(programs, options);
    }

    @Override
    protected Output getOutput(String output, String error) {
        return new ClingoAnswerSets(output, error);
    }

    @Override
    public void startAsync(final Callback callback, final List<InputProgram> programs, final List<OptionDescriptor> options) {
        super.startAsync(callback, programs, options);
    }
}
