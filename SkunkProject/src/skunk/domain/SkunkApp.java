// Added in comment for developer branch
package skunk.domain;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{

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

}
