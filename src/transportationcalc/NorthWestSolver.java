/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportationcalc;

/**
 *
 * @author blackmantram
 */
public class NorthWestSolver {
    
    public void solve(Grid grid)
    {
        grid.balance();
        for(int i=0; i<grid.matrix.length; i++)
        {
            for (int j=0; j<grid.matrix[i].length; j++)
            {
                int assigned = 0;
                while(grid.offer[i] > 0 && grid.demand[j] > 0)
                {
                    grid.demand[i]--;
                    grid.offer[j]--;
                    assigned++;
                }
                grid.matrix[i][j] = assigned;
            }
        }
    }
}
