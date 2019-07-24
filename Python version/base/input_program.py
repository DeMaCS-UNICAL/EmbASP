class InputProgram(object):
    """Represents a generic option."""

    def __init__(self):
        """Creates new programs setting space as default separator."""
        self._programs = ""  # Where programs data is stored
        self.__files_paths = list()  # Where associated files are stored
        self._separator = " "  # Used as separator for programs

    def add_object_input(self, input_obj):
        raise "Functionality not implemented"

    def add_objects_input(self, input_objs):
        for inputObj in input_objs:
            self.add_object_input(inputObj)

    def add_files_path(self, file_path):
        """Add a new file path into __files_paths.

        The parameter file_path represents a new file path.
        """
        self.__files_paths.append(file_path)

    def add_program(self, new_instruction):
        """Adds a new instruction directly into _programs.

        The parameter new_instruction represents a new program
        instruction.
        """
        if self._programs is None:
            self._programs = new_instruction
        else:
            self._programs += self._separator + new_instruction

    def clear_files_paths(self):
        """After this method, __files_paths will be empty."""
        del self.__files_paths[:]

    def clear_programs(self):
        """After this method, _programs will be empty."""
        self._programs = None

    def clear_all(self):
        """After this method, both __files_paths and _programs will be
        empty."""
        self.clear_files_paths()
        self.clear_programs()

    def get_files_paths(self):
        """Returns the __files_paths list."""
        return self.__files_paths

    def get_programs(self):
        """Returns data stored in _programs."""
        return self._programs

    def get_separator(self):
        """Returns the _separator character."""
        return self._separator

    def get_string_of_files_paths(self):
        """Returns string concatenating files paths."""
        to_return = ""
        for paths in self.__files_paths:
            if len(paths) != 0:
                to_return += paths + " "
        return to_return

    def set_programs(self, programs):
        """Sets _programs value to the given one.

        The parameter programs represents a new value.
        """
        self._programs = programs

    def set_separator(self, separator):
        """Set programs separator to the given one.

        The parameter separator is used as new separator.
        """
        self._separator = separator
