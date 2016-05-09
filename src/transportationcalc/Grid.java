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
public class Grid 
{    
    public int[][] matrix;
    public int[] offer;
    public int[] demand;
    
    public Grid(int offerNumber, int demandNumber)
    {
        matrix = new int[offerNumber][demandNumber];
        offer = new int[offerNumber];
        demand = new int[demandNumber];
    }
    
    public void balance() 
    {
        int difference = getOfferDemandDifference();
        if (difference < 0)
            offer = balanceArray(offer, difference);
        if (difference > 0)
            demand = balanceArray(demand, difference);
    }
    
    private int getOfferDemandDifference()
    {
        int offerSum = 0;
        for(int i=0; i<offer.length; i++)
            offerSum += offer[i];
        int demandSum = 0;
        for(int i=0; i<demand.length; i++)
            demandSum += demand[i];
        return offerSum - demandSum;
    }
    
    private int[] balanceArray(int[] unbalanced, int difference)
    {
        int[] balanced = new int[unbalanced.length + 1];
        System.arraycopy(offer, 0, balanced, 0, offer.length);
        balanced[balanced.length-1] = Math.abs(difference);
        return balanced;
    }
}
