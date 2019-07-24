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

        public virtual int AddOption(OptionDescriptor o)
        {
            int last_index = options.Count;
            int current_value = last_index;
            options[last_index++] = o;
            return current_value;
        }

        public virtual int AddProgram(InputProgram program)
        {
            int last_index = programs.Count;
            int current_value = last_index;
            programs[last_index++] = program;
            return current_value;
        }

        protected internal virtual IList<OptionDescriptor> CollectOptions(IList<int> option_index)
        {
            IList<OptionDescriptor> input_option = new List<OptionDescriptor>();

            if (option_index == null)
                foreach (KeyValuePair<int, OptionDescriptor> option in options)
                    input_option.Add(options[option.Key]);
            else
                foreach (int index in option_index)
                    input_option.Add(options[index]);
            return input_option;
        }

        protected internal virtual IList<InputProgram> CollectPrograms(IList<int> program_index)
        {
            IList<InputProgram> input_programs = new List<InputProgram>();

            if (program_index == null)
                foreach (KeyValuePair<int, InputProgram> program in programs)
                    input_programs.Add(programs[program.Key]);
            else
                foreach (int index in program_index)
                    input_programs.Add(programs[index]);
            return input_programs;
        }

        public virtual InputProgram GetInputProgram(int key) => programs[key];

        public virtual OptionDescriptor GetOptionDescriptor(int key) => options[key];

        public virtual void RemoveAll()
        {
            programs.Clear();
            options.Clear();
        }

        public virtual void RemoveOption(int option_id) => options.Remove(option_id);

        public virtual bool RemoveOption(OptionDescriptor o)
        {
            bool result = false;
            foreach (KeyValuePair<int, OptionDescriptor> entry in options)
                if (entry.Value.Equals(o))
                {
                    options.Remove(entry.Key);
                    result = true;
                }
            return result;
        }

        public virtual bool RemoveProgram(InputProgram p)
        {
            bool result = false;
            foreach (KeyValuePair<int, InputProgram> entry in programs)
                if (entry.Value.Equals(p))
                {
                    programs.Remove(entry.Key);
                    result = true;
                }
            return result;
        }

        public virtual void RemoveProgram(int program_id) => programs.Remove(program_id);

        public virtual void StartAsync(ICallback c) => StartAsync(c, (IList<int>)null, (IList<int>)null);

        public virtual void StartAsync(ICallback c, IList<int> program_index, IList<int> option_index) { }

        public virtual Output StartSync() => StartSync((IList<int>)null, (IList<int>)null);

        public virtual Output StartSync(IList<int> program_index, IList<int> option_index) => null;
    }
}