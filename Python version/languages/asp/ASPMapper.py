from languages.Mapper import Mapper
from languages.asp.parser.ASPGrammarVisitorImplementation import ASPGrammarVisitorImplementation
class ASPMapper(Mapper):
    """Contains methods used to transform Objects into InputProgram"""
    
    __Instance = None

    def __init__(self):
        if ASPMapper.__Instance:
            raise("Instance already exists")
        super(ASPMapper, self).__init__()

    @classmethod
    def getInstance(cls):
        """Return the instance of ASPMapper"""
        if not cls.__Instance:
            cls.__Instance = ASPMapper()
        return cls.__Instance
    
    def _getActualString(self, predicate, parametersMap):
        """Return a string representing atom, from given predicate string name, and set of parameters"""
        atom = predicate + "("
        for i in range(0,len(parametersMap)):
            if (i != 0):
                atom += ","
            objectTerm = parametersMap[i]
            if (objectTerm == None):
                raise("Wrong term number of predicate " + predicate)
            if (isinstance(objectTerm, int)):
                atom += str(objectTerm)
            else:
                atom += "\"" + str(objectTerm) + "\""
        atom += ")"
        return atom
    
    def _addToCollection(self, obj):
        self._objects.add(obj)
        
    def _initialize(self, atomsList):
        self._objects = set()
        self._parser = ASPGrammarVisitorImplementation(atomsList)
    
    def _getId(self):
        """Returns a string representing an id"""
        return self._parser.getIdentifier()
    
    def _getParam(self):
        """Returns strings representing parameters"""
        return self._parser.getParameters()
