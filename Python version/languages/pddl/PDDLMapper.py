from languages.Mapper import Mapper
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
    
    def _getParameters(self, string):
        """Return a set of parameter string name"""
        return string[string.index(" ") + 1:string.rfind(")")].split(" ")
    
    def _getPredicate(self, string):
        """Return a string representing a predicate"""
        initialB = string.index("(")
        if initialB != 0:
            raise ("Wrong format")
        return string[1:string.index(" ")]
