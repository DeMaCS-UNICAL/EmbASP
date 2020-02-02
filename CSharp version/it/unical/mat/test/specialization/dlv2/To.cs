using it.unical.mat.embasp.languages;
using System;
using System.Collections.Generic;
using System.Text;

namespace it.unical.mat.test
{
    [Id("to")]
    class To
    {
        [Param(0)]
        private int x;

        public To()
        {
            this.x = 0;
        }

        public To(int x)
        {
            this.x = x;
        }

        public int getX()
        {
            return x;
        }

        public void setX(int x)
        {
            this.x = x;
        }
    }
}
