import unittest
from languages.asp.asp_input_program import ASPInputProgram
from platforms.desktop.desktop_handler import DesktopHandler
from specializations.dlv.desktop.dlv_desktop_service import DLVDesktopService
from base.output import Output
from .cell import Cell
from .my_callback import MyCallback
import sys
import os


class DLVDesktopServiceTest(unittest.TestCase):

    n = 9
    inputMatrix = [[1, 0, 0, 0, 0, 7, 0, 9, 0],
                   [0, 3, 0, 0, 2, 0, 0, 0, 8],
                   [0, 0, 9, 6, 0, 0, 5, 0, 0],
                   [0, 0, 5, 3, 0, 0, 9, 0, 0],
                   [0, 1, 0, 0, 8, 0, 0, 0, 2],
                   [6, 0, 0, 0, 0, 4, 0, 0, 0],
                   [3, 0, 0, 0, 0, 0, 0, 1, 0],
                   [0, 4, 1, 0, 0, 0, 0, 0, 7],
                   [0, 0, 7, 0, 0, 0, 3, 0, 0]]

    def getPath(self):
        OS = sys.platform
        path = os.path.join("..", "..", "..", "..",
                            "test-resources", "asp", "executables", "dlv")
        if OS.startswith("win32"):
            path = os.path.join(path, "dlv.mingw.exe")
        else:
            if OS.startswith("darwin"):
                path = os.path.join(path, "dlv.i386-apple-darwin.bin")
            else:
                if OS.startswith("linux"):
                    if sys.maxsize > 2**32:
                        path = os.path.join(
                            path, "dlv.x86-64-linux-elf-static.bin")
                    else:
                        path = os.path.join(
                            path, "dlv.i386-linux-elf-static.bin")
        return path

    def test_sudoku(self):
        try:
            handler = DesktopHandler(DLVDesktopService(self.getPath()))

            inp = ASPInputProgram()

            for i in range(9):
                for j in range(9):
                    if self.inputMatrix[i][j] != 0:
                        inp.add_object_input(
                            Cell(i, j, self.inputMatrix[i][j]))

            inp.add_files_path(os.path.join(
                "..", "..", "..", "..", "test-resources", "asp", "sudoku"))

            handler.add_program(inp)

            mc = MyCallback()

            handler.start_async(mc)

            mc.await()

            out = mc.get_output()

            # out = handler.startSync()

            self.assertIsNotNone(out)

            self.assertTrue(isinstance(out, Output),
                            "Error, result object is not Output")

            self.assertIsNone(out.get_errors(),
                              "Found error in the Plan\n" + str(out.get_errors()))

            if len(out.get_answer_sets()) == 0:
                return

            ans = out.get_answer_sets()[0]

            for obj in ans.get_atoms():
                self.inputMatrix[obj.get_row()][obj.get_column()
                                                ] = obj.get_value()

            tmp = ""
            for i in range(9):
                for j in range(9):
                    tmp += str(self.inputMatrix[i][j]) + " "
                print(tmp)
                tmp = ""

        except Exception as e:
            self.fail("Exception " + str(e))


if __name__ == '__main__':
    unittest.main()
