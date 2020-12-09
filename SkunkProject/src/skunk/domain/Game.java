package skunk.domain;


//import java.io.InputStreamReader;

//import java.util.ArrayList;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdOut;


public class Game 
{
	
	private boolean StartGame = false;
	private boolean EndGame = false;

	private int iNumOfPlayers;
	private String[] NameOfPlayers;
	public ArrayList<Player> players = new ArrayList<Player>();
	
	// Constants
	private static final int CONSTANT_MAX_NUMBER_PLAYERS = 30;
	private static final int ERROR_INVALID_PLAYER_NUMBER = -1;
	
	// Class objects
	private SkunkUI ui;
	private Turn turn;
	
	public Player activePlayer;
	//public int activePlayerIndex;
	
	//**********************************************************
	
	// Game Constructor 
	public Game() 
	{
		ui = new SkunkUI();
		this.NameOfPlayers = new String[CONSTANT_MAX_NUMBER_PLAYERS];
		this.players = new ArrayList<Player>();
		turn = new Turn( );
	}

	//**********************************************************
	
	public String getGameStatus()
	{
		if (this.StartGame == true) 
		{
			return "Skunk game has started.";
		}
		else 
		{
			return "Skunk game has NOT started.";
		}
		
	}
	
	//**********************************************************
	
	public void startGame()
	{
		this.StartGame = true;
	}
	
	public boolean endGame()
	{
		return this.EndGame = false;
	}

	//**********************************************************
	
	public boolean run() 
	{
		boolean bStatus = false;
		
		// Ask for number of players.
		askAndParse_NumberOfPlayers();
		
		// If the number of players entered in invalid, try again.
		int iStatus = validateNumberOfPlayers(this.iNumOfPlayers);
	
		
		while( iStatus < 0 ) 
		{
			askAndParse_NumberOfPlayers();
			iStatus = validateNumberOfPlayers( this.iNumOfPlayers );
		} 
		
		// Ask for player's name, can add try and catch here.
		savePlayerNamesInArray();
		
		//For P1.2: Just one Player.
		//One complete interactive turn of skunk with one human player.
		boolean bContinue = false;
		int iTurnCount = 0;
		
		do
		{
			for( int iPlayer=0; iPlayer<this.iNumOfPlayers; iPlayer++ )
			{
				//activePlayerIndex = iPlayer;		
				iStatus = turn.playTurn(players.get(iPlayer), iPlayer);
				ui.printLine( "Turn is OVER." );
			}
			
			ui.printLine( "********** Turn: " + (iTurnCount+1) +"**********" );
			for( int iPlayer=0; iPlayer<this.iNumOfPlayers; iPlayer++ )
			{
				turn.printOverAllScore(players.get(iPlayer));
				int iChips = players.get(iPlayer).getPlayerChipCount();
				if( iChips <= 0 )
				{
					ui.printLine( "Negative chips count. Game is OVER." );
					bContinue = true;
					break;
				}
					
			}
			ui.printLine( "*********************************\n" );
			
			//
			//Check chips count
			//

			//
			// Give option to continue the game.
			//
			String strTemp = ui.printLineRead_Yes_No("Do you want to play one more Game?" );
						
			if( strTemp.trim().equalsIgnoreCase("y") )
				bContinue = true;
			else
				ui.printLine( "invalid reponse. Exiting game." );
			
			
			iTurnCount++;
		} while( bContinue );
		
		//Print score 
		
		
		bStatus = (iStatus == 0) ? false: true; 
			
		return bStatus;
	}
	
	//**********************************************************
	
	public void askAndParse_NumberOfPlayers() 
	{
		String strTemp;

		try
		{
			strTemp = ui.printLineReadResponse( "Enter number of players?" );
			this.iNumOfPlayers = Integer.parseInt( strTemp );
		}
		catch( Exception e )
		{
			ui.printLine( "invalid iNumOfPlayers entered" );
		}
	}

	//**********************************************************
	// Game will communicate with controller and get the number of players.
	// Set the parsed number of players in the Player class.
	//**********************************************************

	public int validateNumberOfPlayers(int iNumOfPlayers)
	{
		if( iNumOfPlayers <= 0 )
		{
			ui.printLine( "invalid iNumOfPlayers: " + iNumOfPlayers + "\nEnter number of players greater than zero?\n" );
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
		for ( int iii=0; iii < this.iNumOfPlayers; iii++ )
		{
			try
			{
				strTemp = ui.printLineReadNames( iii, "\nEnter Name of Player " + (iii+1) + ": " );
				this.NameOfPlayers[iii] = strTemp;
				this.players.add(new Player(strTemp, iii ));
			}
			catch( IllegalArgumentException e)
			{
				//Empty string entered or user hit return key.
				ui.printLine( "invalid Name entered." );
			}
			//catch( Exception e )
			//{
			//	//Any unexpected exception
			//	ui.printLine( "unexpected exception." );
			//	ui.printLine( e.toString() );
			//}
		}
	}

	//**********************************************************
	// Return total players.
	
	public int getPlayers()
	{
		int total = players.size();
		return total;
	}

	//**********************************************************
	// Method to add Player to Game. 
	
	public void addPlayer(String string) 	
	{
		Player player = new Player(string);
		players.add(player);
	}
	
	//**********************************************************
	// Method to REMOVE all Players from Game. 
	
	public void removePlayers() 
	{
		players.clear();
	}
}