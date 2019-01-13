class Action(object):
    """Represents a generic Action."""

    def __init__(self, name):
        self.__name = name

    def get_name(self):
        """Return the name of Action."""
        return self.__name

    def set_name(self, name):
        """Sets the name of Action."""
        self.name = name
