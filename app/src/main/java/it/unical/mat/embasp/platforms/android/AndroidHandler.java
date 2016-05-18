package it.unical.mat.embasp.platforms.android;


import android.content.Context;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;

/*This class is a specialization of base.Handler class for Android platform*/

public class AndroidHandler extends Handler {

    /*AndroidService istance , used to start computation*/
    private AndroidService service;



    public AndroidHandler(Context c , Class<?> b) {
        try {

            service = (AndroidService) Class.forName(b.getName()).getDeclaredConstructor(Context.class).newInstance(c);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startAsync(Callback c,List<Integer> program_index, List<Integer> option_index ) {
        List<InputProgram>input_programs = collect_programs(program_index);
        List<OptionDescriptor> input_options = collect_options(option_index);
        service.startAsync(c, input_programs, input_options);

    }
}
