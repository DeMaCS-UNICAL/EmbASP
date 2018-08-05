from languages.predicate import Predicate


class Cell(Predicate):

    predicate_name = "cell"

    def __init__(self, row=None, column=None, value=None):
        super(Cell, self).__init__(
            [("row", int), ("column", int), ("value", int)])
        self.row = row
        self.value = value
        self.column = column

    def get_row(self):
        return self.row

    def get_column(self):
        return self.column

    def get_value(self):
        return self.value

    def set_row(self, row):
        self.row = row

    def set_column(self, column):
        self.column = column

    def set_value(self, value):
        self.value = value
