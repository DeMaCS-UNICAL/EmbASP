class OptionDescriptor(object):
    """Represents options for a generic ASP programs."""

    def __init__(self, initial_option=None):
        self._options = initial_option  # Where options are stored
        self._separator = ""  # Used as option separator

    def add_option(self, option):
        """Concatenate a new option in a string format to the current _options.

        The parameter option is the string to be concatenated.
        """
        if self._options is None or self._options == "":
            self.set_options(option)
        else:
            self._options += self._separator + option

    def clear(self):
        """After using this method the _options variable will be empty."""
        self._options = ""

    def get_options(self):
        """Returns values stored in _options, in a string format."""
        return self._options

    def get_separator(self):
        """Get separator character."""
        return self._separator

    def set_options(self, option):
        """Set _option string with new string."""
        self._options = option

    def set_separator(self, separator):
        """Set _separator character with new separator."""
        self._separator = separator
