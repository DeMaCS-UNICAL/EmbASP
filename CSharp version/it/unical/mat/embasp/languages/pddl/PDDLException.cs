using System;

namespace it.unical.mat.embasp.languages.pddl
{
    public class PDDLException : Exception
    {
        private const long serialVersionUID = 1L;

        public PDDLException(string error) : base(error) { }
    }
}