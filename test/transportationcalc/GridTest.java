/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportationcalc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author blackmantram
 */
public class GridTest 
{
    int offerNumber = 2;
    int demandNumber = 3;
    Grid grid = new Grid(offerNumber, demandNumber);
        
    @Test
    public void testGridCreatesMatrix() 
    {
        assertEquals(offerNumber, grid.matrix.length);
        assertEquals(demandNumber, grid.matrix[offerNumber-1].length);
    }
    
    @Test
    public void testHasOffer() 
    {
        assertEquals(offerNumber, grid.offer.length);
    }
    
    @Test
    public void testHasDemand() 
    {
        assertEquals(demandNumber, grid.demand.length);
    }
}