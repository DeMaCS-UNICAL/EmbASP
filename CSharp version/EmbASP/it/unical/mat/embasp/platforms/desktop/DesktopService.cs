using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.IO;
using System.Text;

using System.Threading;

namespace it.unical.mat.embasp.platforms.desktop {

  using Callback = it.unical.mat.embasp.@base.Callback;
  using InputProgram = it.unical.mat.embasp.@base.InputProgram;
  using OptionDescriptor = it.unical.mat.embasp.@base.OptionDescriptor;
  using Output = it.unical.mat.embasp.@base.Output;
  using Service = it.unical.mat.embasp.@base.Service;

  public abstract class DesktopService : Service {
    protected internal string exe_path;
    protected internal string load_from_STDIN_option;

    public DesktopService(string exe_path) {
      this.exe_path = exe_path;
    }

    public virtual string ExePath {
      get {
        return exe_path;
      }
      set {
        this.exe_path = value;
      }
    }

    protected internal abstract Output getOutput(string output, string error);


    public void startAsync(Callback callback, IList<InputProgram> programs, IList<OptionDescriptor> options) {

      new Thread(() => {
        callback.callback(startSync(programs, options));
      }).Start();

    }

    public virtual Output startSync(IList<InputProgram> programs, IList<OptionDescriptor> options) {

      string option = "";
      foreach (OptionDescriptor o in options) {
        if (o != null) {
          option += o.Options;
          option += o.Separator;
        }
        else {
          Console.Error.WriteLine("Warning : wrong " + typeof(OptionDescriptor).FullName);
        }
      }

      string files_paths = "";
      string final_program = "";

      foreach (InputProgram p in programs) {
        if (p != null) {
          final_program += p.Programs;
          foreach (String program_file in p.FilesPaths) {
            //File f = new File(program_file);
            FileAttributes f = File.GetAttributes(@program_file);
            // if (File.Exists(program_file) && !((f & FileAttributes.Directory) == FileAttributes.Directory)) {
            if (File.Exists(program_file) && !f.HasFlag(FileAttributes.Directory)) {
              files_paths += program_file;
              files_paths += " ";
            }
            else {
              Console.Error.WriteLine("Warning : the file " + Path.GetFullPath(@program_file) + " does not exists.");
            }
          }
        }
        else {
          Console.Error.WriteLine("Warning : wrong " + typeof(InputProgram).FullName);
        }
      }

      string solverOutput = "EMPTY_OUTPUT";
      string solverError = "EMPTY_ERROR";
      FileStream tmpFile = null;
      try {


        var watch = System.Diagnostics.Stopwatch.StartNew();
        //long startTime = System.nanoTime();

        
        //File tmpFile = null;

        StringBuilder stringBuffer = new StringBuilder();
        StringBuilder options_string = new StringBuilder();
        if (string.ReferenceEquals(exe_path, null)) {
          return new Output("", "Error: executable not found");
        }

        Process solver_process = new Process();

        stringBuffer.Append(exe_path).Append(" ").Append(option).Append(" ").Append(files_paths);
        //solver_process.StartInfo.FileName = @"C:\Users\Francesco\Desktop\github_projects\EmbASP\CSharp\sudoku\bin\Debug\lib\dlv.mingw.exe";

        solver_process.StartInfo.FileName = exe_path;
        options_string.Append(option).Append(" ").Append(files_paths);
          
        //if (exe_path.Contains("dlv2")) {
        //  solver_process.StartInfo.FileName = "wsl.exe";
        //  options_string.Append(option).Append(" ").Append(exe_path).Append(" ").Append(files_paths);
        //}
        //else 

        if (final_program.Length > 0) {
          tmpFile = writeToFile("tmp", final_program);
          options_string.Append(" ").Append(tmpFile.Name);
          stringBuffer.Append(" ").Append(tmpFile.Name);
        }

        Console.Error.WriteLine(stringBuffer.ToString());
        //Process solver_process = Process.Start(stringBuffer.ToString());
        //solver_process.StartInfo.Arguments = @"-filter=cell -n=1 C:\Users\Francesco\Desktop\github_projects\EmbASP\CSharp\sudoku\bin\Debug\encodings\sudoku";
        //options_string.Append(" -filter=cell -n=1 ");
        solver_process.EnableRaisingEvents = true;
        solver_process.StartInfo.Arguments = @options_string.ToString();
        solver_process.StartInfo.UseShellExecute = false;
        solver_process.StartInfo.CreateNoWindow = true;
        solver_process.StartInfo.WindowStyle = System.Diagnostics.ProcessWindowStyle.Hidden;
        solver_process.StartInfo.RedirectStandardInput = true;
        solver_process.StartInfo.RedirectStandardOutput = true;
        solver_process.StartInfo.RedirectStandardError = true;
        //Console.WriteLine("{0} {1}", Path.GetFullPath(solver_process.StartInfo.FileName), solver_process.StartInfo.Arguments);
        solver_process.Start();


        // TODO: DA RITESTARE -- RICORDA DI COMPILARE A 64BIT E RIEFFETTUARE LA BUILD MANUALMENTE
        //Process test_process = new Process();
        //test_process.StartInfo.FileName = "wsl.exe";
        //test_process.StartInfo.Arguments = "./lib/dlv2 encodings/sudoku";
        //test_process.StartInfo.UseShellExecute = false;
        //test_process.StartInfo.RedirectStandardInput = true;
        //test_process.StartInfo.RedirectStandardOutput = true;
        //test_process.StartInfo.RedirectStandardError = true;
        //test_process.Start();


        solverOutput = solver_process.StandardOutput.ReadToEnd().ToString();
        solverError = solver_process.StandardError.ReadToEnd().ToString();

        //StreamWriter writer = solver_process.StandardInput;
        ////PrintWriter writer = new PrintWriter(solver_process.OutputStream);
        //writer.WriteLine(final_program);
        ////writer.println(final_program);
        //if (writer != null) {
        //  writer.Close();
        //}

        solver_process.WaitForExit();
        solver_process.Close();
        //long stopTime = System.nanoTime();
        watch.Stop();

        Console.Error.WriteLine("Total time : " + watch.ElapsedMilliseconds);

        if (tmpFile != null && File.Exists(tmpFile.Name)) {
          File.Delete(tmpFile.Name);
        }

        return getOutput(solverOutput.ToString(), solverError.ToString());

      }
      catch (Win32Exception e2) {
        //if (tmpFile != null && File.Exists(tmpFile.Name)) {
        //  File.Delete(tmpFile.Name);
        //}
        return getOutput(tmpFile.Name + " STRING: " + e2.ToString() + "\n\nSTACK TRACE\n\n " + e2.StackTrace + "\n\nINNER: \n\n" +e2.InnerException, "");
        Console.Error.WriteLine(e2.ToString());
        Console.Error.Write(e2.StackTrace);
      }

      return getOutput("", "");

    }

    protected internal virtual FileStream writeToFile(string pFilename, string sb) {
      //FileStream tempDir = File.Create(Path.GetTempPath());
      string filename = System.IO.Path.GetTempPath() + pFilename + Guid.NewGuid().ToString() + ".tmp";
      FileStream tempFile = File.Create(filename);
      //Console.WriteLine("FILE CREATO {0}", filename);
      tempFile.Close();
      System.IO.StreamWriter bw = new System.IO.StreamWriter(filename, append: true);
      //System.IO.StreamWriter bw = new System.IO.StreamWriter(fileWriter);
      bw.Write(sb);
      bw.Close();
      
      return tempFile;
    }

  }

}