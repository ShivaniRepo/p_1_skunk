package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

public class SkunkUI
{
	
	public static SkunkInput ui2;
	
	//**********************************************************
	
	public void welcomeString()
	{
		StdOut.println("***** Welcome to the Skunk game created by Seagators  *****");
		StdOut.println("-----------------------------------------------------------");
	}
	
	//**********************************************************
	
	public void printLine( String szLine)
	{
		StdOut.println( szLine );
	}

	//**********************************************************
	
	public String printLineReadResponse(String szLine) 
	{
		String strResponse = ui2.printLineReadResponse(szLine);
		return strResponse;
	}
	
	//**********************************************************
	
	public String printLineReadNames(int iIndex, String szLine) 
	{
		String strResponse = ui2.printLineReadNames( iIndex, szLine );
		return strResponse;
	}
	
	//**********************************************************
	
	public String printLineRead_Yes_No(String szLine) 
	{
		String strResponse = ui2.printLineRead_Yes_No( szLine );
		return strResponse;
	}
		
	//**********************************************************
		
	public boolean isJUnitTest()
	{
		for (StackTraceElement element : Thread.currentThread().getStackTrace())
		{
			if (element.getClassName().startsWith("org.junit."))
			{
				return true;
			}
		}
		return false;
	}
	
	//**********************************************************

	public static SkunkInput getUi2() 
	{
		return ui2;
	}

	public static void setUi2(SkunkInput ui) 
	{
		ui2 = ui;
	}

	//**********************************************************
	
	public SkunkUI()
	{
		boolean  bisJUnitTest = isJUnitTest();
		StdOut.println("isJUnitTest: " + bisJUnitTest);
		
		if( !bisJUnitTest )
			ui2 = new FromUser();
		else
			ui2 = new FromFile();
		
		
		setUi2( ui2 );
	}
}
