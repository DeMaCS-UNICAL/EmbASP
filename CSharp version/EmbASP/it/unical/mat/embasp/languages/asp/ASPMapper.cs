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
				{
					ASPMapper.mapper = new ASPMapper();
				}
				return ASPMapper.mapper;
			}
		}

		private ASPMapper() : base()
		{
		}

		protected internal override string getActualString(string predicate, Dictionary<int, object> parametersMap)
		{
			if (parametersMap.Count == 0)
			{
				return predicate;
			}

			string atom = predicate + "(";
			for (int i = 0; i < parametersMap.Count; i++)
			{
				if (i != 0)
				{
					atom += ",";
				}
				object objectTerm = parametersMap[i];
				if (objectTerm == null)
				{
					throw new IllegalTermException("Wrong term number of predicate " + predicate);
				}
				if (objectTerm is int?)
				{
					atom += objectTerm + "";
				}
				else
				{
					atom += "\"" + objectTerm.ToString() + "\"";
				}
			}
			atom += ")";
			return atom;

		}

		protected internal override string[] getParameters(string @string)
		{
			int start = @string.IndexOf("(", StringComparison.Ordinal) + 1;
			int end = @string.LastIndexOf(")", StringComparison.Ordinal);
			// FIXME Not work with "a("asd,"). fix the split
			return start == 0 || end == -1 || end < start ? new string[0] : @string.Substring(start, end - start).Split(',');
		}

		protected internal override string getPredicate(string @string)
		{

			int indexOf = @string.IndexOf("(", StringComparison.Ordinal);

			if (indexOf == -1) // Arity 0
			{
				return @string;
			}

			return @string.Substring(0, @string.IndexOf("(", StringComparison.Ordinal));

		}

	}

}