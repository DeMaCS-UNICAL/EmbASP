using it.unical.mat.parsers.asp;

namespace it.unical.mat.embasp.specializations.dlv2
{
    using AnswerSets = it.unical.mat.embasp.languages.asp.AnswerSets;

    public class DLV2AnswerSets : AnswerSets
    {
        public DLV2AnswerSets(string answersets) : base(answersets) { }

        public DLV2AnswerSets(string @out, string err) : base(@out, err) { }

        protected internal override void Parse()
        {
            ASPSolversParser.ParseDLV2(this, output, true);
        }
    }
}