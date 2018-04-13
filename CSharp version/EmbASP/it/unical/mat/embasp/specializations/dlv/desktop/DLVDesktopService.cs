namespace it.unical.mat.embasp.specializations.dlv.desktop
{
	using Output = it.unical.mat.embasp.@base.Output;
	using DesktopService = it.unical.mat.embasp.platforms.desktop.DesktopService;

	public class DLVDesktopService : DesktopService
	{

		public DLVDesktopService(string exe_path) : base(exe_path)
		{
			load_from_STDIN_option = "--";
		}

		protected internal override Output getOutput(string output, string error)
		{
			return new DLVAnswerSets(output, error);
		}

	}

}