using System;
using System.Collections.Generic;

namespace it.unical.mat.embasp.@base
{
	public abstract class Handler
	{
		protected internal IDictionary<int, InputProgram> programs;
		protected internal IDictionary<int, OptionDescriptor> options;

		public Handler()
		{
			programs = new Dictionary<int, InputProgram>();
			options = new Dictionary<int, OptionDescriptor>();
		}

		public virtual int addOption(OptionDescriptor o)
		{

			int last_index = options.Count;
			int current_value = last_index;
			options[last_index++] = o;
			return current_value;
		}

		public virtual int addProgram(InputProgram program)
		{
			int last_index = programs.Count;
			int current_value = last_index;
			programs[last_index++] = program;
			return current_value;
		}

		protected internal virtual IList<OptionDescriptor> collect_options(IList<int> option_index)
		{
			IList<OptionDescriptor> input_option = new List<OptionDescriptor>();

			if (option_index == null)
			{
				foreach (KeyValuePair<int, OptionDescriptor> option in options)
				{
					input_option.Add(options[option.Key]);
				}
			}
			else
			{
				foreach (int index in option_index)
				{
					input_option.Add(options[index]);
				}
			}
			return input_option;
		}

		protected internal virtual IList<InputProgram> collect_programs(IList<int> program_index)
		{

			IList<InputProgram> input_programs = new List<InputProgram>();

			if (program_index == null)
			{
				foreach (KeyValuePair<int, InputProgram> program in programs)
				{
					input_programs.Add(programs[program.Key]);
				}
			}
			else
			{
				foreach (int index in program_index)
				{
					input_programs.Add(programs[index]);
				}
			}
			return input_programs;
		}
    public virtual InputProgram getInputProgram(int key)
		{
			return programs[key];
		}

		public virtual OptionDescriptor getOptionDescriptor(int key)
		{
			return options[key];
		}

		public virtual void removeAll()
		{

			programs.Clear();
			options.Clear();

		}

		public virtual void removeOption(int option_id)
		{
			options.Remove(option_id);
		}

		public virtual bool removeOption(OptionDescriptor o)
		{

			bool result = false;
			foreach (KeyValuePair<int, OptionDescriptor> entry in options)
			{
				if (entry.Value.Equals(o))
				{
					options.Remove(entry.Key);
					result = true;
				}
			}

			return result;

		}

		public virtual bool removeProgram(InputProgram p)
		{

			bool result = false;
			foreach (KeyValuePair<int, InputProgram> entry in programs)
			{
				if (entry.Value.Equals(p))
				{
					programs.Remove(entry.Key);
					result = true;
				}
			}
			return result;
		}

		public virtual void removeProgram(int program_id)
		{

			programs.Remove(program_id);
		}

		public virtual void startAsync(Callback c)
		{
			startAsync(c, (IList<int>) null, (IList<int>) null);
		}

		public virtual void startAsync(Callback c, IList<int> program_index, IList<int> option_index)
		{
		}

		/// <seealso cref= #startSync(List, List) </seealso>
		public virtual Output startSync()
		{
			return startSync((IList<int>) null, (IList<int>) null);
		}

		public virtual Output startSync(IList<int> program_index, IList<int> option_index)
		{
			return null;
		}
	}

}