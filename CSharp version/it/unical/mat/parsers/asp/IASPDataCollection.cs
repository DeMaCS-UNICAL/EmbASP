namespace it.unical.mat.parsers.asp
{
    public interface IASPDataCollection
    {
        void AddAnswerSet();
        void StoreAtom(string atom);
        void StoreCost(int level, int weight);
    }
}