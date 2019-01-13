using System;
using System.Collections.Generic;
using System.Text;

namespace it.unical.mat.embasp.specializations.solver_planning_domains.desktop
{
    using InputProgram = it.unical.mat.embasp.@base.InputProgram;
    using OptionDescriptor = it.unical.mat.embasp.@base.OptionDescriptor;
    using Output = it.unical.mat.embasp.@base.Output;
    using DesktopService = it.unical.mat.embasp.platforms.desktop.DesktopService;

    public class SPDDesktopService : DesktopService
    {
        private readonly SPDUtility spdu;

        public SPDDesktopService() : base("") => spdu = new SPDUtilityAnonymousInnerClass(this);

        private class SPDUtilityAnonymousInnerClass : SPDUtility
        {
            private readonly SPDDesktopService outerInstance;

            public SPDUtilityAnonymousInnerClass(SPDDesktopService outerInstance) => this.outerInstance = outerInstance;

            protected internal override string ReadFile(string s)
            {
                string everything = "";
                System.IO.StreamReader br = null;
                try
                {
                    br = new System.IO.StreamReader(s);
                    StringBuilder sb = new StringBuilder();
                    string line = br.ReadLine();

                    while (!(line is null))
                    {
                        sb.Append(line);
                        sb.Append(Environment.NewLine);
                        line = br.ReadLine();
                    }
                    everything = sb.ToString();
                }
                finally
                {
                    if (br != null)
                        br.Close();
                }
                return everything;
            }
        }

        protected internal override Output GetOutput(string output, string error) => new SPDPlan(output, error);

        public override Output StartSync(IList<InputProgram> programs, IList<OptionDescriptor> options)
        {
            if (programs.Count == 0)
                return GetOutput("", "PDDLInputProgram not defined");

            try
            {
                return GetOutput(spdu.PostJsonToURL(spdu.CreateJson(programs).ToString()), "");
            }
            catch (Exception e)
            {
                return GetOutput("", "Error : " + e.Message);
            }
        }
    }
}