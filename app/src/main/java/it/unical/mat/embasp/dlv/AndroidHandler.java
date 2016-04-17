package it.unical.mat.embasp.dlv;

/**
 * Created by haze on 4/17/16.
 */
import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Service;
import it.unical.mat.embasp.dlv.AndroidDLVSerice;

public class AndroidHandler extends Handler {

    private Context co;
    private Service s;
    public AndroidHandler(Context c) {
        this.co = c;
    }

    //TODO check null
    @Override
    public void startAsync(Callback c,List<Integer> program_index, List<Integer> option_index ) {


        List<InputProgram> input_programs = new ArrayList<InputProgram>();

        if(program_index.isEmpty()) {

            for (Map.Entry<Integer, InputProgram> program : this.programs.entrySet()) {
                input_programs.add(this.programs.get(program.getKey()));
            }

        }else{
            for(int index : program_index){
                input_programs.add(this.programs.get(index));

            }
        }

        List<OptionDescriptor> input_option_index = new ArrayList<OptionDescriptor>();

        if(option_index.isEmpty()){

            for (Map.Entry<Integer, OptionDescriptor> option: this.options.entrySet()) {
                input_option_index.add(this.options.get(option.getKey()));
            }

        }else{

            for(int index : option_index){
                input_option_index.add(this.options.get(index));
            }

        }
        co.bindService();
        service.startAsync(c,input_programs,input_option_index);
    }
}
