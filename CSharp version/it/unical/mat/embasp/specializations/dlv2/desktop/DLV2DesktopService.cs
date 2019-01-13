using System.Collections.Generic;

namespace it.unical.mat.embasp.specializations.dlv2.desktop
{
    using Output = it.unical.mat.embasp.@base.Output;
    using DesktopService = it.unical.mat.embasp.platforms.desktop.DesktopService;

    public class DLV2DesktopService : DesktopService
    {
        public DLV2DesktopService(string exe_path) : base(exe_path)
        {
            load_from_STDIN_option = "--stdin";
        }

        protected internal override Output GetOutput(string output, string error) => new DLV2AnswerSets(output, error);
    }
}