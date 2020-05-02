using Microsoft.VisualStudio.TestTools.UnitTesting;
using it.unical.mat.embasp.@base;
using it.unical.mat.embasp.languages.asp;
using it.unical.mat.embasp.platforms.desktop;
using it.unical.mat.embasp.specializations.dlv2;
using it.unical.mat.embasp.specializations.dlv2.desktop;
using System;
using System.Text;
using System.Collections.Generic;
using it.unical.mat.test.specialization.dlv2;

namespace it.unical.mat.test
{
    [TestClass]
    public class DLV2DesktopServiceTest
    {
        private static int from, to;
        private static List<int> sortedPath;

        [TestMethod] 
        public void ShortestPathTest()
        {
            try
            {
                DesktopHandler handler = new DesktopHandler(new DLV2DesktopService(GetPath()));

                ASPMapper.Instance.RegisterClass(typeof(Edge));
                ASPMapper.Instance.RegisterClass(typeof(Path));

                InputProgram input = new ASPInputProgram();

                from = 0;   // source node
                to = 7;     // destination node

                String rules = "from(" + from + ").to(" + to + ")." +
                    "path(X,Y,W) | notPath(X,Y,W) :- from(X), edge(X,Y,W)." +
                    "path(X,Y,W) | notPath(X,Y,W) :- path(_,X,_), edge(X,Y,W), not to(X)." +
                    "visited(X) :- path(_,X,_)." +
                    ":- to(X), not visited(X)." +
                    ":~ path(X,Y,W). [W@1 ,X,Y]";

                input.AddProgram(rules);
              
                foreach (Edge edge in getEdges())
                {
                    input.AddObjectInput(edge);
                }

                handler.AddProgram(input);

                DLV2AnswerSets answerSets = (DLV2AnswerSets)handler.StartSync();

                Assert.IsNotNull(answerSets);
                Assert.IsTrue(answerSets.GetOptimalAnswerSets().Count != 0);
                Assert.IsTrue(answerSets.ErrorsString == "", "Found error:\n" + answerSets.ErrorsString);

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
                print(sortedPath, sum);           // shows the result

            }
            catch (Exception e)
            {
                Assert.Fail("Exception " + e.Message);
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

            return path.ToString();

        }

    }

}