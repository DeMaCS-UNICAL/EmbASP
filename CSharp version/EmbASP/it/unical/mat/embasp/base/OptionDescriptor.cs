namespace it.unical.mat.embasp.@base
{
	public class OptionDescriptor
	{
		protected internal string separator;
		protected internal string options;

		public OptionDescriptor()
		{
			options = "";
			separator = "";
		}

		public OptionDescriptor(string initial_option) : this()
		{
			options = initial_option;
		}

		public virtual void addOption(string option)
		{
			if (option.Length == 0)
			{
				options = option;
			}
			else
			{
				options += separator + option;
			}

		}

		public virtual void clear()
		{

			options = "";
		}

		public virtual string Options
		{
			get
			{
    
				return options;
			}
			set
			{
				options = value;
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


	}

}