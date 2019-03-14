using System;

namespace it.unical.mat.embasp.languages
{
    [AttributeUsage(AttributeTargets.Field, AllowMultiple = false, Inherited = false)]
    public class Param : System.Attribute
    {
        internal int value;

        public Param(int value) => this.value = value;
    }
}