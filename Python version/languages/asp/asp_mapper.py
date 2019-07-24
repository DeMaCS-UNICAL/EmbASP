from languages.mapper import Mapper
from languages.asp.symbolic_constant import SymbolicConstant
from parsers.asp.asp_parser import ASPParser


class ASPMapper(Mapper):
    """Contains methods used to transform Objects into InputProgram."""

    __instance = None

    def __init__(self):
        if ASPMapper.__instance:
            raise("Instance already exists")
        super(ASPMapper, self).__init__()

    @classmethod
    def get_instance(cls):
        """Return the instance of ASPMapper."""
        if not cls.__instance:
            cls.__instance = ASPMapper()
        return cls.__instance

    def _get_actual_string(self, predicate, parameters_map):
        """Return a string representing atom, from given predicate name,
        and set of parameters."""
        atom = predicate + "("
        for i in range(0, len(parameters_map)):
            if i != 0:
                atom += ","
            object_term = parameters_map[i]
            if object_term is None:
                raise("Wrong term number of predicate " + predicate)
            if isinstance(object_term, int):
                atom += str(object_term)
            elif isinstance(object_term, SymbolicConstant):
                atom += str(SymbolicConstant(object_term))
            else:
                atom += "\"" + str(object_term) + "\""
        atom += ")"
        return atom

    def _get_id(self, atom):
        """Return a string representing a predicate."""
        if '(' not in atom:
            return atom

        return atom[:atom.index('(')]

    def _get_param(self, atom):
        """Return a set of parameter string name."""
        return ASPParser.parse(atom).get_parameters()
