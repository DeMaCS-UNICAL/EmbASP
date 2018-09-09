from parsers.asp.clingo import clingo_parser_visitor_implementation
from parsers.asp.dlv import dlv_parser_visitor_implementation
from parsers.asp.dlv2 import dlv2_parser_visitor_implementation
from parsers.asp.dlvhex import dlvhex_parser_visitor_implementation


class ASPSolversParser(object):
    @staticmethod
    def parse_clingo(answerSets, atomsList, two_stageParsing):
        clingo_parser_visitor_implementation.parse(
            answerSets, atomsList, two_stageParsing)

    @staticmethod
    def parse_dlv(answerSets, atomsList, two_stageParsing):
        dlv_parser_visitor_implementation.parse(
            answerSets, atomsList, two_stageParsing)

    @staticmethod
    def parse_dlv2(answerSets, atomsList, two_stageParsing):
        dlv2_parser_visitor_implementation.parse(
            answerSets, atomsList, two_stageParsing)

    @staticmethod
    def parse_dlvhex(answerSets, atomsList, two_stageParsing):
        dlvhex_parser_visitor_implementation.parse(
            answerSets, atomsList, two_stageParsing)
