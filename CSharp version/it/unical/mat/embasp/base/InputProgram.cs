using System;
using System.Collections.Generic;
using System.Text;

namespace it.unical.mat.embasp.@base
{
    public class InputProgram
    {
        protected internal string programs;
        private IList<string> files_paths;
        protected internal string separator;

        public InputProgram()
        {
            Init();
            separator = " ";
        }

        public InputProgram(object inputObj)
        {
            Init();
            AddObjectInput(inputObj);
        }

        public InputProgram(string initial_program)
        {
            Init();
            programs = initial_program;
        }

        public virtual void AddFilesPath(string file_path) => files_paths.Add(file_path);

        public virtual void AddObjectInput(object inputObj) => throw new System.NotSupportedException("functionality not implemented");

        public virtual void AddObjectsInput(ISet<object> inputObjs)
        {
            foreach (Object inputObj in inputObjs)
                AddObjectInput(inputObj);
        }

        public virtual void AddProgram(string new_instruction)
        {
            if (programs.Length == 0)
                programs = new_instruction;
            else
                programs += separator + new_instruction;
        }

        public virtual void ClearAll()
        {
            ClearFilesPaths();
            ClearPrograms();
        }

        public virtual void ClearFilesPaths() => files_paths.Clear();

        public virtual void ClearPrograms() => programs = "";

        public virtual IList<string> FilesPaths => files_paths;

        public virtual string Programs { get => programs; set => this.programs = value; }

        public virtual string Separator { get => separator; set => this.separator = value; }

        public virtual string StringOfFilesPaths
        {
            get
            {
                StringBuilder to_return = new StringBuilder();
                foreach (String paths in files_paths)
                    if (paths.Length != 0)
                        to_return.Append(paths).Append(" ");
                return to_return.ToString();
            }
        }

        private void Init()
        {
            programs = "";
            files_paths = new List<string>();
        }
    }
}