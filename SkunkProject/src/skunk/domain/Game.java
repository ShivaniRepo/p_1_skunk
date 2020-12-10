package skunk.domain;


import java.util.ArrayList;

import edu.princeton.cs.introcs.StdOut;


public class Game 
{
	
	// Constants
	private static final int CONSTANT_MAX_NUMBER_PLAYERS = 30;
	private static final int ERROR_INVALID_PLAYER_NUMBER = -1;
	private static final int PENALTY_OF_LOOSING = 5;
	private static final int PENALTY_ZERO_SCORE = 10;
	private static int TARGET_SCORE = 100;
	
	
	private boolean StartGame = false;
	private boolean EndGame = false;
	
	
	private int iNumOfPlayers;
	private int iWinnerIndex = -1;
	private String[] NameOfPlayers;
	public ArrayList<Player> players = new ArrayList<Player>();
	

	
	// Class objects
	private SkunkUI ui;
	private Turn turn;
	
	public Player activePlayer;
	public Kitty kittyObj;
	
	
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

	/*Each Game ends with one or more players scoring >=100 (needs to be done); 
	 need clarification on how the game exits 

	Followed by a final set of Turns giving all non-100 players a final chance to 
	increase their score (needs to be done) 
	
	The first player to accumulate a total of 100 or more points can continue to 
	score as many points over 100 as he believes is needed to win. When he decides to stop, 
	his total score is the “goal.” Each succeeding player receives one more chance to 
	better the goal and end the game.  
	
	The winner of each game collects all chips in "kitty" and in addition five chips 
	from each losing player or 10 chips from any player without a score. 
	12/8/2020: Keep this requirement within Player class.  */
	
	
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
					ui.printLine( "Player: " + players.get(iPlayer).getPlayerName() + " zero or negative chips count. Taking this player out of the game." );
					//this.players.remove(iPlayer);
					
					bContinue = true;
					break;
				}
					
			}
			ui.printLine( "*********************************\n" );
			
			//
			//Check score and chips count
			//
			this.iWinnerIndex = find_MaxScoreIndex();
			
			if( this.iWinnerIndex > -1 )
			{
				update_ChipsFromKitty();
			
				update_ChipsFrom_OtherPlayers();
			}
			
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
	//**********************************************************
	
	public int find_MaxScoreIndex()
	{
		int iCurrentScore = 0;
		int iMaxScore = 0;
		int iIndex = -1;
		
		for( int iPlayer=0; iPlayer<this.iNumOfPlayers; iPlayer++ )
		{
			iCurrentScore = players.get(iPlayer).getPlayerScore();
			
			if( iCurrentScore >= TARGET_SCORE )
			{
				if( iCurrentScore > iMaxScore )
				{
					iMaxScore = iCurrentScore;
					iIndex = iPlayer;
				}
			}
		}
		
		return iIndex;
	}
	
	//**********************************************************
	//**********************************************************
	
	public void update_ChipsFromKitty()
	{
		int iCurrentScore = 0;
		int iWinInd = this.iWinnerIndex;

		//Do it only one time. Get flag to check if it is first time. If false it is first time
		if( !players.get( iWinInd ).get_bUpdatedChips_FromKitty_Flag() )
		{
			iCurrentScore = players.get( iWinInd ).getPlayerScore();
			
			ui.printLine( players.get( iWinInd ).getPlayerName() + "'s is the WINNER with score: " + iCurrentScore );
			
			int iKittyChips = Kitty.get_iChips();
			players.get( iWinInd ).setPlayerChipCount( players.get( iWinInd ).getPlayerChipCount() + iKittyChips );
			Kitty.set_iChips( 0 );
			
			
			//Set flag to true.
			players.get( iWinInd ).set_bUpdatedChips_FromKitty_Flag(true);
			
			ui.printLine( players.get( iWinInd ).playerName + "'s gets chips from kitty: " +  iKittyChips );
		}		
	}
	
	//**********************************************************
	//**********************************************************
	
	public void update_ChipsFrom_OtherPlayers()
	{
		int iWinInd = this.iWinnerIndex;
		
		//Do it only one time. Get flag to check if it is first time. If false it is first time
		if( !players.get(iWinInd).get_bChipsFromPlayers_updated() )
		{
			//ui.printLine(players.get( iWinInd).getPlayerName() + "'s is the WINNER with score: " + players.get( iWinInd ).getPlayerScore() + " gets penalty chips from other players. " );
			ui.printLine(players.get( iWinInd).getPlayerName() + "'s gets penalty chips from other players. " );
					
			for( int iPlayer=0; iPlayer < this.iNumOfPlayers; iPlayer++ )
			{
				if( iPlayer != iWinInd )
				{
					if( players.get(iPlayer).getPlayerScore() <= 0 )
					{
						players.get(iPlayer).update_PlayerChipCount( -PENALTY_ZERO_SCORE );
						players.get(this.iWinnerIndex).update_PlayerChipCount( PENALTY_ZERO_SCORE );
					}
					else
					{
						players.get(iPlayer).update_PlayerChipCount( -PENALTY_OF_LOOSING );
						players.get(this.iWinnerIndex).update_PlayerChipCount( PENALTY_OF_LOOSING );
					}
					
					//Update the flag
					players.get(iWinInd).set_bChipsFromPlayers_updated(true);
				}
			}
			
			ui.printLine(players.get(iWinInd).playerName + "'s Total Chip count: " + players.get(iWinInd).getPlayerChipCount() );
			
		}
		
		ui.printLine( "\n*********************************" );
		ui.printLine( "********** WINNER:" + players.get(iWinInd).getPlayerName() + "**********" );
		for( int iPlayer=0; iPlayer<this.iNumOfPlayers; iPlayer++ )
		{
			turn.printOverAllScore(players.get(iPlayer));
		}
		ui.printLine( "*********************************" );
		ui.printLine( "*********************************\n" );
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
	
	// Method to remove one Player from Game. 
	
	public void removeOnePlayer(int iIndex) 	
	{
		players.remove(iIndex);
	}
	
	//**********************************************************
		
	// Method to REMOVE all Players from Game. 
	
	public void removePlayers() 
	{
		players.clear();
	}
	//**********************************************************
}
