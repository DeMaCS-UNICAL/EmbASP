using System;
using System.Collections.Generic;

namespace it.unical.mat.embasp.languages.asp
{
    using InputProgram = it.unical.mat.embasp.@base.InputProgram;

    public class ASPInputProgram : InputProgram
    {
        public ASPInputProgram() : base() { }

        public ASPInputProgram(object inputObj) : base(inputObj) { }

        public ASPInputProgram(string initial_program) : base(initial_program) { }

        public override void AddObjectInput(object inputObj) => AddProgram(ASPMapper.Instance.GetString(inputObj) + ".");

        public override void AddObjectsInput(ISet<object> inputObjs)
        {
            foreach (Object inputObj in inputObjs)
                AddObjectInput(inputObj);
        }
    }
}