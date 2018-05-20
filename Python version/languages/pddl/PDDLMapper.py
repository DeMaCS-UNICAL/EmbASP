from languages.Mapper import Mapper
from parsers.pddl.PDDLParser import PDDLParser

class PDDLMapper(Mapper):
    """Contains methods used to transform Objects into InputProgram"""
    __Instance = None

    def __init__(self):
        if PDDLMapper.__Instance:
            raise("Instance already exists")
        super(PDDLMapper, self).__init__()

    @classmethod
    def getInstance(cls):
        """Return the instance of PDDLMapper"""
        if not cls.__Instance:
            cls.__Instance = PDDLMapper()
        return cls.__Instance
    
    def _getActualString(self, predicate, parametersMap):
        return None
    
    def _getId(self, action):
        """Return a string representing a predicate"""
        if action.index('(') != 0:
            raise ("Wrong format")
        
        return action[1:action.index(" ")]
    
    def _getParam(self, action):
        """Return a set of parameter string name"""
        return PDDLParser.parse(action).getParameters()
