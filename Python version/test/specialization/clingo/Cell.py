from languages.Predicate import Predicate

class Cell(Predicate):
      
    predicateName="cell"
    
    def __init__(self, row=None, column=None, value=None):
        super(Cell, self).__init__([("row", int), ("column", int), ("value", int)])
        self.row = row
        self.value = value
        self.column = column
          
    def getRow(self):
        return self.row
    def getColumn(self):
        return self.column
    def getValue(self):
        return self.value
    def setRow(self, row):
        self.row = row
    def setColumn(self, column):
        self.column = column
    def setValue(self, value):
        self.value = value