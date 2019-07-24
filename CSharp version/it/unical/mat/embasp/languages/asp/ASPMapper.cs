using EmbASP.it.unical.mat.embasp.languages.asp;
using it.unical.mat.parsers.asp;
using System;
using System.Collections.Generic;

namespace it.unical.mat.embasp.languages.asp
{
    public class ASPMapper : Mapper
    {
        private static ASPMapper mapper;

        public static ASPMapper Instance
        {
            get
            {
                if (ASPMapper.mapper == null)
                    ASPMapper.mapper = new ASPMapper();
                return ASPMapper.mapper;
            }
        }

        private ASPMapper() : base() { }

        protected internal override string GetActualString(string predicate, Dictionary<int, object> parametersMap)
        {
            if (parametersMap.Count == 0)
                return predicate;

            string atom = predicate + "(";
            for (int i = 0; i < parametersMap.Count; i++)
            {
                if (i != 0)
                    atom += ",";

                object objectTerm = parametersMap[i];
                if (objectTerm == null)
                    throw new IllegalTermException("Wrong term number of predicate " + predicate);

                if (objectTerm is int?)
                    atom += objectTerm + "";
                else if (objectTerm is SymbolicConstant)
                    atom += objectTerm.ToString();
                else
                    atom += "\"" + objectTerm.ToString() + "\"";
            }
            atom += ")";
            return atom;
        }

        protected internal override string GetId(string @string)
        {
            int indexOf = @string.IndexOf("(", StringComparison.Ordinal);
            if (indexOf == -1) // Arity 0
                return @string;
            return @string.Substring(0, indexOf);

        }

        protected internal override string[] GetParam(string @string)
        {
            return ASPParser.Parse(@string).GetParameters();
        }
    }
}