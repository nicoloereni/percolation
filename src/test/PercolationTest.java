import main.java.Percolation;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PercolationTest {

    public static final int DEFAULT_TEST_DIMENSION = 3;
    private Percolation percolation;

    @Before
    public void setUp() throws Exception {
        percolation = new Percolation(DEFAULT_TEST_DIMENSION);
    }

    @Test
    public void gridInitToBlocked() throws Exception {

        for(int i = 1; i <= DEFAULT_TEST_DIMENSION; i++)
        {
            for(int j = 1; j <= DEFAULT_TEST_DIMENSION; j++)
            {
                assertFalse(percolation.isOpen(i,j));
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorThrowIAEIfDimensionEqualToZero() throws Exception {
        new Percolation(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorThrowIAEIfDimensionLessThenZero() throws Exception {
        new Percolation(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isOpenThrowIAEWhenRowIsBiggerThenDimension() throws Exception
    {
        percolation.isOpen(4,3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isOpenThrowIAEWhenColumnIsBiggerThenDimension() throws Exception
    {
        percolation.isOpen(3,4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isOpenThrowIAEWhenColumnIsLessThenZero() throws Exception
    {
        percolation.isOpen(3,-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isOpenThrowIAEWhenRowIsEqualToZero() throws Exception
    {
        percolation.isOpen(0,3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void openThrowIAEWhenColumnIsBiggerThenDimension() throws Exception
    {
        percolation.open(3,4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void openThrowIAEWhenRowIsBiggerThenDimension() throws Exception
    {
        percolation.open(4,3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isFullThrowIAEWhenRowIsBiggerThenDimension() throws Exception
    {
        percolation.isFull(4,3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isFullThrowIAEWhenColumnIsBiggerThenDimension() throws Exception
    {
        percolation.isFull(4,3);
    }

    @Test
    public void openSiteContainsOpenValue() throws Exception {
        assertFalse(percolation.isOpen(1,1));
        percolation.open(1,1);
        assertTrue(percolation.isOpen(1,1));
    }
}
