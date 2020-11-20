package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

//**********************************************************
//Turn: Series or multiple rolls until skunk or user decline to rolls
//Single player.
//**********************************************************

public class Turn
{
	private static final int CONSTANT_PLAYER_DECLINED_ROLL = -44;
	private static final int CONSTANT_IS_SKUNK_DEUCE = -22;
	private static final int CONSTANT_IS_REGULAR_SKUNK = -11;
	private static final int CONSTANT_IS_DOUBLE_SKUNK = -33;
	
	
	
	
	private String[] NameOfPlayers;
	
	private String playerName;
	private int playerScore;
	private int chipCount;
	private Roll roll;
	
	private SkunkUI uiT;
	public Player p;
	
	//**********************************************************
	
	public Turn()
	{
		//StdOut.println("In Turn constructor: ");
		roll = new Roll();
		uiT = new SkunkUI();
	}
	
	

	//**********************************************************
	
	public int playTurn(Player activePlayer, int activePlayerIndex)
	{
		int iExitValue = 0;
		
		//Add name of active player
		
		uiT.printLine("\nPlayer 1's name is: " + activePlayer.getPlayerName());
		
		uiT.printLine("\nStarting Turn for Player 1..." );
		
		
		boolean bGameOver = false;
		
		//Sets up the counter for the ChipCount and playerScore
		chipCount =  activePlayer.getPlayerChipCount();
		playerScore = activePlayer.getPlayerScore();
		
		while( !bGameOver )
		{
			//Get player's chooses to roll or decline the roll
			boolean bWantToPlay = getRollChoice();
			
			
					
			while( bWantToPlay )
			{
				roll.rollDice();
				
				int iValue = roll.getLastRollValue();
				
				//if skunk or deuce or double skunk, game ends
				//Check for double skunk before regular skunk
				if( roll.isDoubleSkunk() )
				{
					uiT.printLine( "isDoubleSkunk" );
					bGameOver = true;
					chipCount = chipCount - 4;
					activePlayer.setPlayerChipCount(chipCount);
					activePlayer.setPlayerScore(0);
					iExitValue = CONSTANT_IS_DOUBLE_SKUNK;
					break;
				}
				else if( roll.isRegularSkunk() )
				{
					uiT.printLine( "isRegularSkunk" );
					bGameOver = true;
					chipCount = chipCount - 1;
					activePlayer.setPlayerChipCount(chipCount);
					iExitValue = CONSTANT_IS_REGULAR_SKUNK;
					break;
				}
				else if( roll.isSkunkDeuce() )
				{
					uiT.printLine( "isSkunkDeuce" );
					bGameOver = true;
					chipCount = chipCount - 2;
					activePlayer.setPlayerChipCount(chipCount);
					iExitValue = CONSTANT_IS_SKUNK_DEUCE;
					break;
				}
				else 
				{
					playerScore += iValue;
					activePlayer.setPlayerScore(playerScore);
					//uiT.printLine ("Player's turn score is: " +Integer.toString(playerScore));
				}
				
				//Set the scores for this turn
				//Adjust chips for penalty.
				uiT.printLine("\nPlayer 1's turn score is: " + Integer.toString(playerScore));
				uiT.printLine("Player 1's current chipcount is: "+ activePlayer.getPlayerChipCount());
				
				bWantToPlay = getRollChoice();
				
				
			}
			
			if( !bWantToPlay )
			{
				uiT.printLine( "Player declined the roll." );
				bGameOver = true;
				iExitValue = CONSTANT_PLAYER_DECLINED_ROLL;
				break;
			}
		}
		
		//End of the turn...
		//Set the scores for this turn
		//Adjust chips for penalty. 
		uiT.printLine("\nThe Turn Summary is as follows: ");
		uiT.printLine("Player 1's name is: " + activePlayer.getPlayerName());
		uiT.printLine("Player 1's overall chipcount is: "+ activePlayer.getPlayerChipCount());
		uiT.printLine("Player 1's overall score is "+ activePlayer.getPlayerScore());	
		
		return iExitValue;
	}
	
	//**********************************************************
	
	public boolean getRollChoice()
	{
		String szUserResp = uiT.printLineReadResponse("\nDo you want to roll? y or n");
		szUserResp.trim();
		
		boolean bUserResp = ( szUserResp.toLowerCase().charAt(0) == 'y' );
		//uiT.printLine("UserResp: " + szUserResp + " : " + bUserResp );	
		
		return bUserResp;
	}
	
	//**********************************************************
}

