namespace Parsers.ASP
{
    public interface IASPDataCollection
    {
        void AddAnswerSet();
        void StoreAtom(string atom);
        void StoreCost(int level, int weight); 
    }
}