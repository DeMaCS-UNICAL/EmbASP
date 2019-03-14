namespace it.unical.mat.embasp.specializations.dlv.desktop
{
    using Output = it.unical.mat.embasp.@base.Output;
    using DesktopService = it.unical.mat.embasp.platforms.desktop.DesktopService;

    public class DLVDesktopService : DesktopService
    {
        public DLVDesktopService(string exe_path) : base(exe_path) => load_from_STDIN_option = "--";

        protected internal override Output GetOutput(string output, string error) => new DLVAnswerSets(output, error);
    }
}