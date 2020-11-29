package skunk.domain;



public interface SkunkInput 
{
	
	//public void welcomeString();
	public String printLineReadResponse(String szLine);
	public String printLineReadNames( int index, String szLine );
	public String printLineRead_Yes_No(String szLine);
	public boolean get_bYes0No1();
	public void set_bYes0No1( boolean bState );
	
}
