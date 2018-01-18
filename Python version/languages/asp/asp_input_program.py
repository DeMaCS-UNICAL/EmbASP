from base.input_program import InputProgram
from languages.asp.asp_mapper import ASPMapper

class ASPInputProgram(InputProgram):
    """A generic ASP program, with the capabilities of retrieve data by objects"""
    
    def __init__(self):
        super(ASPInputProgram, self).__init__()
    
    
    def add_object_input(self, inputObj):
        """Transforms a given Object class into a InputProgram and adds it to the current _programs
        The parameter inputObj is an object to be transformed
        """
        self.add_program(ASPMapper.get_instance().get_string(inputObj) + ".")
    
    
    def add_objects_input(self, inputObjs):
        """Transforms a set of objects"""
        for inputObj in inputObjs:
            self.add_object_input(inputObj)