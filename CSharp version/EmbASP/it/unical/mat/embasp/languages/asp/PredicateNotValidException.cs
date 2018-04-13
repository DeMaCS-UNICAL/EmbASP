using System;

namespace it.unical.mat.embasp.languages.asp
{
	public class PredicateNotValidException : Exception
	{

		private const long serialVersionUID = 1L;

		public PredicateNotValidException() : base("Value of predicate is not valid")
		{
		}

	}

}