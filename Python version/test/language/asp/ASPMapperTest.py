import unittest
from languages.asp.ASPMapper import ASPMapper
from test.specialization.dlv.Cell import Cell



class ASPMapperTest(unittest.TestCase):

    def test(self):
        
        instance = ASPMapper.getInstance()
        
        try:
            instance.registerClass(Cell)
            
            objs = instance.getObjects("cell(1,2,5)")
            
            self.assertTrue(isinstance(objs, set))
            self.assertEqual(1, len(objs))
            
            for obj in objs:
                self.assertTrue(isinstance(obj, Cell))
                self.assertEqual(1, obj.getRow())
                self.assertEqual(2, obj.getColumn())
                self.assertEqual(5, obj.getValue())
                self.assertEqual("cell(1,2,5)", instance.getString(obj))
            
            instance.unregisterClass(Cell)
            
            noneObject = instance.getObjects("cell(1,2,5)")
            
            self.assertEqual(0, len(noneObject))
            
        except Exception as e:
            self.fail(str(e))


if __name__ == '__main__':
    unittest.main()