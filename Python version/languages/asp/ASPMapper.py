from languages.Mapper import Mapper
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
    
    def _getParameters(self, string):
        """Return a set of parameter string name"""
        return string[string.index("(")+1:string.index(")")].split(",")
    
    def _getPredicate(self, string):
        """Return a string representing a predicate"""
        if "(" not in string:
            return string;
        return string[:string.index("(")]
        
        
        
        
            
        