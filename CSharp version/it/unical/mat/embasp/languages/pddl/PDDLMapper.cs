using System;
using System.Collections.Generic;

namespace it.unical.mat.embasp.languages.pddl
{

	using IllegalTermException = it.unical.mat.embasp.languages.asp.IllegalTermException;

	public class PDDLMapper : Mapper
	{
		private static PDDLMapper mapper;

    public static PDDLMapper Instance {
      get {
        if (PDDLMapper.mapper == null)
          PDDLMapper.mapper = new PDDLMapper();
        return PDDLMapper.mapper;
      }
    }

    private PDDLMapper() : base() { }

    protected internal override string GetActualString(string predicate, Dictionary<int, object> parametersMap) => null;

    protected internal override string[] GetParameters(string @string) =>
        // FIXME I assume that there are spaces only between terms
        @string.Substring(@string.IndexOf(' ') + 1, @string.LastIndexOf(')') - @string.IndexOf(' ') - 1).Split(' ');



    protected internal override string GetPredicate(string @string)
		{
			// I assume that the string is like (zoom plane1 city4 city1 fl4 fl3 fl2)
			int initialB = @string.IndexOf("(");

			if (initialB != 0)
				throw new System.ArgumentException("Wrong format");

      return @string.Substring(1, @string.IndexOf(' ') - 1);
		}
	}
}