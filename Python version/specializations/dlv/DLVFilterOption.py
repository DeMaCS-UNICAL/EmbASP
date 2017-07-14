from languages.asp.ASPFilterOption import ASPFilterOption

class DLVFilterOption(ASPFilterOption):
    """Represent a filter option that's possible to add on a call of DLV execution, for filtering output generated by the solver"""
    def __init__(self, initial_option):
        self._options += initial_option