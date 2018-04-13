using System.Collections.Generic;

namespace it.unical.mat.embasp.platforms.desktop
{

	using Callback = it.unical.mat.embasp.@base.Callback;
	using Handler = it.unical.mat.embasp.@base.Handler;
	using InputProgram = it.unical.mat.embasp.@base.InputProgram;
	using OptionDescriptor = it.unical.mat.embasp.@base.OptionDescriptor;
	using Output = it.unical.mat.embasp.@base.Output;

	public class DesktopHandler : Handler
	{

		private readonly DesktopService service;

		public DesktopHandler(DesktopService service)
		{
			this.service = service;
		}

		public override void startAsync(Callback c, IList<int> program_index, IList<int> option_index)
		{

			IList<InputProgram> input_programs = collect_programs(program_index);
			IList<OptionDescriptor> input_options = collect_options(option_index);

			service.startAsync(c, input_programs, input_options);

		}

		public override Output startSync(IList<int> program_index, IList<int> option_index)
		{

			IList<InputProgram> input_programs = collect_programs(program_index);
			IList<OptionDescriptor> input_options = collect_options(option_index);

			return service.startSync(input_programs, input_options);
		}
	}

}