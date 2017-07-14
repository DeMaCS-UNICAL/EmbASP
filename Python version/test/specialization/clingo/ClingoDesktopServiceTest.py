import unittest
from languages.asp.ASPInputProgram import ASPInputProgram
from platforms.desktop.DesktopHandler import DesktopHandler
from base.Output import Output
from test.specialization.clingo.Cell import Cell
from test.specialization.clingo.MyCallback import MyCallback
import sys
import os
from specializations.clingo.desktop.ClingoDesktopService import ClingoDesktopService


class ClingoDesktopServiceTest(unittest.TestCase):

    n = 9
    inputMatrix = [ [ 1, 0, 0, 0, 0, 7, 0, 9, 0 ],
                    [ 0, 3, 0, 0, 2, 0, 0, 0, 8 ],
                    [ 0, 0, 9, 6, 0, 0, 5, 0, 0 ],
                    [ 0, 0, 5, 3, 0, 0, 9, 0, 0 ],
                    [ 0, 1, 0, 0, 8, 0, 0, 0, 2 ],
                    [ 6, 0, 0, 0, 0, 4, 0, 0, 0 ],
                    [ 3, 0, 0, 0, 0, 0, 0, 1, 0 ],
                    [ 0, 4, 1, 0, 0, 0, 0, 0, 7 ],
                    [ 0, 0, 7, 0, 0, 0, 3, 0, 0 ] ]
    
    
    def getPath(self):
        OS = sys.platform
        path = os.path.join("..", "..", "resources", "asp", "executables")
        if OS.startswith("win32"):
            if sys.maxsize > 2**32:
                path = os.path.join(path, "clingo64.exe")
            else:
                path = os.path.join(path, "clingo32.exe")
        else:
            if OS.startswith("darwin"):
                path = os.path.join(path, "clingo_macos")
            else:
                if OS.startswith("linux"):
                    path = os.path.join(path, "clingo_linux")
                    
        return path

    def test_sudoku(self):
        try:
            handler = DesktopHandler(ClingoDesktopService(self.getPath()))
 
            inp = ASPInputProgram()
            
            for i in range(9):
                for j in range(9):
                    if (self.inputMatrix[i][j] != 0):
                        inp.addObjectInput(Cell(i,j,self.inputMatrix[i][j]))
                      
            inp.addFilesPath(os.path.join("..", "..","resources", "asp", "sudoku"))
             
            handler.addProgram(inp)
            
            
            mc = MyCallback()
  
            handler.startAsync(mc)
            
            mc.await()
               
            out = mc.getOutput()
            
            # out = handler.startSync()  
              
            
            self.assertIsNotNone(out)
            
            self.assertTrue(isinstance(out, Output), "Error, result object is not Output")

            self.assertIsNone(out.getErrors(), "Found error in the Plan\n" + str(out.getErrors()))
            
            
            if (len(out.getAnswerSets()) == 0):
                return
            
            ans = out.getAnswerSets()[0]
             
            for obj in ans.getAtoms():
                self.inputMatrix[obj.getRow()][obj.getColumn()] = obj.getValue()
            
            tmp=""
            for i in range(9):
                for j in range(9):
                    tmp += str(self.inputMatrix[i][j]) + " "
                print(tmp)
                tmp=""
            
        except Exception as e:
            self.fail("Exception " + str(e))

if __name__ == '__main__':
    unittest.main()