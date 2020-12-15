package skunk.domain;
import edu.princeton.cs.introcs.StdOut;

//**********************************************************
//	Version: 1.5 : If any player is left with zero or negative chips he won't roll the dice but his/her score stays. Other
//				   players can continue to play. if only one player is left the game ends. 
//	Version: 1.4 : Added kitty class, game exit condition, chips update, invalid response give 3 retries
// 	Version: 1.3 : Multiple players game is working.
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
