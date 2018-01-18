from languages.mapper import Mapper
class PDDLMapper(Mapper):
    """Contains methods used to transform Objects into InputProgram"""
    __instance = None

    def __init__(self):
        if PDDLMapper.__instance:
            raise("Instance already exists")
        super(PDDLMapper, self).__init__()

    @classmethod
    def get_instance(cls):
        """Return the instance of PDDLMapper"""
        if not cls.__instance:
            cls.__instance = PDDLMapper()
        return cls.__instance
    
    def _get_actual_string(self, predicate, parametersMap):
        return None
    
    def _get_parameters(self, string):
        """Return a set of parameter string name"""
        return string[string.index(" ") + 1:string.rfind(")")].split(" ")
    
    def _get_predicate(self, string):
        """Return a string representing a predicate"""
        initialB = string.index("(")
        if initialB != 0:
            raise ("Wrong format")
        return string[1:string.index(" ")]
