namespace it.unical.mat.embasp.specializations.dlvhex.desktop
{
    using Output = it.unical.mat.embasp.@base.Output;
    using DesktopService = it.unical.mat.embasp.platforms.desktop.DesktopService;

    public class DLVHEXDesktopService : DesktopService
    {
        public DLVHEXDesktopService(string exe_path) : base(exe_path) => load_from_STDIN_option = "--";

        protected internal override Output GetOutput(string output, string error) => new DLVHEXAnswerSets(output, error);
    }
}