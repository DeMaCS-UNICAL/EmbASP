using it.unical.mat.embasp.languages;

namespace it.unical.mat.test
{
    [Id("pick-up")]
    public class PickUp
    {
        [Param(0)]
        private string block;

        public PickUp()
        {

        }

        public string getBlock()
        {
            return block;
        }

        public void setBlock(string block)
        {
            this.block = block;
        }
    }
}
