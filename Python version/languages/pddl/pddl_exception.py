class PDDLException(Exception):
    """Represents a PDDL Exception."""

    def __init__(self, arg):
        super(PDDLException, self).__init__(arg)
