from base.input_program import InputProgram


class PDDLInputProgram(InputProgram):
    """A generic PDDL program."""

    def __init__(self, progType):
        super(PDDLInputProgram, self).__init__()
        self.__programs_type = progType  # Where type of program are stored

    def get_programs_type(self):
        """Return type of programs."""
        return self.__programs_type
