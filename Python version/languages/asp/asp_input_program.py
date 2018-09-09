from base.input_program import InputProgram
from languages.asp.asp_mapper import ASPMapper


class ASPInputProgram(InputProgram):
    """A generic ASP program, with the capability of retrieving data by
    objects."""

    def __init__(self):
        super(ASPInputProgram, self).__init__()

    def add_object_input(self, input_obj):
        """Transforms a given Object class into an InputProgram and adds it to
        the current _programs.

        The parameter input_obj is an object to be transformed.
        """
        self.add_program(ASPMapper.get_instance().get_string(input_obj) + ".")

    def add_objects_input(self, input_objs):
        """Transforms a set of objects."""
        for inputObj in input_objs:
            self.add_object_input(inputObj)
