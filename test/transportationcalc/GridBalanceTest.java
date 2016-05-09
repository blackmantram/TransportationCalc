/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportationcalc;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author blackmantram
 */
public class GridBalanceTest {

    @Test
    public void testBalancesOffer() {
        Grid grid = createGrid(2, 3);
        grid.balance();
        assertEquals(3, grid.offer.length);
    }

    @Test
    public void testBalancesDemand() {
        Grid grid = createGrid(3, 2);
        grid.balance();
        assertEquals(3, grid.demand.length);
    }
    
    @Test
    public void testBalancesSquaredUnbalancedGrid() {
        Grid grid = new Grid(2, 2);
        grid.offer[0] = 1;
        grid.offer[1] = 2;
        
        grid.demand[0] = 1;
        grid.demand[1] = 1;
        
        grid.balance();
        assertEquals(3, grid.demand.length);
    }

    private Grid createGrid(int rows, int cols) {
        Grid grid = new Grid(rows, cols);

        for (int i = 0; i < rows; i++) {
            grid.offer[i] = 1;
        }
        for (int i = 0; i < cols; i++) {
            grid.demand[i] = 1;
        }

        return grid;
    }
}
