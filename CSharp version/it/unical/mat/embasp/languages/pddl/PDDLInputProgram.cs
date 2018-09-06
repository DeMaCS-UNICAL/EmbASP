namespace it.unical.mat.embasp.languages.pddl
{
    using InputProgram = it.unical.mat.embasp.@base.InputProgram;

    public class PDDLInputProgram : InputProgram
    {
        private readonly PDDLProgramType programsType;

        public PDDLInputProgram(PDDLProgramType type) : base() => programsType = type;

        public virtual PDDLProgramType ProgramsType => programsType;
    }
}