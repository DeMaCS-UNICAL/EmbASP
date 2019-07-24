namespace it.unical.mat.embasp.languages.pddl
{
    public class Action
    {
        private string name;

        public Action(string name) => this.name = name;

        public virtual string Name { get => name; set => this.name = value; }
    }
}