using Microsoft.VisualStudio.TestTools.UnitTesting;
using it.unical.mat.embasp.@base;
using it.unical.mat.embasp.languages.asp;
using it.unical.mat.embasp.platforms.desktop;
using it.unical.mat.embasp.specializations.dlv2;
using it.unical.mat.embasp.specializations.dlv2.desktop;
using System;
using System.IO;
using System.Text;
using System.Collections.Generic;

namespace it.unical.mat.test
{
    [TestClass]
    public class DLV2DesktopServiceTest
    {

        private static int from, to;
        private static List<int> sortedPath;

        [TestMethod]
        public void TestMethod1()
        {
            try
            {

                DesktopHandler handler = new DesktopHandler(new DLV2DesktopService(GetPath()));

                ASPMapper.Instance.RegisterClass(typeof(Edge));
                ASPMapper.Instance.RegisterClass(typeof(Path));
                ASPMapper.Instance.RegisterClass(typeof(From));
                ASPMapper.Instance.RegisterClass(typeof(To));

                InputProgram input = new ASPInputProgram();

                from = 0;   // source node
                to = 7;     // destination node

                input.AddProgram("from(" + from + "). to(" + to + ").");
                
                input.AddFilesPath(".." + System.IO.Path.DirectorySeparatorChar + ".." + System.IO.Path.DirectorySeparatorChar +
                    "test-resources" + System.IO.Path.DirectorySeparatorChar + "asp" + System.IO.Path.DirectorySeparatorChar + "shortestPath");

                foreach (Edge edge in getEdges())
                {
                    input.AddObjectInput(edge);
                }

                handler.AddProgram(input);

                DLV2AnswerSets answerSets = (DLV2AnswerSets)handler.StartSync();

                Assert.IsNotNull(answerSets);
                Assert.AreEqual(1, answerSets.GetOptimalAnswerSets().Count);

                AnswerSet answerSet = answerSets.GetOptimalAnswerSets()[0];

                List<Path> path = new List<Path>();    //  edges in the shortest path (unsorted)
                int sum = 0;                           //  total weight of the path

                foreach (object obj in answerSet.Atoms)
                {
                    if (typeof(Path).IsInstanceOfType(obj))
                    {
                        path.Add((Path)obj);
                        sum += ((Path)obj).getWeight();
                    }
                }
                
                sortedPath = new List<int>();     // edges in the shorted path (sorted)
                sortedPath.Add(from);

                join(from, path, sortedPath);     // sorts the edges
                print(sortedPath, sum);           // show the result

                List<int> result = getResult();
                for(int i=0; i<sortedPath.Count; i++)
                {
                    Assert.AreEqual(sortedPath[i], result[i]);
                }
                Assert.AreEqual(sum, 5);

            }
            catch (Exception e)
            {
                Assert.Fail("Exception " + e.Source);
            }
        }

        private static List<Edge> getEdges()
        {
            List<Edge> edges = new List<Edge>();

            edges.Add(new Edge(0, 1, 1));
            edges.Add(new Edge(0, 2, 4));
            edges.Add(new Edge(1, 2, 2));
            edges.Add(new Edge(1, 3, 4));
            edges.Add(new Edge(1, 4, 1));
            edges.Add(new Edge(2, 4, 4));
            edges.Add(new Edge(3, 5, 6));
            edges.Add(new Edge(3, 6, 1));
            edges.Add(new Edge(4, 3, 1));
            edges.Add(new Edge(6, 4, 5));
            edges.Add(new Edge(6, 5, 9));
            edges.Add(new Edge(6, 7, 1));
            edges.Add(new Edge(7, 5, 2));

            return edges;
        }

        private static List<int> getResult()
        {
            List<int> result = new List<int>();

            result.Add(0);
            result.Add(1);
            result.Add(4);
            result.Add(3);
            result.Add(6);
            result.Add(7);

            return result;
        }

        private static void join(int from, List<Path> path, List<int> sortedPath)
        {
            foreach (Path p in path)
            {
                if (p.getFrom() == from)
                {
                    sortedPath.Add(p.getTo());
                    if (p.getTo() == to)
                    {
                        return;
                    }
                    join(p.getTo(), path, sortedPath);
                    return;
                }
            }
        }

        private static void print(List<int> path, int sum)
        {
            Console.Write("path = ");
            bool first = true;
            foreach (int n in path)
            {
                if (!first)
                {
                    Console.Write(" - ");
                }
                else
                {
                    first = false;
                }
                Console.Write(n);
            }
            Console.WriteLine("\nsum = " + sum);
        }

        public string GetPath()
        {
            //Console.WriteLine("current directory: " + Directory.GetCurrentDirectory()); 

            string OS = Environment.OSVersion.ToString();
            StringBuilder path = new StringBuilder();

            path.Append(".." + System.IO.Path.DirectorySeparatorChar + ".." + System.IO.Path.DirectorySeparatorChar);
            path.Append("test-resources" + System.IO.Path.DirectorySeparatorChar + "asp" + System.IO.Path.DirectorySeparatorChar);
            path.Append("executables" + System.IO.Path.DirectorySeparatorChar + "dlv2" + System.IO.Path.DirectorySeparatorChar);
            
            if (OS.IndexOf("win", StringComparison.CurrentCultureIgnoreCase) >= 0)
            {
                if (System.Environment.Is64BitOperatingSystem)
                    path.Append("dlv2.win.64");
                else
                    path.Append("dlv2.win.32");
            }
            else if (OS.IndexOf("nux", StringComparison.CurrentCultureIgnoreCase) >= 0)
            {
                if (System.Environment.Is64BitOperatingSystem)
                    path.Append("dlv2.linux.64");
                else
                    path.Append("dlv2.linux.32");
            }
            else if (OS.IndexOf("mac", StringComparison.CurrentCultureIgnoreCase) >= 0)
            {
                path.Append("dlv2.mac");
            }

            Console.WriteLine("executable's path: " + path.ToString());

            return path.ToString();
        }

    }
}
