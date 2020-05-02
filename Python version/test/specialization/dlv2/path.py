from languages.predicate import Predicate

class Path(Predicate):
    predicate_name = "path"
    
    def __init__(self, source=None, destination=None, weight=None):
        Predicate.__init__(self, [("source"),("destination"),("weight")])
        self.source = source
        self.destination = destination
        self.weight = weight
        
    def get_source(self):
        return self.source
    
    def get_destination(self):
        return self.destination
    
    def get_weight(self):
        return self.weight
    
    def set_source(self, source):
        self.source = source
        
    def set_destination(self, destination):
        self.destination = destination
        
    def set_weight(self, weight):
        self.weight = weight
        
    def __str__(self):
        return "path(" + str(self.source) + "," + str(self.destination) + "," + str(self.weight) + ")."