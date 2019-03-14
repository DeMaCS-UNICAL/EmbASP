from languages.predicate import Predicate


class PickUp(Predicate):

    predicate_name = "pick-up"

    def __init__(self, block=None):
        super(PickUp, self).__init__(["block"])
        self.block = block

    def get_block(self):
        return self.block

    def set_block(self, block):
        self.block = block
