namespace it.unical.mat.embasp.specializations.dlv
{
    using ASPFilterOption = it.unical.mat.embasp.languages.asp.ASPFilterOption;

    public class DLVFilterOption : ASPFilterOption
    {
        public DLVFilterOption(string initial_option) : base() => options += initial_option;
    }
}