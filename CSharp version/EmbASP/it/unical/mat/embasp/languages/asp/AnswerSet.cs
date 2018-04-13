using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;


namespace it.unical.mat.embasp.languages.asp
{

	public class AnswerSet
	{

		private readonly IList<string> value;
		private readonly IDictionary<int, int> weight_map;
		private ISet<object> atoms;

		public AnswerSet(IList<string> output)
		{
			value = output;
			weight_map = new Dictionary<int, int>();
		}

		public AnswerSet(IList<string> value, IDictionary<int, int> weightMap)
		{
			this.value = value;
			weight_map = weightMap;
		}

		public virtual IList<string> getAnswerSet()
		{
      return new ReadOnlyCollection<string>(value);
		}

		public virtual ISet<object> Atoms
		{
			get
			{
				if (atoms == null)
				{
					atoms = new HashSet<object>();
					ASPMapper mapper = ASPMapper.Instance;
					foreach (String atom in value)
					{
            //Console.WriteLine("ATOM NAME {0}", atom);
						object obj = mapper.getObject(atom);
						if (obj != null)
						{
							atoms.Add(obj);
						}
					}
				}
    
				return atoms;
			}
		}

		public virtual IDictionary<int, int> LevelWeight
		{
			get
			{
				return weight_map;
			}
		}

		public virtual IDictionary<int, int> Weights
		{
			get
			{
        return new ReadOnlyDictionary<int,int>(weight_map);
			}
		}

		public override string ToString()
		{
			return value.ToString();
		}
	}

}