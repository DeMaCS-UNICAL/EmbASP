using it.unical.mat.parsers.asp;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;

namespace it.unical.mat.embasp.languages.asp
{
    using Output = it.unical.mat.embasp.@base.Output;

    public abstract class AnswerSets : Output, IASPDataCollection
    {
        protected internal IList<AnswerSet> answersets;

        public AnswerSets(string @out) : base(@out) { }

        public AnswerSets(string @out, string err) : base(@out, err) { }

        public override object Clone() => base.Clone();

        public virtual IList<AnswerSet> Answersets
        {
            get
            {
                if (answersets == null)
                {
                    answersets = new List<AnswerSet>();
                    Parse();
                }
                return new ReadOnlyCollection<AnswerSet>(answersets);
            }
        }

        public virtual IList<AnswerSet> GetOptimalAnswerSets()
        {
            int level = 0;
            IList<AnswerSet> answerSets = Answersets, optimalAnswerSets = new List<AnswerSet>();

            foreach (AnswerSet answerSet in answerSets)
            {
                int maxLevel = answerSet.LevelWeight.Keys.Max();

                if (level < maxLevel)
                    level = maxLevel;
            }

            for (; level >= 1; level--)
            {
                int minimumCost = int.MaxValue;

                foreach (AnswerSet answerSet in answerSets)
                {
                    int cost = answerSet.Weights.TryGetValue(level, out cost) ? cost : 0;

                    if (cost < minimumCost)
                    {
                        optimalAnswerSets.Clear();

                        minimumCost = cost;
                    }

                    if (cost == minimumCost)
                        optimalAnswerSets.Add(answerSet);
                }

                answerSets = new List<AnswerSet>(optimalAnswerSets);
            }

            return optimalAnswerSets;
        }

        public virtual string AnswerSetsString => output;

        public void AddAnswerSet()
        {
            answersets.Add(new AnswerSet(new List<string>()));
        }

        public void StoreAtom(string result)
        {
            answersets[answersets.Count - 1].Value.Add(result);
        }

        public void StoreCost(int level, int weight)
        {
            answersets[answersets.Count - 1].LevelWeight.Add(level, weight);
        }
    }
}