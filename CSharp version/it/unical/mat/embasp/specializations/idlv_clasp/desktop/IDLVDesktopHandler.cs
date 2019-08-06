using System.Collections.Generic;

namespace it.unical.mat.embasp.specializations.idlv_clasp.desktop
{
    using ICallback = it.unical.mat.embasp.@base.ICallback;
    using Handler = it.unical.mat.embasp.@base.Handler;
    using InputProgram = it.unical.mat.embasp.@base.InputProgram;
    using OptionDescriptor = it.unical.mat.embasp.@base.OptionDescriptor;
    using Output = it.unical.mat.embasp.@base.Output;

    public class IDLVDesktopHandler : Handler
    {
        private readonly DesktopService service;

        public DesktopHandler(DesktopService service) => this.service = service;

        public override int AddProgram(InputProgram program)
        {
            int last_index = programs.Count;
            int current_value = last_index;
            programs[last_index++] = program;
            service.LoadProgram(program);
            return current_value;
        }

        public override void Quit()
        {
            service.StopGrounderProcess();
        }

        public override void StartAsync(ICallback c, IList<int> program_index, IList<int> option_index)
        {
            IList<InputProgram> input_programs = CollectPrograms(program_index);
            IList<OptionDescriptor> input_options = CollectOptions(option_index);
            service.StartAsync(c, input_programs, input_options);
        }

        public override Output StartSync(IList<int> program_index, IList<int> option_index)
        {
            IList<InputProgram> input_programs = CollectPrograms(program_index);
            IList<OptionDescriptor> input_options = CollectOptions(option_index);
            return service.StartSync(input_programs, input_options);
        }
    }
}