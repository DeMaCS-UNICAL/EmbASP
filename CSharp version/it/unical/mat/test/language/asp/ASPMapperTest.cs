using it.unical.mat.embasp.languages.asp;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace it.unical.mat.test
{
    [TestClass()]
    public class ASPMapperTest
    {
        [TestMethod()]
        public void Test()
        {
            ASPMapper instance = ASPMapper.Instance;

            try
            {
                instance.RegisterClass(typeof(Cell));

                Object @object = instance.GetObject("cell(1,2,5)");

                Assert.IsTrue(@object is Cell);
                Assert.AreEqual(1, ((Cell)@object).getRow());
                Assert.AreEqual(2, ((Cell)@object).getColumn());
                Assert.AreEqual(5, ((Cell)@object).getValue());
                Assert.AreEqual("cell(1,2,5)", instance.GetString(@object));
                instance.UnregisterClass(typeof(Cell));

                object nullObject = instance.GetObject("cell(1,2,5)");

                Assert.IsNull(nullObject);
                instance.RegisterClass(typeof(Arity0));

                object object1 = instance.GetObject("a");

                Assert.IsNotNull(object1);
                Assert.IsTrue(object1 is Arity0);
                Assert.AreEqual("a", instance.GetString(object1));
            }
            catch (Exception e)
            {
                Assert.Fail(e.Message);
            }
        }
    }
}
