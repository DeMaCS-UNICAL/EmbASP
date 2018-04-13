using System.Collections.Generic;

namespace it.unical.mat.embasp.@base
{

	public interface Service
	{

		void startAsync(Callback callback, IList<InputProgram> programs, IList<OptionDescriptor> options);

		Output startSync(IList<InputProgram> programs, IList<OptionDescriptor> options);

	}

}