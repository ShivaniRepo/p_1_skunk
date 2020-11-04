
package skunk.domain;

//import edu.princeton.cs.introcs.StdOut;

//Roll: Throw Dice ( pair of die ) once and save the sum of values.

public class Roll
{
	private Dice dice;
	private int iRollTotal;
	private SkunkUI ui1;
	
	//**********************************************************
	
	public Roll()
	{
		ui1 = new SkunkUI();
		ui1.printLine( "In Roll constructor: ");
		dice = new Dice();
		
		dice.roll();
	}

	//**********************************************************
	
	public int getLastRollValue() 
	{
		return dice.getLastRoll();		
	}
	
	//**********************************************************
	
	public int get_iRollTotal() 
	{
		return iRollTotal;
	}

	public void set_iRollTotal(int iRollTotal) 
	{
		this.iRollTotal = iRollTotal;
	}
	
	//**********************************************************
}
