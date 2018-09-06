using it.unical.mat.embasp.@base;
using it.unical.mat.embasp.languages.asp;
using it.unical.mat.embasp.platforms.desktop;
using it.unical.mat.embasp.specializations.clingo.desktop;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.IO;
using System.Text;
using System.Threading;

namespace it.unical.mat.test
{
    [TestClass()]
    public class ClingoDesktopServiceTest
    {
        private readonly CountdownEvent @lock = new CountdownEvent(1);
        private readonly int N = 9;
        private readonly int[,] sudokuMatrix = {{1, 0, 0, 0, 0, 7, 0, 9, 0},
                                                {0, 3, 0, 0, 2, 0, 0, 0, 8},
                                                {0, 0, 9, 6, 0, 0, 5, 0, 0},
                                                {0, 0, 5, 3, 0, 0, 9, 0, 0},
                                                {0, 1, 0, 0, 8, 0, 0, 0, 2},
                                                {6, 0, 0, 0, 0, 4, 0, 0, 0},
                                                {3, 0, 0, 0, 0, 0, 0, 1, 0},
                                                {0, 4, 1, 0, 0, 0, 0, 0, 7},
                                                {0, 0, 7, 0, 0, 0, 3, 0, 0}};
        private AnswerSets answerSets;

        public string GetPath()
        {
            string OS = Environment.OSVersion.ToString();
            StringBuilder path = new StringBuilder();

            path.Append(".." + Path.DirectorySeparatorChar + ".." + Path.DirectorySeparatorChar + "test-resources" + Path.DirectorySeparatorChar + "asp" + Path.DirectorySeparatorChar + "executables");
            path.Append(Path.DirectorySeparatorChar);
            path.Append("clingo");
            path.Append(Path.DirectorySeparatorChar);

            if (OS.IndexOf("win", StringComparison.CurrentCultureIgnoreCase) >= 0)
            {
                if (!System.Environment.Is64BitOperatingSystem)
                    path.Append("clingo32.exe");
                else
                    path.Append("clingo64.exe");
            }
            else if (OS.IndexOf("mac", StringComparison.CurrentCultureIgnoreCase) >= 0)
                path.Append("clingo_macos");
            else if (OS.IndexOf("nux", StringComparison.CurrentCultureIgnoreCase) >= 0)
                path.Append("clingo_linux");

            Console.WriteLine("Full path: " + path.ToString());

            return path.ToString();
        }

        [TestMethod()]
        public void SudokuTest()
        {
            try
            {
                Handler handler = new DesktopHandler(new ClingoDesktopService(GetPath()));
                InputProgram inputProgram = new ASPInputProgram();

                for (int i = 0; i < N; i++)
                    for (int j = 0; j < N; j++)
                        if (sudokuMatrix[i, j] != 0)
                            inputProgram.AddObjectInput(new Cell(i, j, sudokuMatrix[i, j]));

                inputProgram.AddFilesPath(".." + Path.DirectorySeparatorChar + ".." + Path.DirectorySeparatorChar + "test-resources" + Path.DirectorySeparatorChar + "asp" + Path.DirectorySeparatorChar + "sudoku");
                handler.AddProgram(inputProgram);
                handler.StartAsync(new CallbackAction(o =>
                {
                    if (!(o is AnswerSets))
                        return;

                    answerSets = (AnswerSets)o;

                    @lock.Signal();
                }));
                @lock.Wait(new TimeSpan(0, 0, 0, 0, 5000));
                Assert.IsNotNull(answerSets);
                Assert.IsTrue(String.IsNullOrEmpty(answerSets.ErrorsString), "Found error in the Plan\n" + answerSets.ErrorsString);

                if (answerSets.Answersets.Count == 0)
                    return;

                AnswerSet @as = answerSets.Answersets[0];

                foreach (object obj in @as.Atoms)
                {
                    Cell cell = (Cell)obj;
                    sudokuMatrix[cell.getRow(), cell.getColumn()] = cell.getValue();
                }

                for (int i = 0; i < N; i++)
                {
                    for (int j = 0; j < N; j++)
                    {
                        Console.Write(sudokuMatrix[i, j] + " ");

                        if (sudokuMatrix[i, j] == 0)
                            Assert.Fail("NumberNotValid");
                    }

                    Console.WriteLine();
                }
            }
            catch (Exception e)
            {
                Assert.Fail("Exception " + e.Message);
            }
        }
    }
}