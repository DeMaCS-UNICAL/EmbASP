from languages.mapper import Mapper
class ASPMapper(Mapper):
    """Contains methods used to transform Objects into InputProgram"""
    
    __instance = None

    def __init__(self):
        if ASPMapper.__instance:
            raise("Instance already exists")
        super(ASPMapper, self).__init__()

    @classmethod
    def get_instance(cls):
        """Return the instance of ASPMapper"""
        if not cls.__instance:
            cls.__instance = ASPMapper()
        return cls.__instance
    
    def _get_actual_string(self, predicate, parametersMap):
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
    
    def _get_parameters(self, string):
        """Return a set of parameter string name"""
        return string[string.index("(")+1:string.index(")")].split(",")
    
    def _get_predicate(self, string):
        """Return a string representing a predicate"""
        if "(" not in string:
            return string;
        return string[:string.index("(")]
        
        
        
        
            
        