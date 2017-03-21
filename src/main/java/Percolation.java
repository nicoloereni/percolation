package main.java;

public class Percolation
{
    private static final int BLOCKED = 0;
    private static final int OPEN = 1;
    private static final int FULL = 2;
    private int dimension;
    private Integer [][] grid;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n)
    {

        validateDimension(n);
        this.dimension = n;
        this.grid = new Integer[this.dimension][this.dimension];

        initGrid();

    }

    private void initGrid() {

        for(int rowIndex = 1; rowIndex <= dimension; rowIndex++)
        {
            for(int columnIndex = 1; columnIndex <= dimension; columnIndex++)
            {
                assignGridValueAt(rowIndex, columnIndex, BLOCKED);
            }
        }

    }

    private void assignGridValueAt(int rowIndex, int columnIndex, int value) {

        grid[rowIndex - 1][columnIndex - 1] = value;

    }

    private void validateDimension(int dimension) throws IllegalArgumentException
    {

        if(dimension <= 0)
        {
            throw new IllegalArgumentException("Wrong dimension");
        }

    }

    // open site (row, col) if it is not open already
    public void open(int row, int col)
    {

        validateCoordinates(row, col);

        if(row == 1 || hasFullNeighboring(row,col))
        {
            assignGridValueAt(row, col, FULL);
        }
        else
        {
            assignGridValueAt(row, col, OPEN);
        }

    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col)
    {

        validateCoordinates(row, col);

        return gridValueAt(row, col) == OPEN || gridValueAt(row, col) == FULL;

    }

    private Integer gridValueAt(int row, int column) {

        return grid[row -1][column -1];

    }

    // is site (row, col) full?
    public boolean isFull(int row, int col)
    {

        validateCoordinates(row, col);

        boolean result = false;
        boolean open = isOpen(row, col);

        if(gridValueAt(row, col) == FULL)
        {
            result = true;
        }
        else if (row == 1 && open)
        {
            result = true;
        }
        else if(open && hasFullNeighboring(row, col))
        {
            result = true;
        }

        return result;

    }

    private boolean hasFullNeighboring(int row, int col) {

        boolean result = false;

        if(gridValueAt(row, col) == FULL)
        {
            result = true;
        }
        else if(isLeftFull(row, col))
        {
            result = true;
        }
        else if(isRightFull(row, col))
        {
            result = true;
        }
        else if(isBottomFull(row, col))
        {
            result = true;
        }
        else if(isUpFull(row, col))
        {
            result = true;
        }

        return result;

    }

    private boolean isUpFull(int row, int col) {

        int rowUpIndex = row + 1;
        return rowUpIndex <= this.dimension && (gridValueAt(rowUpIndex, col) == FULL || isFull(rowUpIndex, col));

    }

    private boolean isBottomFull(int row, int col) {

        int bottomRowIndex = row - 1;
        return bottomRowIndex > 0 && (gridValueAt(bottomRowIndex, col) == FULL || isFull(bottomRowIndex, col));

    }

    private boolean isRightFull(int row, int col) {

        int rightColumnIndex = col + 1;
        return rightColumnIndex <= this.dimension && (gridValueAt(row, rightColumnIndex) == FULL || isFull(row, rightColumnIndex));

    }

    private boolean isLeftFull(int row, int col) {

        int leftColumnIndex = col - 1;
        return leftColumnIndex > 0 && (gridValueAt(row, leftColumnIndex) == FULL || isFull(row, leftColumnIndex));

    }

    // number of open sites
    public int numberOfOpenSites()
    {

        int result = 0;

        for(int rowIndex = 1; rowIndex <= dimension; rowIndex++)
        {
            for(int columnIndex = 1; columnIndex <= dimension; columnIndex++) {
                if (gridValueAt(rowIndex, columnIndex) == OPEN || gridValueAt(rowIndex, columnIndex) == FULL) {
                    result++;
                }
            }
        }

        return result;

    }

    // does the system percolate?
    public boolean percolates()
    {

        boolean result = false;

        for(int columnIndex = 1; columnIndex <= dimension; columnIndex++)
        {
            if(isFull(dimension, columnIndex))
            {
                result = true;
            }
        }

        return result;

    }

    // test client (optional)
    public static void main(String[] args)
    {
    }

    private void validateCoordinates(int row, int column) throws IllegalArgumentException
    {

        validateDimension(row);
        validateDimension(column);

        if(row > this.dimension || column > this.dimension)
        {
            throw new IllegalArgumentException("Wrong coordinate dimension");
        }

    }

}