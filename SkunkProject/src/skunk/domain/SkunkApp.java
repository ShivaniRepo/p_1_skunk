package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

//**********************************************************
//**********************************************************

public class SkunkApp
{
	private static final int CONSTANT_TO_TEST_RETURN = 111;
	
	public SkunkController skunkController;
	public static SkunkUI ui;
	
	//**********************************************************
	
	public SkunkApp()
	{
		ui = new SkunkUI();
	}
	
	//**********************************************************
	
	public static void main(String[] args)
	{
		ui = new SkunkUI();
		ui.welcomeString();

		SkunkController skunk = new SkunkController();
		
		try
		{
			skunk.run();
		}
		catch( Exception e )
		{
			StdOut.println("Exception in SkunkApp");
			//e.printStackTrace();
			
			StdOut.print( e.toString() );
			StdOut.println( e.getMessage() );
		}
	}
	
	//**********************************************************
	
	public boolean run()
	{
		StdOut.println("run");
		return skunkController.run();
	}

	//**********************************************************
	
	public int testSkunkAppClass()
	{
		return CONSTANT_TO_TEST_RETURN;
	}
	
	//**********************************************************

}
