from languages.mapper import Mapper
from parsers.pddl.pddl_parser import PDDLParser


class PDDLMapper(Mapper):
    """Contains methods used to transform Objects into InputProgram."""
    __instance = None

    def __init__(self):
        if PDDLMapper.__instance:
            raise("Instance already exists")
        super(PDDLMapper, self).__init__()

    @classmethod
    def get_instance(cls):
        """Return the instance of PDDLMapper."""
        if not cls.__instance:
            cls.__instance = PDDLMapper()
        return cls.__instance

    def _get_actual_string(self, predicate, parameters_map):
        return None

    def _get_id(self, action):
        """Return a string representing a predicate."""
        if action.index('(') != 0:
            raise ("Wrong format")

        return action[1:action.index(" ")]

    def _get_param(self, action):
        """Return a set of parameters."""
        return PDDLParser.parse(action).get_parameters()
