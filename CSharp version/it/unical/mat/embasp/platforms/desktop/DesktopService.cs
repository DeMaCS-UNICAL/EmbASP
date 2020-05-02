using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.IO;
using System.Text;
using System.Threading;

namespace it.unical.mat.embasp.platforms.desktop
{
    using ICallback = it.unical.mat.embasp.@base.ICallback;
    using InputProgram = it.unical.mat.embasp.@base.InputProgram;
    using OptionDescriptor = it.unical.mat.embasp.@base.OptionDescriptor;
    using Output = it.unical.mat.embasp.@base.Output;
    using Service = it.unical.mat.embasp.@base.Service;

    public abstract class DesktopService : Service
    {
        protected internal string exe_path;
        protected internal string load_from_STDIN_option;

        public DesktopService(string exe_path) => this.exe_path = exe_path;

        public virtual string ExePath { get => exe_path; set => this.exe_path = value; }

        protected internal abstract Output GetOutput(string output, string error);

        public void StartAsync(ICallback callback, IList<InputProgram> programs, IList<OptionDescriptor> options)
        {
            new Thread(() =>
            {
                callback.Callback(StartSync(programs, options));
            }).Start();
        }

        public virtual Output StartSync(IList<InputProgram> programs, IList<OptionDescriptor> options)
        {
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

            string files_paths = "";
            string final_program = "";

            foreach (InputProgram p in programs)
            {
                if (p != null)
                {
                    final_program += p.Programs;
                    foreach (String program_file in p.FilesPaths)
                    {
                        FileAttributes f = File.GetAttributes(@program_file);
                        if (File.Exists(program_file) && !f.HasFlag(FileAttributes.Directory))
                        {
                            files_paths += program_file;
                            files_paths += " ";
                        }
                        else
                            Console.Error.WriteLine("Warning : the file " + Path.GetFullPath(@program_file) + " does not exists.");
                    }
                }
                else
                    Console.Error.WriteLine("Warning : wrong " + typeof(InputProgram).FullName);
            }

            string solverOutput = "EMPTY_OUTPUT";
            string solverError = "EMPTY_ERROR";

            try
            {
                var watch = System.Diagnostics.Stopwatch.StartNew();

                StringBuilder stringBuffer = new StringBuilder();
                StringBuilder options_string = new StringBuilder();
                if (exe_path is null)
                {
                    return new Output("", "Error: executable not found");
                }

                Process solver_process = new Process();
                stringBuffer.Append(exe_path).Append(" ").Append(option).Append(" ").Append(files_paths);
                solver_process.StartInfo.FileName = exe_path;
                options_string.Append(option).Append(" ").Append(files_paths);

                if (final_program.Length > 0)
                {
                    options_string.Append(this.load_from_STDIN_option);
                    stringBuffer.Append(this.load_from_STDIN_option);
                }

                Console.Error.WriteLine(stringBuffer.ToString());
                solver_process.EnableRaisingEvents = true;
                solver_process.StartInfo.Arguments = @options_string.ToString();
                solver_process.StartInfo.UseShellExecute = false;
                solver_process.StartInfo.CreateNoWindow = true;
                solver_process.StartInfo.WindowStyle = System.Diagnostics.ProcessWindowStyle.Hidden;
                solver_process.StartInfo.RedirectStandardInput = true;
                solver_process.StartInfo.RedirectStandardOutput = true;
                solver_process.StartInfo.RedirectStandardError = true;
                solver_process.Start();

                if (final_program.Length > 0)
                {
                    StreamWriter writer = solver_process.StandardInput;
                    writer.WriteLine(final_program);
                    if (writer != null)
                    {
                        writer.Close();
                    }
                }

                solverOutput = solver_process.StandardOutput.ReadToEnd().ToString();
                solverError = solver_process.StandardError.ReadToEnd().ToString();

                solver_process.WaitForExit();
                solver_process.Close();

                watch.Stop();

                Console.Error.WriteLine("Total time : " + watch.ElapsedMilliseconds);

                return GetOutput(solverOutput.ToString(), solverError.ToString());
            }
            catch (Win32Exception e2)
            {
                Console.Error.WriteLine(e2.ToString());
                Console.Error.Write(e2.StackTrace);
            }

            return GetOutput("", "");

        }


    }
}