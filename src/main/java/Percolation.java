package main.java;

public class Percolation
{
    public static final int BLOCKED = 0;
    private static final int OPEN = 1;
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
        grid[rowIndex -1][columnIndex -1] = value;
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
        assignGridValueAt(row, col, OPEN);
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        validateCoordinates(row, col);
        return gridValueAt(row, col) == OPEN;
    }

    private Integer gridValueAt(int row, int column) {
        return grid[row -1][column -1];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col)
    {
        validateCoordinates(row, col);
        return false;
    }

    // number of open sites
    public int numberOfOpenSites()
    {
        return 0;
    }

    // does the system percolate?
    public boolean percolates()
    {
        return false;
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