package skunk.domain;
import edu.princeton.cs.introcs.StdOut;

//**********************************************************
// 	Version: 1.1
//**********************************************************

public class SkunkApp
{
	private static final int CONSTANT_TO_TEST_RETURN = 111;
	private static final int CONSTANT_RUN_SUCCESSFUL = 100;
	
	private static int iTestValue_ForApp = -1;
	
	public SkunkController skunkController;
	public static SkunkUI ui;
	
	
	//**********************************************************
	
	public static void main(String[] args)
	{
		ui = new SkunkUI();
		ui.welcomeString();

		SkunkController skunk = new SkunkController();
		iTestValue_ForApp = -1;
		
		try
		{
			skunk.run();
			iTestValue_ForApp = CONSTANT_RUN_SUCCESSFUL;
		}
		catch( Exception e )
		{
			StdOut.println("Exception in SkunkApp");

			StdOut.print( e.toString() );
			StdOut.println( e.getMessage() );
		}
	}
	
	//**********************************************************
		
	public int testSkunkAppClass()
	{
		return CONSTANT_TO_TEST_RETURN;
	}
	
	//**********************************************************
	
	public static int getiTestValue_ForApp() 
	{
		return iTestValue_ForApp;
	}

	//**********************************************************
	

}
