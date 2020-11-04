package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

//Turn: Series or multiple rolls until skunk or user decline to rolls
public class Turn
{
	private Roll roll;
	
	public Turn()
	{
		StdOut.println("In Turn constructor: ");
		roll = new Roll();
	}
}
