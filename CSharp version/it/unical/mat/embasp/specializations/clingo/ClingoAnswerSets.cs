using it.unical.mat.parsers.asp;

namespace it.unical.mat.embasp.specializations.clingo
{
    using AnswerSets = it.unical.mat.embasp.languages.asp.AnswerSets;

    public class ClingoAnswerSets : AnswerSets
    {
        public ClingoAnswerSets(string answersets) : base(answersets) { }

        public ClingoAnswerSets(string @out, string err) : base(@out, err) { }

        protected internal override void Parse()
        {
            ASPSolversParser.ParseClingo(this, output, true);
        }
    }
}