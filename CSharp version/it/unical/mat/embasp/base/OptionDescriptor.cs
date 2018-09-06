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

        public virtual void AddOption(string option)
        {
            if (option.Length == 0)
                options = option;
            else
                options += separator + option;
        }

        public virtual void Clear() => options = "";

        public virtual string Options { get => options; set => options = value; }

        public virtual string Separator { get => separator; set => this.separator = value; }
    }
}