using System.Collections.Generic;

namespace it.unical.mat.embasp.specializations.idlv_clasp.desktop
{
    using Output = it.unical.mat.embasp.@base.Output;
    using DesktopService = it.unical.mat.embasp.platforms.desktop.DesktopService;

    public class IDLVDesktopService : DesktopService
    {

        Process grounder_process;

        public IDLVDesktopService(string exe_path) : base(exe_path)
        {
            load_from_STDIN_option = "--stdin";
            RunGrounderProcess();
        }

        public void RunGrounderProcess()
        {
            try
            {
                grounder_process = new Process();
                grounder_process.StartInfo.FileName = "lib/idlv.exe";
                grounder_process.EnableRaisingEvents = true;
                grounder_process.StartInfo.Arguments = "--no-simplify --check-edb-duplication --output=7";
                grounder_process.StartInfo.UseShellExecute = false;
                grounder_process.StartInfo.CreateNoWindow = true;
                grounder_process.StartInfo.WindowStyle = System.Diagnostics.ProcessWindowStyle.Hidden;
                grounder_process.StartInfo.RedirectStandardInput = true;
                grounder_process.StartInfo.RedirectStandardOutput = true;
                grounder_process.StartInfo.RedirectStandardError = true;
                grounder_process.Start();
            }
            catch (Win32Exception e2)
            {
                Console.Error.WriteLine(e2.ToString());
                Console.Error.Write(e2.StackTrace);
            }

        }

        public override void LoadProgram(InputProgram program)
        {
            StringBuilder stringBuffer = new StringBuilder();
            char quote = '"';
            FileStream tmpFile = null;



            if (program != null)
            {
                if (program.Programs.Length > 0)
                {
                    tmpFile = WriteToFile("tmp", program.Programs);
                    stringBuffer.Append("<load_data path=").Append(quote).Append(tmpFile.Name).Append(quote).Append(" ").Append("permanently=").Append(quote).Append("true").Append(quote).Append(" ").Append("format=").Append(quote).Append("asp").Append(quote).Append(" ").Append("/>");
                    StreamWriter writer = grounder_process.StandardInput;
                    writer.WriteLine(stringBuffer.ToString());
                    if (writer != null)
                    {
                        writer.Close();
                    }
                    if (tmpFile != null && File.Exists(tmpFile.Name))
                        File.Delete(tmpFile.Name);

                    stringBuffer.Clear();
                }

                foreach (String program_file in program.FilesPaths)
                {
                    FileAttributes f = File.GetAttributes(@program_file);
                    if (File.Exists(program_file) && !f.HasFlag(FileAttributes.Directory))
                    {
                        stringBuffer.Append("<load_data path=").Append(quote).Append(program_file).Append(quote).Append(" ").Append("permanently=").Append(quote).Append("true").Append(quote).Append(" ").Append("format=").Append(quote).Append("asp").Append(quote).Append(" ").Append("/>");
                        StreamWriter writer = grounder_process.StandardInput;
                        writer.WriteLine(stringBuffer.ToString());
                        if (writer != null)
                        {
                            writer.Close();
                        }
                        stringBuffer.Clear();
                    }
                    else
                        Console.Error.WriteLine("Warning : the file " + Path.GetFullPath(@program_file) + " does not exists.");
                }
            }
            else
                Console.Error.WriteLine("Warning : wrong " + typeof(InputProgram).FullName);

        }

        protected internal override Output GetOutput(string output, string error) => new ClingoAnswerSets(output, error);


        public override Output StartSync(IList<InputProgram> programs, IList<OptionDescriptor> options)
        {
            string grounderOutput = "EMPTY_OUTPUT";
            string grounderError = "EMPTY_ERROR";

            char quote = '"';
            StringBuilder runCommand = new StringBuilder();
            string resetCommand = "<reset/>";
            runCommand.Append("<run permanently =").Append(" ").Append(quote).Append("true").Append(quote).Append(" ").Append("/>");

            StreamWriter writer = grounder_process.StandardInput;
            writer.WriteLine(runCommand.ToString());

            //////////////////////////////////////
            ////    <RESET/> PER OGNI RUN ?  /////
            //////////////////////////////////////
            ///
            // writer.WriteLine(resetCommand);

            if (writer != null)
            {
                writer.Close();
            }

            grounderOutput = grounder_process.StandardOutput.ReadToEnd().ToString();
            grounderError = grounder_process.StandardError.ReadToEnd().ToString();

            string solverOutput = "EMPTY_OUTPUT";
            string solverError = "EMPTY_ERROR";

            try
            {
                StringBuilder stringBuffer = new StringBuilder();
                Process solver_process = new Process();
                solver_process.StartInfo.FileName = "lib/clingo.exe";

                string option = "";
                foreach (OptionDescriptor o in options)
                {
                    if (o != null)
                    {
                        option += o.Options;
                        option += o.Separator;
                    }
                    else
                        Console.Error.WriteLine("Warning : wrong " + typeof(OptionDescriptor).FullName);
                }

                stringBuffer.Append("--mode=clasp").Append(" ").Append(option);

                FileStream tmpFile = null;

                if (solverOutput.Length > 0)
                {
                    tmpFile = WriteToFile("tmp", grounderOutput);
                    stringBuffer.Append(tmpFile.Name);
                }

                solver_process.EnableRaisingEvents = true;
                solver_process.StartInfo.Arguments = @stringBuffer.ToString();
                solver_process.StartInfo.UseShellExecute = false;
                solver_process.StartInfo.CreateNoWindow = true;
                solver_process.StartInfo.WindowStyle = System.Diagnostics.ProcessWindowStyle.Hidden;
                solver_process.StartInfo.RedirectStandardInput = true;
                solver_process.StartInfo.RedirectStandardOutput = true;
                solver_process.StartInfo.RedirectStandardError = true;
                solver_process.Start();

                solverOutput = solver_process.StandardOutput.ReadToEnd().ToString();
                solverError = solver_process.StandardError.ReadToEnd().ToString();

                solver_process.WaitForExit();
                solver_process.Close();

                if (tmpFile != null && File.Exists(tmpFile.Name))
                    File.Delete(tmpFile.Name);

                return GetOutput(solverOutput.ToString(), solverError.ToString());
            }
            catch (Win32Exception e2)
            {
                Console.Error.WriteLine(e2.ToString());
                Console.Error.Write(e2.StackTrace);
            }

            return GetOutput("", "");
        }


        public override void StopGrounderProcess()
        {

            try
            {
                string exitCommand = "<exit/>";
                StreamWriter writer = grounder_process.StandardInput;
                writer.WriteLine(exitCommand);

                if (writer != null)
                {
                    writer.Close();
                }
                grounder_process.WaitForExit();
                grounder_process.Close();
            }
            catch (Win32Exception e2)
            {
                Console.Error.WriteLine(e2.ToString());
                Console.Error.Write(e2.StackTrace);
            }
        }

    }
}