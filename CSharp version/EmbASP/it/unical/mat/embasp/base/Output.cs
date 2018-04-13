using System;

namespace it.unical.mat.embasp.@base
{
	public class Output : ICloneable
	{
		protected internal string output;
		protected internal string errors;

		public Output()
		{
			output = "";
		}

		public Output(string initial_output)
		{
			output = initial_output;
		}

		public Output(string @out, string err)
		{
			output = @out;
			errors = err;
		}

    public virtual object Clone() {
        try {
          return base.MemberwiseClone();
        }
        catch (NotSupportedException ex) {
          // code that handles the exception
          throw;
        }
    }

    public virtual string Errors
		{
			get
			{
				return errors;
			}
			set
			{
				errors = value;
			}
		}

		public virtual string getOutput()
		{
			return output;
		}

		protected internal virtual void parse()
		{
		}

		public virtual void setOutput(string output)
		{
			this.output = output;
		}

  }

}