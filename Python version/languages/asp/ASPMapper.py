from languages.Mapper import Mapper
from parsers.asp.ASPParser import ASPParser

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
    
    def _getId(self, atom):
        """Return a string representing a predicate"""
        if '(' not in atom:
            return atom
        
        return atom[:atom.index('(')]
    
    def _getParam(self, atom):
        """Return a set of parameter string name"""
        return ASPParser.parse(atom).getParameters()
