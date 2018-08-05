import unittest
from languages.pddl.pddl_mapper import PDDLMapper
from test.specialization.solver_planning_domains.pick_up import PickUp


class PDDLMapperTest(unittest.TestCase):

    def test(self):

        instance = PDDLMapper.get_instance()

        try:
            instance.register_class(PickUp)

            obj = instance.get_object("(pick-up b)")

            self.assertTrue(isinstance(obj, PickUp))

            self.assertEqual("b", obj.get_block())

        except Exception as e:
            self.fail(str(e))


if __name__ == '__main__':
    unittest.main()
