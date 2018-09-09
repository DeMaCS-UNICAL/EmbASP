from abc import ABCMeta


class Handler(object):
    """A collection of InputProgram and OptionDescriptor.

    The subclasses have to implement start_async(Callback, List, List)
    and start_sync(List, List) methods.
    """
    __metaclass__ = ABCMeta

    def __init__(self):
        self._programs = dict()  # Is where InputProgram elements are stored.
        self._options = dict()  # Is where OptionDescriptor elements are stored

    def add_option(self, o):
        """Add a new element inside _options dict.

        The o parameter is the new OptionDescriptor instance. The method
        return the id associated whit the added OptionDescriptor
        instance.
        """
        last_index = len(self._options)
        current_value = last_index
        self._options[last_index] = o
        return current_value

    def add_program(self, program):
        """Add a new element inside _programs dict.

        The program param is the InputProgram instance added to the
        collection. The method return the id associated whit the added
        InputProgram instance.
        """
        last_index = len(self._programs)
        current_value = last_index
        self._programs[last_index] = program
        return current_value

    def _collect_options(self, option_index):
        """Return a list of options in _options dict, according to set of
        indexes given.

        If option_index is empty, the method return a list of all
        options.
        """
        input_option = list()
        if not option_index:
            for k in self._options.keys():
                input_option.append(self._options.get(k))
        else:
            for index in option_index:
                input_option.append(self._options.get(index))
        return input_option

    def _collect_programs(self, program_index):
        """Return a list of programs in _programs dict, according to set of
        indexes given.

        If program_index is empty, the method return a list of all
        program.
        """
        input_programs = list()
        if not program_index:
            for k in self._programs.keys():
                input_programs.append(self._programs.get(k))
        else:
            for index in program_index:
                input_programs.append(self._programs.get(index))
        return input_programs

    def get_input_program(self, key):
        """Returns the specified InputProgram element.

        The parameter key represents the id. The method return the
        InputProgram element associated with the given key.
        """
        return self._programs.get(key)

    def get_option_descriptor(self, key):
        """Returns the specified OptionDescriptor element.

        The parameter key represents the id. The method return the
        OptionDescriptor element associated with the given key.
        """
        return self._options.get(key)

    def remove_all(self):
        """Removes all the elements from _programs and _options.

        Both the collections will be empty after this method returns.
        """
        self._options.clear()
        self._programs.clear()

    def remove_option_from_id(self, option_id):
        """Removes the element associated with the given id from _options
        dict.

        option_id represents the id associated with an element.
        """
        self._options.pop(option_id)

    def remove_option_from_value(self, o):
        """Removes every occurrence of a specified OptionDescriptor element
        from _options dict.

        the parameter o represents the element to be removed.
        The method return true if one or more elements are removed,
        false otherwise
        """
        result = False
        for k in self._options:
            if self._options.get(k) == o:
                self._options.pop(k)
                result = True
        return result

    def remove_program_from_value(self, p):
        """Removes every occurrence of a specified InputProgram element from
        _programs dict.

        The parameter p represents the element to be removed.
        The method returns true if one or more elements are removed,
        false otherwise
        """
        result = False
        for k in self._programs:
            if self._programs.get(k) == p:
                self._programs.pop(k)
                result = True
        return result

    def remove_program_from_id(self, program_id):
        """Removes the element associated with the given id from _programs}
        dict.

        The parameter program_id represents the id associated with an
        element
        """
        self._programs.pop(program_id)

    def start_async(self, c, program_index=None, option_index=None):
        """This method have to be implemented by subclasses to execute solver
        in an asynchronous way, if no parameters are given, the entire sets of
        programs and option are used."""
        pass

    def start_sync(self, program_index=None, option_index=None):
        """This method have to be implemented by subclasses to execute solver
        in a synchronous way, if no parameters are given, the entire sets of
        programs and option are used."""
        return None
