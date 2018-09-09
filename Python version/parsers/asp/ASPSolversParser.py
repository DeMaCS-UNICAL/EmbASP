from .clingo.ClingoParserVisitorImplementation import ClingoParserVisitorImplementation
from .dlv.DLVParserVisitorImplementation import DLVParserVisitorImplementation
from .dlv2.DLV2ParserVisitorImplementation import DLV2ParserVisitorImplementation
from .dlvhex.DLVHEXParserVisitorImplementation import DLVHEXParserVisitorImplementation


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
