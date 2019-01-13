using System;

namespace it.unical.mat.embasp.languages
{
    public class IllegalAnnotationException : Exception
    {
        public IllegalAnnotationException() : base("bad annotation") { }
    }
}