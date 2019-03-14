using it.unical.mat.embasp.@base;
using it.unical.mat.embasp.languages.pddl;
using it.unical.mat.embasp.platforms.desktop;
using it.unical.mat.embasp.specializations.solver_planning_domains.desktop;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.IO;
using System.Threading;

namespace it.unical.mat.test
{
    [TestClass()]
    public class SPDDesktopServiceTest
    {
        private CountdownEvent @lock = new CountdownEvent(1);
        private Plan plan;
        private readonly string base_path = ".." + Path.DirectorySeparatorChar + ".." + Path.DirectorySeparatorChar + "test-resources" + Path.DirectorySeparatorChar + "pddl" + Path.DirectorySeparatorChar;

        private void Test(int[] results_sizes, string instance_name)
        {
            string instance_path = base_path + instance_name + Path.DirectorySeparatorChar;

            Console.WriteLine("Testing " + results_sizes.Length + " files for " + instance_path);

            for (int i = 1; i <= results_sizes.Length; i++)
                try
                {
                    plan = null;
                    @lock = new CountdownEvent(1);
                    Handler handler = new DesktopHandler(new SPDDesktopService());

                    Console.WriteLine();

                    InputProgram inputProgramDomain = new PDDLInputProgram(PDDLProgramType.DOMAIN);

                    inputProgramDomain.AddFilesPath(instance_path + "domain.pddl");

                    InputProgram inputProgramProblem = new PDDLInputProgram(PDDLProgramType.PROBLEM);
                    string problem = instance_path + "p" + (i < 10 ? "0" : "") + i + ".pddl";

                    Console.WriteLine(problem);
                    Assert.IsTrue(File.Exists(problem), "File not found: " + problem);
                    inputProgramProblem.AddFilesPath(problem);
                    handler.AddProgram(inputProgramDomain);
                    handler.AddProgram(inputProgramProblem);
                    PDDLMapper.Instance.RegisterClass(typeof(PickUp));
                    Assert.IsNull(plan);
                    handler.StartAsync(new CallbackAction(o =>
                    {
                        if (!(o is Plan))
                            return;

                        plan = (Plan)o;

                        foreach (embasp.languages.pddl.Action action in plan.Actions)
                            Console.Write(action.Name + ",");

                        @lock.Signal();
                    }));
                    @lock.Wait(new TimeSpan(0, 0, 0, 0, 15000));
                    Assert.IsNotNull(plan);

                    if (results_sizes[i - 1] != 0)
                        Assert.IsTrue(String.IsNullOrEmpty(plan.ErrorsString), "Found error in the Plan " + problem + "\n" + plan.ErrorsString);

                    Assert.AreEqual(results_sizes[i - 1], plan.Actions.Count);

                    foreach (object obj in plan.ActionsObjects)
                        if (obj is PickUp)
                        {
                            PickUp pickUp = (PickUp)obj;
                            Console.WriteLine(pickUp.getBlock());
                        }

                    Thread.Sleep(500);
                }
                catch (Exception e)
                {
                    Assert.Fail(e.Message);
                }

            Console.WriteLine();
        }

        [TestMethod()]
        public void TestBlocksworld()
        {
            int[] results_sizes = { 6, 10, 6, 12, 10, 16, 12, 10, 20, 20, 24, 22, 18, 24, 16, 34, 28, 26, 42, 36, 36, 32, 46, 34, 40, 34, 58, 50, 44, 38, 46, 58, 66, 56, 56 };

            Test(results_sizes, "blocksworld");
        }

        [TestMethod()]
        public void TestDepots()
        {
            int[] results_sizes = { 11, 16, 44, 48, 154, 64, 33, 56, 83, 25, 74, 133, 30, 63, 0, 36, 54, 103, 56, 146, 55, 0 };

            Test(results_sizes, "depots");
        }

        [TestMethod()]
        public void TestGripper()
        {
            int[] results_sizes = { 15, 23, 31, 39, 47, 55, 63, 71, 79, 87, 95, 103, 111, 119, 127, 135, 143, 151, 159, 167 };

            Test(results_sizes, "gripper");
        }

        [TestMethod()]
        public void TestLogistics()
        {
            int[] results_sizes = { 24, 27, 15, 34, 17, 10, 30, 14, 33, 34, 58, 53, 48, 68, 46, 49, 74, 48, 0, 84, 69, 117, 134, 102, 109, 127, 141, 128 };

            Test(results_sizes, "logistics");
        }
    }
}
