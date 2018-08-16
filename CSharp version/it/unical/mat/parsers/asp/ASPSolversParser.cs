using Parsers.ASP.Clingo;
using Parsers.ASP.DLV;
using Parsers.ASP.DLV2;
using Parsers.ASP.DLVHEX;

namespace Parsers.ASP
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