using it.unical.mat.embasp.languages;

namespace it.unical.mat.test
{
    [Id("cell")]
    class Cell
    {
        [Param(0)]
        private int row;
        [Param(1)]
        private int column;
        [Param(2)]
        private int value;

        public Cell()
        {
            row = column = value = 0;
        }

        public Cell(int row, int column, int value)
        {
            this.row = row;
            this.column = column;
            this.value = value;
        }

        public int getRow()
        {
            return row;
        }

        public void setRow(int row)
        {
            this.row = row;
        }

        public int getColumn()
        {
            return column;
        }

        public void setColumn(int column)
        {
            this.column = column;
        }

        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
        }

        public override string ToString()
        {
            return "Cell{" + "row=" + row + " column=" + column + " value=" + value + "}";
        }
    }
}
