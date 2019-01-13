using it.unical.mat.parsers.asp;

namespace it.unical.mat.embasp.specializations.dlvhex
{
    using AnswerSets = it.unical.mat.embasp.languages.asp.AnswerSets;

    public class DLVHEXAnswerSets : AnswerSets
    {
        public DLVHEXAnswerSets(string answerSets) : base(answerSets) { }

        public DLVHEXAnswerSets(string @out, string err) : base(@out, err) { }

        protected internal override void Parse()
        {
            ASPSolversParser.ParseDLVHEX(this, output, true);
        }
    }
}