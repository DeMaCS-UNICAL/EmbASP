using it.unical.mat.parsers.asp.clingo;
using it.unical.mat.parsers.asp.dlv;
using it.unical.mat.parsers.asp.dlv2;
using it.unical.mat.parsers.asp.dlvhex;

namespace it.unical.mat.parsers.asp
{
    public static class ASPSolversParser
    {
        public static void ParseClingo(IASPDataCollection answerSets, string atomsList, bool two_stageParsing)
        {
            ClingoParserBaseVisitorImplementation.Parse(answerSets, atomsList, two_stageParsing);
        }

        public static void ParseDLV(IASPDataCollection answerSets, string atomsList, bool two_stageParsing)
        {
            DLVParserBaseVisitorImplementation.Parse(answerSets, atomsList, two_stageParsing);
        }

        public static void ParseDLV2(IASPDataCollection answerSets, string atomsList, bool two_stageParsing)
        {
            DLV2ParserBaseVisitorImplementation.Parse(answerSets, atomsList, two_stageParsing);
        }

        public static void ParseDLVHEX(IASPDataCollection answerSets, string atomsList, bool two_stageParsing)
        {
            DLVHEXParserBaseVisitorImplementation.Parse(answerSets, atomsList, two_stageParsing);
        }
    }
}