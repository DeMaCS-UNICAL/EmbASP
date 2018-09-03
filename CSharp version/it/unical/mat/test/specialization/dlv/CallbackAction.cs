using it.unical.mat.embasp.@base;
using System;

namespace it.unical.mat.test
{
    public class CallbackAction : ICallback
    {
        private Action<Output> action;

        public CallbackAction(Action<Output> action)
        {
            this.action = action;
        }

        public void Callback(Output o)
        {
            action(o);
        }
    }
}
