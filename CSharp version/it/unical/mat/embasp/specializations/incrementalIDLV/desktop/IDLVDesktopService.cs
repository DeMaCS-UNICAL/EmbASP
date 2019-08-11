using System.Collections.Generic;
using System;
using System.ComponentModel;
using System.Diagnostics;
using System.IO;
using System.Text;
using System.Threading;
namespace it.unical.mat.embasp.specializations.incrementalIDLV.desktop
{
    using Output = it.unical.mat.embasp.@base.Output;
    using DesktopService = it.unical.mat.embasp.platforms.desktop.DesktopService;
    using InputProgram = it.unical.mat.embasp.@base.InputProgram;
    using OptionDescriptor = it.unical.mat.embasp.@base.OptionDescriptor;
    using ClingoAnswerSets = it.unical.mat.embasp.specializations.clingo.ClingoAnswerSets;

    public class IDLVDesktopService : DesktopService
    {

        Process grounder_process;
        string grounder_path;
        string solver_path;

        public IDLVDesktopService(string grounder_path, string solver_path) : base(grounder_path)
        {
            load_from_STDIN_option = "--stdin";
            this.grounder_path = grounder_path;
            this.solver_path = solver_path;
            RunGrounderProcess();
        }

        public void RunGrounderProcess()
        {
            try
            {
                grounder_process = new Process();
                grounder_process.StartInfo.FileName = @grounder_path;
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
                    stringBuffer.Append("<load_data path=").Append(quote).Append(tmpFile.Name).Append(quote).Append(" ").Append("permanently=").Append(quote).Append("true").Append(quote).Append(" ").Append("format=").Append(quote).Append("asp").Append(quote).Append("/>");

                    grounder_process.StandardInput.WriteLine(stringBuffer.ToString());

                    if (tmpFile != null && File.Exists(tmpFile.Name))
                        File.Delete(tmpFile.Name);

                    stringBuffer.Clear();
                }

                foreach (String program_file in program.FilesPaths)
                {
                    FileAttributes f = File.GetAttributes(@program_file);
                    if (File.Exists(program_file) && !f.HasFlag(FileAttributes.Directory))
                    {
                        stringBuffer.Append("<load_data path=").Append(quote).Append(program_file).Append(quote).Append(" ").Append("permanently=").Append(quote).Append("true").Append(quote).Append(" ").Append("format=").Append(quote).Append("asp").Append(quote).Append("/>");

                        grounder_process.StandardInput.WriteLine(stringBuffer.ToString());
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



            grounder_process.StandardInput.WriteLine(runCommand.ToString());

            //////////////////////////////////////
            ////    <RESET/> PER OGNI RUN ?  /////
            //////////////////////////////////////
            ///
            // writer.WriteLine(resetCommand);

            grounder_process.StandardInput.Flush();
            grounder_process.StandardInput.Close();


            grounderOutput = grounder_process.StandardOutput.ReadToEnd();
            grounderError = grounder_process.StandardError.ReadToEnd();


            grounderOutput = grounderOutput.Substring(79);
            Console.WriteLine(grounderOutput);

            string solverOutput = "EMPTY_OUTPUT";
            string solverError = "EMPTY_ERROR";

            try
            {
                StringBuilder stringBuffer = new StringBuilder();
                Process solver_process = new Process();
                solver_process.StartInfo.FileName = @solver_path;

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

                if (grounderOutput.Length > 0)
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