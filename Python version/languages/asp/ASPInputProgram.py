from base.InputProgram import InputProgram
from languages.asp.ASPMapper import ASPMapper

class ASPInputProgram(InputProgram):
    """A generic ASP program, with the capabilities of retrieve data by objects"""
    
    def __init__(self):
        super(ASPInputProgram, self).__init__()
    
    
    def addObjectInput(self, inputObj):
        """Transforms a given Object class into a InputProgram and adds it to the current _programs
        The parameter inputObj is an object to be transformed
        """
        self.addProgram(ASPMapper.getInstance().getString(inputObj) + ".")
    
    
    def addObjectsInput(self, inputObjs):
        """Transforms a set of objects"""
        for inputObj in inputObjs:
            self.addObjectInput(inputObj)