package it.unical.mat.embasp.dlv;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public class AndroidHandler extends Handler {

    private Context context;
    private DLVService mService;
    private boolean bound;


    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            DLVService.DLVBinder binder = (DLVService.DLVBinder) service;
            mService = binder.getService();
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            bound = false;
        }
    };


    public AndroidHandler(Context c) {
        this.context = c;

        Intent intent = new Intent(context, DLVService.class);
        context.bindService(intent, mConnection, context.BIND_AUTO_CREATE);



    }

    //TODO check null
    @Override
    public void startAsync(Callback c,List<Integer> program_index, List<Integer> option_index ) {


        List<InputProgram> input_programs = new ArrayList<InputProgram>();

        if(program_index.isEmpty() || program_index == null) {

            for (Map.Entry<Integer, InputProgram> program : this.programs.entrySet()) {
                input_programs.add(this.programs.get(program.getKey()));
            }

        }else{
            for(int index : program_index){
                input_programs.add(this.programs.get(index));

            }
        }

        List<OptionDescriptor> input_option = new ArrayList<OptionDescriptor>();

        if(option_index.isEmpty()|| option_index == null){

            for (Map.Entry<Integer, OptionDescriptor> option: this.options.entrySet()) {
                input_option.add(this.options.get(option.getKey()));
            }

        }else{

            for(int index : option_index ){
                input_option.add(this.options.get(index));
            }

        }

        mService.startAsync(c,input_programs,input_option);

    }
}
