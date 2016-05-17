package it.unical.mat.embasp.platforms.android;


import java.util.List;
import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.specializations.dlv.android.DLVAndroidService;

/*This class is a specialization of base.Handler class for Android platform*/

public class AndroidHandler extends Handler {

    /*DLVAndroidService istance , used to start computation*/
    private DLVAndroidService broadcast;



    public AndroidHandler(DLVAndroidService b) {
        broadcast = b;

    }

    @Override
    public void startAsync(Callback c,List<Integer> program_index, List<Integer> option_index ) {
        List<InputProgram>input_programs = collect_programs(program_index);
        List<OptionDescriptor> input_options = collect_options(option_index);
        broadcast.startAsync(c, input_programs, input_options);

    }
}
