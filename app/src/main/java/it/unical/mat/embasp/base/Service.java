package it.unical.mat.embasp.base;

import java.io.InputStream;
import java.util.List;

/*Rapresents a group of functions used to execute ASP computation , consists in two types of methods.*/
public interface Service{

	/* starSync() starts ASP computation Syncronously , the parameters are a list of programs and option to be processed.
	* Return an Output (class) filled with computation's results */
	public Output startSync(List<InputProgram> programs , List<OptionDescriptor> options);

	/* startAsync() starts ASP computation Asyncronously , the parameters are the a list of programs and options to be processed and
	* a callback used to notify the user when computation is completed*/
	public void startAsync(Callback callback , List<InputProgram>programs , List<OptionDescriptor> options);
	
}