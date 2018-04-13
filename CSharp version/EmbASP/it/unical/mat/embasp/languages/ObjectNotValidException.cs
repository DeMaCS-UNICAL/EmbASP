using System;

namespace it.unical.mat.embasp.languages
{
	public class ObjectNotValidException : Exception
	{

		/// 
		private const long serialVersionUID = 1L;

		public ObjectNotValidException() : base("Value of the object is not valid")
		{
		}

	}

}