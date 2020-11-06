package skunk.domain;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkUI
{
	
	//**********************************************************
	
	public void welcomeString()
	{
		StdOut.println("***** Welcome to the Skunk game created by Seagators from SkunkUI *****");
		StdOut.println("--------------------------------------------------------------------------");
	}
	
	//**********************************************************
	
	public void printLine( String szLine)
	{
		StdOut.println( szLine );
	}

	//**********************************************************
	
	public String printLineReadResponse(String szLine) 
	{
		StdOut.println( szLine );
		String strResponse =  StdIn.readLine();
		return strResponse;
	}
	
	//**********************************************************
}
