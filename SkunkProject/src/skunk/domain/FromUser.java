package skunk.domain;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class FromUser implements SkunkInput 
{

	//**********************************************************
	
	public String printLineRead(String szLine)
	{
		String strResponse = null;
		int iTry=0;
		boolean bDone = false;
		
		do
		{
			StdOut.println( szLine );
			strResponse =  StdIn.readLine();
			
			if( strResponse.trim().isEmpty() )
			{
				StdOut.println( "inValid entry, try again. Retry: " + (iTry+1) );
				iTry++;
				
				if( iTry >= 3)
					throw new IllegalArgumentException("Empty string enterd.");
			}
			else
			{
				bDone = true;
			}
		} while( !bDone && iTry<3 );
		
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
	
	//**********************************************************
	
	public boolean get_bYes0No1() 
	{
		return false;
	}

	//**********************************************************
	
	public void set_bYes0No1( boolean bState ) 
	{
		return;
	}
	
	//**********************************************************
}
