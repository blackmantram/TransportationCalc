/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportationcalc;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author blackmantram
 */
public class NorthWestSolverTest {
    
    NorthWestSolver solver = new NorthWestSolver();
    Grid grid = new Grid(1,1);
    
    @Test
    public void testBalancesBeforeSolving()
    {
        Grid mockedGrid = mock(Grid.class);
        mockedGrid.matrix = new int[0][0];
        solver.solve(mockedGrid);
        verify(mockedGrid, times(1)).balance();
    }
    
    @Test
    public void testAssignsValueFromOfferToDemand()
    {
        grid.offer[0] = 1;
        grid.demand[0] = 1;
        solver.solve(grid);
        assertEquals(1, grid.matrix[0][0]);
        assertEquals(0, grid.offer[0]);
        assertEquals(0, grid.demand[0]);
    }
    
    @Test
    public void testAssignsTheMaxValueFromOfferToDemand()
    {
        grid.offer[0] = 1;
        grid.demand[0] = 2;
        solver.solve(grid);
        assertEquals(1, grid.matrix[0][0]);
        assertEquals(0, grid.offer[0]);
        assertEquals(1, grid.demand[0]);
    }
    
    @Test
    public void testAssignsValueFromOfferToDemandMultiDimensional()
    {
        Grid grid = new Grid(2, 2);
        grid.offer[0] = 1;
        grid.offer[1] = 1;
        grid.demand[0] = 1;
        grid.demand[1] = 1;
        solver.solve(grid);
        
        assertEquals(1, grid.matrix[0][0]);
        assertEquals(0, grid.matrix[0][1]);
        assertEquals(0, grid.matrix[1][0]);
        assertEquals(1, grid.matrix[1][1]);
        
        assertEquals(0, grid.offer[0]);
        assertEquals(0, grid.offer[1]);
        assertEquals(0, grid.demand[0]);
        assertEquals(0, grid.demand[1]);
    }
    
    @Test
    public void testAssignsValueFromOfferToDemandMultiDimensional2()
    {
        Grid grid = new Grid(2, 2);
        grid.offer[0] = 1;
        grid.offer[1] = 1;
        grid.demand[0] = 1;
        grid.demand[1] = 1;
        solver.solve(grid);
        
        assertEquals(1, grid.matrix[0][0]);
        assertEquals(0, grid.matrix[0][1]);
        assertEquals(0, grid.matrix[1][0]);
        assertEquals(1, grid.matrix[1][1]);
        
        assertEquals(0, grid.offer[0]);
        assertEquals(0, grid.offer[1]);
        assertEquals(0, grid.demand[0]);
        assertEquals(0, grid.demand[1]);
    }
}
