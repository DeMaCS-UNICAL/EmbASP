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
			init();
			separator = " ";
		}

		public InputProgram(object inputObj)
		{
			init();
			addObjectInput(inputObj);
		}

		public InputProgram(string initial_program)
		{
			init();
			programs = initial_program;
		}

		public virtual void addFilesPath(string file_path)
		{
			files_paths.Add(file_path);
		}

		public virtual void addObjectInput(object inputObj)
		{
			throw new System.NotSupportedException("functionality not implemented");
		}

		public virtual void addObjectsInput(ISet<object> inputObjs)
		{
			foreach (Object inputObj in inputObjs)
			{
				addObjectInput(inputObj);
			}
		}

		public virtual void addProgram(string new_instruction)
		{
			if (programs.Length == 0)
			{
				programs = new_instruction;
			}
			else
			{
				programs += separator + new_instruction;
			}
		}

		public virtual void clearAll()
		{
			clearFilesPaths();
			clearPrograms();
		}

		public virtual void clearFilesPaths()
		{
			files_paths.Clear();
		}

		public virtual void clearPrograms()
		{
			programs = "";
		}

		public virtual IList<string> FilesPaths
		{
			get
			{
				return files_paths;
			}
		}

		public virtual string Programs
		{
			get
			{
				return programs;
			}
			set
			{
				this.programs = value;
			}
		}

		public virtual string Separator
		{
			get
			{
				return separator;
			}
			set
			{
				this.separator = value;
			}
		}

		public virtual string StringOfFilesPaths
		{
			get
			{
    
				StringBuilder to_return = new StringBuilder();
    
				foreach (String paths in files_paths)
				{
					if (paths.Length != 0)
					{
						to_return.Append(paths).Append(" ");
					}
				}
    
				return to_return.ToString();
			}
		}

		private void init()
		{
			programs = "";
			files_paths = new List<string>();
		}



	}

}