package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

//**********************************************************
//**********************************************************

public class SkunkApp
{
	private static final int CONSTANT_TO_TEST_RETURN = 111;
	public SkunkController skunkController;
	
	//**********************************************************
	
	public SkunkApp()
	{
		skunkController = new SkunkController();
		//skunkController.run();
	}
	
	//**********************************************************
	
	public static void main(String[] args)
	{
		StdOut.println("***** Welcome to the Skunk game created by Seagators *****");
		StdOut.println("-----------------------------------------------------------");
		
		Dice dice = new Dice();
		StdOut.println("created Dice");
		
		dice.roll();
		
		StdOut.println("Dice roll");
		StdOut.println(dice.toString());
		
		SkunkController skunk = new SkunkController();
		
		try
		{
			skunk.run();
		}
		catch( Exception e )
		{
			StdOut.println("Exception in SkunkApp");
		}
	}
	
	//**********************************************************
	
	public boolean run()
	{
		StdOut.println("run");
		return skunkController.run();
	}

	//**********************************************************
	
	public int testSkunkAppClass()
	{
		return CONSTANT_TO_TEST_RETURN;
	}
	
	//**********************************************************

}
