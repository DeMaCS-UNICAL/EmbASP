import unittest
from languages.asp.asp_mapper import ASPMapper
from test.language.asp.cell import Cell


class ASPMapperTest(unittest.TestCase):

    def runTest(self):

        instance = ASPMapper.get_instance()

        try:
            instance.register_class(Cell)

            obj = instance.get_object("cell(1,2,5)")

            self.assertTrue(isinstance(obj, Cell))

            self.assertEqual(1, obj.get_row())

            self.assertEqual(2, obj.get_column())

            self.assertEqual('5', obj.get_value().value)

            print(instance.get_string(obj))

            self.assertEqual("cell(1,2,5)", instance.get_string(obj))

            instance.unregister_class(Cell)

            noneObject = instance.get_object("cell(1,2,5)")

            self.assertIsNone(noneObject)

        except Exception as e:
            self.fail(str(e))


if __name__ == '__main__':
    unittest.main()
