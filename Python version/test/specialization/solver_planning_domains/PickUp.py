from languages.Predicate import Predicate

class PickUp(Predicate):
      
    predicateName="pick-up"
    
    def __init__(self, block=None):
        super(PickUp, self).__init__([("block")])
        self.block = block
          
    def getBlock(self):
        return self.block
    
    def setBlock(self, block):
        self.block = block