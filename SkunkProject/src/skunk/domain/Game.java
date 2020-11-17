package skunk.domain;


//import java.util.ArrayList;

import java.util.ArrayList;


public class Game {
	
	private boolean StartGame = false;
	private boolean EndGame = false;

	private int iNumOfPlayers;
	private String[] NameOfPlayers;
//	private ArrayList<Player> totalPlayers = new ArrayList();

	
	// Constants
	private static final int CONSTANT_MAX_NUMBER_PLAYERS = 30;
	private static final int ERROR_INVALID_PLAYER_NUMBER = -1;
	
	// Class objects
	private SkunkUI ui;
	private Turn turn;
	
	// Game Constructor 
	public Game() 
	{
		ui = new SkunkUI();
		turn = new Turn(ui);
		this.NameOfPlayers = new String[CONSTANT_MAX_NUMBER_PLAYERS];
	}

	private ArrayList<Player> totalPlayers = new ArrayList();
	
	public String getGameStatus()
	{
		if (StartGame == true) 
		{
			return "Skunk game has started.";
		}
		else 
		{
			return "Skunk game has NOT started.";
		}
		
	}
	
	public void startGame()
	{
		this.StartGame = true;
	}
	
	public boolean endGame()
	{
		return this.EndGame = false;
	}

	public boolean run() 
	{
		// Ask for number of players.
		askAndParse_NumberOfPlayers();
		
		// If the number of players entered in invalid, try again.
		int iStatus = getNumberOfPlayers(this.iNumOfPlayers);
		while( iStatus < 0 ) 
		{
			askAndParse_NumberOfPlayers();
			iStatus = getNumberOfPlayers( this.iNumOfPlayers );
		} 
		
		// Ask for player's name, can add try and catch here.
		savePlayerNamesInArray();
		
		//For P1.2: Just one Player.
		//One complete interactive turn of skunk with one human player.
		
		iStatus = turn.playTurn();
		ui.printLine( "Turn is OVER." );
		
		return true;
	}
	
	public void askAndParse_NumberOfPlayers() 
	{
		String strTemp;
		ui.printLine( "*****" );
		try
		{
			strTemp = ui.printLineReadResponse( "Enter number of players?" );
			this.iNumOfPlayers = Integer.parseInt( strTemp );
		}
		catch( Exception e )
		{
			//Todo: if string entered is other than integer.
		}
	}
	// Return total players.
	public int getTotalPlayers()
	{
		int total = totalPlayers.size();
		return total;
		
	}

	// Method to add Player to Game. 
	public void addPlayer(String string) 
	
	{
		Player player = new Player(string);
		totalPlayers.add(player);
		
	}

	//**********************************************************
	// Game will communicate with controller and get the number of players.
	// Set the parsed number of players in the Player class.
	//**********************************************************
	

	public int getNumberOfPlayers(int iNumOfPlayers)
	{
		if( iNumOfPlayers <= 0 )
		{
			ui.printLine( "invalid iNumOfPlayers: " + iNumOfPlayers + "\nEnter number of players greater than 0?\n" );
			return ERROR_INVALID_PLAYER_NUMBER;
		}

		return 0;
	}
	
	//**********************************************************
	// Game will communicate with controller and get the names of players.
	// Set the names of the players in the Player class.
	//**********************************************************
		
	public void savePlayerNamesInArray() 
	{
		String strTemp;
		for ( int iii =0; iii < this.iNumOfPlayers; iii++ )
		{
			try
			{
				strTemp = ui.printLineReadResponse( "\nEnter Name of Player " + (iii+1) + ": " );
				this.NameOfPlayers[iii] = strTemp;
			}
			catch( Exception e )
			{
				//ToDo: empty string entered or just return key hit.
			}
		}
	}

	// Method to REMOVE all Players from Game. 

	public void removePlayers() 
	{
		totalPlayers.clear();
	}

//	
//	
//	// Return total players.
//	public int getTotalPlayers()
//	{
//		int total = totalPlayers.size();
//		return total;
//		
//	}
//
//	// Method to add Player to Game. 
//	public void addPlayer(String string) 
//	
//	{
//		Player player = new Player(string);
//		totalPlayers.add(player);
//		
//	}
//	
//	// Method to REMOVE all Players from Game. 
//
//	public void removePlayers() 
//	{
//		totalPlayers.clear();
//	}
//
	
}
