from base.InputProgram import InputProgram

class PDDLInputProgram(InputProgram):
    """A generic PDDL program"""
    
    def __init__(self, progType):
        super(PDDLInputProgram, self).__init__()
        self.__programsType = progType  # Where type of program are stored
        
    def getProgramsType(self):
        """Return type of program"""
        return self.__programsType