
package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

//Roll: Throw Dice ( pair of die ) once and save the sum of values.

public class Roll
{
	private Dice dice;
	
	public Roll()
	{
		StdOut.println("In Roll constructor: ");
		dice = new Dice();
		
		dice.roll();
		
	}

	public int getRollTotal() 
	{
		return dice.getLastRoll();
		
	}
	
}
