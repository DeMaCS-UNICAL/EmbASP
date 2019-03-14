using it.unical.mat.parsers.pddl;
using System;
using System.Collections.Generic;

namespace it.unical.mat.embasp.languages.pddl
{

    using IllegalTermException = it.unical.mat.embasp.languages.asp.IllegalTermException;

    public class PDDLMapper : Mapper
    {
        private static PDDLMapper mapper;

        public static PDDLMapper Instance
        {
            get
            {
                if (PDDLMapper.mapper == null)
                    PDDLMapper.mapper = new PDDLMapper();
                return PDDLMapper.mapper;
            }
        }

        private PDDLMapper() : base() { }

        protected internal override string GetActualString(string predicate, Dictionary<int, object> parametersMap) => null;

        protected internal override string GetId(string @string)
        {
            // I assume that the string is like (zoom plane1 city4 city1 fl4 fl3 fl2)
            int initialB = @string.IndexOf("(");

            if (initialB != 0)
                throw new System.ArgumentException("Wrong format");

            return @string.Substring(1, @string.IndexOf(' ') - 1);
        }

        protected internal override string[] GetParam(string @string) => PDDLParser.Parse(@string).GetParameters();
    }
}