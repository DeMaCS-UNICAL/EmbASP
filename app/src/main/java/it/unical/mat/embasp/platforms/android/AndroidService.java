package it.unical.mat.embasp.platforms.android;


import android.content.Context;
import java.util.List;
import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;

/**Implements {@link it.unical.mat.embasp.base.Service} in an Android Context*/

public class AndroidService implements it.unical.mat.embasp.base.Service {
 protected Context context;

 public AndroidService(Context c) {
  context = c;
 }

 /**Android don't have the capability to perform long tasking operation synchronously
  * @see #startSync(List, List)
  * @see android.app.Service*/
 @Override
 public Output startSync(List<InputProgram> programs, List<OptionDescriptor> options) {
  return null;
 }


 /**@see #startAsync(Callback, List, List)*/
 @Override
 public void startAsync(Callback callback, List<InputProgram> programs, List<OptionDescriptor> options) {

 }


}
