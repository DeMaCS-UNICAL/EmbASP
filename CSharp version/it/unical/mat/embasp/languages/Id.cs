using System;

namespace it.unical.mat.embasp.languages
{
    [AttributeUsage(AttributeTargets.Class, AllowMultiple = false, Inherited = false)]
    public class Id : System.Attribute
    {
        internal string value;

        public Id(String value) => this.value = value;
    }
}