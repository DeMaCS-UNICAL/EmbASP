package it.unical.mat.embasp.base;

import java.io.InputStream;
import java.util.List;

/*Rapresents a group of functions used to execute solver , consists in two types of methods.*/
public interface Service{

	/* starSync() starts computation Syncronously , the parameters are a list of programs and option to be processed.
	* Return an output (class) filled with computation's results */
	public Output startSync(List<InputProgram> programs , List<OptionDescriptor> options);

	/* startAsync() starts computation Asyncronously , the parameters are a list of programs and options to be processed and
	* a callback used to notify the user when computation is completed*/
	public void startAsync(Callback callback , List<InputProgram>programs , List<OptionDescriptor> options);
	
}
