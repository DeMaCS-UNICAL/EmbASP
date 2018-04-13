using System.Collections.Generic;

namespace it.unical.mat.embasp.specializations.dlv2.desktop
{

	using Callback = it.unical.mat.embasp.@base.Callback;
	using InputProgram = it.unical.mat.embasp.@base.InputProgram;
	using OptionDescriptor = it.unical.mat.embasp.@base.OptionDescriptor;
	using Output = it.unical.mat.embasp.@base.Output;
	using DesktopService = it.unical.mat.embasp.platforms.desktop.DesktopService;

	public class DLV2DesktopService : DesktopService
	{

		private readonly OptionDescriptor competitionOutputOption;

		public DLV2DesktopService(string exe_path) : base(exe_path)
		{
			load_from_STDIN_option = "--stdin";
			competitionOutputOption = new OptionDescriptor("--competition-output");
		}

		protected internal override Output getOutput(string output, string error)
		{
			return new DLV2AnswerSets(output, error);
		}

		public virtual void startAsync(Callback callback, IList<InputProgram> programs, IList<OptionDescriptor> options)
		{
			options.Add(competitionOutputOption);
			base.startAsync(callback, programs, options);
		}

		public override Output startSync(IList<InputProgram> programs, IList<OptionDescriptor> options)
		{
			options.Add(competitionOutputOption);
			return base.startSync(programs, options);
		}
	}

}