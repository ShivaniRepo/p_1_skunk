package skunk.domain;

//import edu.princeton.cs.introcs.StdOut;

public class SkunkController
{
	//Constants
	private static final int CONSTANT_MAX_NUMBER_PLAYERS = 30;
	private static final int ERROR_INVALID_PLAYER_NUMBER = -1;
	
	//
	private int iNumOfPlayers;
	private String[] NameOfPlayers;
	
	//Class objects
	private SkunkUI ui;
	private Turn turn;
	
	//**********************************************************
	
	public SkunkController()
	{
		ui = new SkunkUI();
		turn = new Turn(ui);
		
		this.NameOfPlayers = new String[CONSTANT_MAX_NUMBER_PLAYERS];
	}
	
	//**********************************************************
	
	public boolean run()
	{
		//ask for number of players.
		askAndParse_NumberOfPlayers();
		
		//if the number of players entered in invalid, try again.
		int iStatus = getNumberOfPlayers(this.iNumOfPlayers);
		while( iStatus < 0 ) 
		{
			askAndParse_NumberOfPlayers();
			iStatus = getNumberOfPlayers( this.iNumOfPlayers );
		} 
		
		//ask for player's name, can add try and catch here.
		savePlayerNamesInArray();
		
		
		//For P1.2: Just one Player.
		//One complete interactive turn of skunk with one human player.
		iStatus = turn.playTurn();
		
		return true;
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
		//else
		//{
		//	ui.printLine( "iNumOfPlayers: " + iNumOfPlayers );
		//}
		
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
