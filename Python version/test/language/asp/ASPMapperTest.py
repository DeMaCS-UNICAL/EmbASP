import unittest
from languages.asp.ASPMapper import ASPMapper
from test.specialization.dlv.Cell import Cell



class ASPMapperTest(unittest.TestCase):

    def test(self):
        
        instance = ASPMapper.getInstance()
        
        try:
            instance.registerClass(Cell)
            
            obj = instance.getObject("cell(1,2,5)")
        
            self.assertTrue(isinstance(obj, Cell))
            
            self.assertEqual(1, obj.getRow())
            
            self.assertEqual(2, obj.getColumn())
            
            self.assertEqual(5, obj.getValue())
            
            self.assertEqual("cell(1,2,5)", instance.getString(obj))
            
            instance.unregisterClass(Cell)
            
            noneObject = instance.getObject("cell(1,2,5)")
            
            self.assertIsNone(noneObject)
            
        except Exception as e:
            self.fail(str(e))


if __name__ == '__main__':
    unittest.main()