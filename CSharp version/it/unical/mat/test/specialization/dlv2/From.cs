using it.unical.mat.embasp.languages;
using System;
using System.Collections.Generic;
using System.Text;

namespace it.unical.mat.test
{
    [Id("from")]
    class From
    {
        [Param(0)]
        private int x;

        public From()
        {
            this.x = 0;
        }

        public From(int x)
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
