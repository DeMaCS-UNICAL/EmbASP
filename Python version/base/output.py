class Output(object):
    """Represents a generic output for a solver."""

    def __init__(self, output=None, errors=None):
        self._output = output  # Variable in which results are stored
        self._errors = errors  # The errors thrown by the solver

    def get_errors(self):
        """Get error string."""
        return self._errors

    def get_output(self):
        """Get output string."""
        return self._output

    def set_errors(self, errors):
        """Set error string."""
        self._errors = errors

    def set_output(self, output):
        """Set output string."""
        self._output = output

    def _parse(self):
        """This method have to be implemented by subclasses to parse a solver
        output."""
        pass
