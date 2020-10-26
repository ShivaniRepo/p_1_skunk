package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{

	private static final int CONSTANT_TO_TEST_RETURN = 111;

	public static void main(String[] args)
	{
		StdOut.println("***** Welcome to the Skunk game created by Seagators *****");
		StdOut.println("-----------------------------------------------------------");
		
		
		Dice dice = new Dice();
		StdOut.println("created Dice");
		dice.roll();
		StdOut.println("Dice roll");
		
		StdOut.println(dice.toString());
	}

	public int testSkunkAppClass()
	{
		return CONSTANT_TO_TEST_RETURN;
	}

}
