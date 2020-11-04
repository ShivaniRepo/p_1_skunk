
package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

//Roll: Throw Dice ( pair of die ) once and save the sum of values.

public class Roll
{
	private Dice dice;
	private int iRollTotal;
	
	

	public Roll()
	{
		StdOut.println("In Roll constructor: ");
		dice = new Dice();
		
		dice.roll();
	}


	public int getLastRollValue() 
	{
		return dice.getLastRoll();		
	}
	
		
	public int getiRollTotal() 
	{
		return iRollTotal;
	}

	public void setiRollTotal(int iRollTotal) 
	{
		this.iRollTotal = iRollTotal;
	}
}
