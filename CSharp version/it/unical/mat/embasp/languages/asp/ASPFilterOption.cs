namespace it.unical.mat.embasp.languages.asp
{
    using OptionDescriptor = it.unical.mat.embasp.@base.OptionDescriptor;

    public abstract class ASPFilterOption : OptionDescriptor
    {
        public ASPFilterOption() : base("-filter=") { }
    }
}