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
	private static final String RULES = 
			"DIRECTIONS FOR PLAYING:\r\n" + 
	        "\r\n" + 
			"The object of the game is to accumulate a score of 100 points or more. A score is made by rolling the dice\r\n" +
			"and combining the points on the two dice." + "For example: A 4 and 5 would be 9 points - if the player decides\r\n" +
			"to take another roll of the dice and turns up a 3 and 5 (8 points), he would then have an accumulated total of 17\r\n" +
			"points for the two rolls. The player has the privilege of continuing to shake to increase his score or of passing the\r\n" +
			"dice to wait for the next series, thus preventing the possibility of rolling a Skunk and losing his score.\r\n" + 
			"\r\n" + 
			"PENALTIES:\r\n" + 
			"\r\n" + 
			"A skunk in any series voids the score for that series only and draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.\r\n" + 
			"A skunk and a deuce voids the score for that series only and draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice.\r\n" +  
			"TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice. Player must again\r\n" +
			"start to score from scratch.\r\n" + 
			"\r\n" + 
			"ADDITIONAL RULES:\r\n" + 
			"\r\n" + 
			"Any number can play. [Assume at least two players!] The suggested number of chips to start is 50.There are sufficient chips in the box to allow\r\n" +
			"8 players to start with 50 chips by placing a par value of \"one\" on white chips, 5 for 1 on red chips and 10 for 1 on the blue chips.\r\n" + 
			"\r\n" + 
			"The first player to accumulate a total of 100 or more points can continue to score as many points over 100 as he believes is needed to win.\r\n" +
			"When he decides to stop, his total score is the \"goal.\" Each succeeding player receives one more chance to better the goal and end the game.\r\n" + 
			"The winner of each game collects all chips in \"kitty\" and in addition five chips from each losing player or 10 chips from any player without a score.\r\n";
	
	// Class objects
	private SkunkUI ui;
	private Turn turn;
	
	public Player activePlayer;
	public int activePlayerIndex;
	
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
		
		// Ask for Game Rules
		
		askGameRules();
		
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
		
		activePlayerIndex = 0;		
		iStatus = turn.playTurn(players.get(activePlayerIndex), activePlayerIndex);
		
		ui.printLine( "Turn is OVER." );
		
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
			//Todo: if string entered is other than integer.
		}
	}

	//**********************************************************
	// Game will communicate with controller and get the number of players.
	// Set the parsed number of players in the Player class.
	//**********************************************************

	public int getNumberOfPlayers(int iNumOfPlayers)
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
				this.players.add(new Player(strTemp));
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
	
	public void askGameRules()
	{
		String szUserResp = ui.printLineRead_Yes_No("\nDo you want to see the Skunk Game rules? y or n");
		szUserResp.trim();
		
		char chResp = szUserResp.toLowerCase().charAt(0);
		
		if( chResp == 'y' ) 
		{
		ui.printLine("--------------------------------------------------------------------------------------------------");
		ui.printLine(RULES);
		ui.printLine("--------------------------------------------------------------------------------------------------");
		}
	}
	
}