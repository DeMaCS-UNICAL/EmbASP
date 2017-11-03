from languages.Mapper import Mapper
from languages.pddl.parser.PDDLGrammarVisitorImplementation import PDDLGrammarVisitorImplementation
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
    
    def _addToCollection(self, obj):
        self._objects.append(obj)
        
    def _initialize(self, atomsList):
        self._objects = list()
        self._parser = PDDLGrammarVisitorImplementation(atomsList)
    
    def _getId(self):
        """Returns a string representing an id"""
        return self._parser.getIdentifier()
    
    def _getParam(self):
        """Returns strings representing parameters"""
        return self._parser.getParameters()
