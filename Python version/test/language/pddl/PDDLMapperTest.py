import unittest
from languages.pddl.PDDLMapper import PDDLMapper
from test.specialization.solver_planning_domains.PickUp import PickUp


class PDDLMapperTest(unittest.TestCase):

    def test(self):
        
        instance = PDDLMapper.getInstance()
        
        try:
            instance.registerClass(PickUp)
            
            obj = instance.getObject("(pick-up b)")
        
            self.assertTrue(isinstance(obj, PickUp))
            
            self.assertEqual("b", obj.getBlock())
            
        except Exception as e:
            self.fail(str(e))


if __name__ == '__main__':
    unittest.main()