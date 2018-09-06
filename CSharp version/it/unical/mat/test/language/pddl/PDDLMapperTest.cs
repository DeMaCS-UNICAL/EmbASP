using it.unical.mat.embasp.languages.pddl;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace it.unical.mat.test
{
    [TestClass()]
    public class PDDLMapperTest
    {
        [TestMethod()]
        public void Test()
        {
            PDDLMapper instance = PDDLMapper.Instance;

            try
            {
                instance.RegisterClass(typeof(PickUp));

                object @object = instance.GetObject("(pick-up b)");

                Assert.IsTrue(@object is PickUp);
                Assert.AreEqual("b", ((PickUp)@object).getBlock());
            }
            catch (Exception e)
            {
                Assert.Fail(e.Message);
            }
        }
    }
}
