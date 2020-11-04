package skunk.domain;

//import edu.princeton.cs.introcs.StdOut;

public class SkunkController
{

	private static final int ERROR_INVALID_PLAYER_NUMBER = -1;
	private SkunkUI ui;
	private int iNumOfPlayers;
	private String[] NameOfPlayers;
	
	//**********************************************************
	
	public SkunkController()
	{
		ui = new SkunkUI();
		this.NameOfPlayers = new String[30];
	}
	
	//**********************************************************
	
	public boolean run()
	{
		String strTemp;
		
		//ask for number of player.
		askAndParse_NumberOfPlayers();
		
		int iStatus = getNumberOfPlayers(this.iNumOfPlayers);
		while( iStatus < 0 ) 
		{
			askAndParse_NumberOfPlayers();
			iStatus = getNumberOfPlayers( this.iNumOfPlayers );
		} 
		
		//ask for player name
		savePlayerNamesInArray();
		
		
		//
		Dice dice = new Dice();
				
		dice.roll();
		
		ui.printLine("Dice roll");
		ui.printLine(dice.toString());
		
	
		return false;
	}

	//**********************************************************
	
	public void askAndParse_NumberOfPlayers() 
	{
		String strTemp;
		ui.printLine( "*****" );
		strTemp = ui.printLineReadResponse( "Enter number of players?" );
		this.iNumOfPlayers = Integer.parseInt( strTemp );
	}

	//**********************************************************
	// SkunkController will communicate with UI and get the number of players.
	// Set the parsed number of players in the Player class.
	//**********************************************************
	
	public int getNumberOfPlayers(int iNumOfPlayers)
	{
		if( iNumOfPlayers <= 0 )
		{
			ui.printLine( "invalid iNumOfPlayers: " + iNumOfPlayers + "\nEnter number of players greater than 0?\n" );
			return ERROR_INVALID_PLAYER_NUMBER;
		}
		else if( iNumOfPlayers == 1 )
		{
			ui.printLine( "iNumOfPlayers: " + iNumOfPlayers );
		}
		else
		{
			ui.printLine( "iNumOfPlayers: " + iNumOfPlayers );
		}
		
		return 0;
	}
	
	
	//**********************************************************
	// SkunkController will communicate with UI and get the names of players.
	// Set the names of the players in the Player class.
	//**********************************************************
		
	public void savePlayerNamesInArray() 
	{
		String strTemp;
		for ( int iii =0; iii < this.iNumOfPlayers; iii++ )
		{
			strTemp = ui.printLineReadResponse( "\nEnter Name of Player " + (iii+1) + ": " );
			this.NameOfPlayers[iii] = strTemp;
		}
	}
}
