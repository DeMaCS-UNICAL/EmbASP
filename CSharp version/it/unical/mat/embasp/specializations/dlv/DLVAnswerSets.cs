using it.unical.mat.parsers.asp;

namespace it.unical.mat.embasp.specializations.dlv
{
    using AnswerSets = it.unical.mat.embasp.languages.asp.AnswerSets;

    public class DLVAnswerSets : AnswerSets
    {
        public DLVAnswerSets(string answerSets) : base(answerSets) { }

        public DLVAnswerSets(string @out, string err) : base(@out, err) { }

        protected internal override void Parse()
        {
            ASPSolversParser.ParseDLV(this, output, true);
        }
    }
}