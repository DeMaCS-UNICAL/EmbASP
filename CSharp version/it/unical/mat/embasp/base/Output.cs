using System;

namespace it.unical.mat.embasp.@base
{
    public class Output : ICloneable
    {
        protected internal string output;
        protected internal string errors;

        public Output() => output = "";

        public Output(string initial_output) => output = initial_output;

        public Output(string @out, string err)
        {
            output = @out;
            errors = err;
        }

        public virtual object Clone()
        {
            return base.MemberwiseClone();
        }

        public virtual string ErrorsString { get => errors; set => errors = value; }

        public virtual string OutputString { get => output; set => output = value; }

        protected internal virtual void Parse() { }
    }
}