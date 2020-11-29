package skunk.domain;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class FromUser implements SkunkInput 
{

	public FromUser()
	{
		
	}
	
	//**********************************************************
	
	@Override
	public void welcomeString()
	{
		StdOut.println("***** Welcome to the Skunk game created by Seagators: FromUser  *****");
		StdOut.println("-----------------------------------------------------------");
	}
	
	//**********************************************************
	
	public String printLineRead(String szLine)
	{
		StdOut.println( szLine );
		String strResponse =  StdIn.readLine();
		return strResponse;
	}
	
	//**********************************************************
	
	@Override
	public String printLineReadResponse(String szLine) 
	{
		return printLineRead( szLine );
	}

	//**********************************************************
	
	@Override
	public String printLineReadNames( int index, String szLine)
	{
		return printLineRead( szLine );
	}

	//**********************************************************
	
	public String printLineRead_Yes_No(String szLine)
	{
		return printLineRead( szLine );
	}
}
