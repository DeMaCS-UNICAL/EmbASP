from parsers.asp.clingo.clingo_parser_visitor_implementation import ClingoParserVisitorImplementation
from parsers.asp.dlv.dlv_parser_visitor_implementation import DLVParserVisitorImplementation
from parsers.asp.dlv2.dlv2_parser_visitor_implementation import DLV2ParserVisitorImplementation
from parsers.asp.dlvhex.dlvhex_parser_visitor_implementation import DLVHEXParserVisitorImplementation


class ASPSolversParser(object):
    @staticmethod
    def parse_clingo(answerSets, atomsList, two_stageParsing):
        ClingoParserVisitorImplementation.parse(
            answerSets, atomsList, two_stageParsing)

    @staticmethod
    def parse_dlv(answerSets, atomsList, two_stageParsing):
        DLVParserVisitorImplementation.parse(
            answerSets, atomsList, two_stageParsing)

    @staticmethod
    def parse_dlv2(answerSets, atomsList, two_stageParsing):
        DLV2ParserVisitorImplementation.parse(
            answerSets, atomsList, two_stageParsing)

    @staticmethod
    def parse_dlvhex(answerSets, atomsList, two_stageParsing):
        DLVHEXParserVisitorImplementation.parse(
            answerSets, atomsList, two_stageParsing)
