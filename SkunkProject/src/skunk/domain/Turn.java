package skunk.domain;


//import edu.princeton.cs.introcs.StdOut;

//**********************************************************
//Turn: Series or multiple rolls until skunk or user decline to rolls
//Single player.
//**********************************************************

public class Turn
{
	private static final int CONSTANT_PENALTY_SKUNK_DEUCE_2 = 2;
	private static final int CONSTANT_PENALTY_REGULAR_SKUNK_1 = 1;
	private static final int CONSTANT_PENALTY_DOUBLE_SKUNK_4 = 4;
	private static final int CONSTANT_PLAYER_DECLINED_ROLL = -44;
	private static final int CONSTANT_IS_SKUNK_DEUCE = -22;
	private static final int CONSTANT_IS_REGULAR_SKUNK = -11;
	private static final int CONSTANT_IS_DOUBLE_SKUNK = -33;
	
	
	
	
	private int playerScore;
	private int chipCount;
	private Roll roll;
	private int iCalledFrom;
	
	private SkunkUI uiT;
	private SkunkConstant constant;
	
	public Player p;
	
	//**********************************************************
	
	public Turn( int iCall )
	{
		roll = new Roll();
		uiT = new SkunkUI();
		this.iCalledFrom =  iCall;
	}
	
	
	//**********************************************************
	
	public int playTurn( Player activePlayer, int activePlayerIndex )
	{
		int iExitValue = 0;
		
		//Add name of active player
		uiT.printLine("\nStarting Turn for " + activePlayer.playerName );
		
		
		boolean bGameOver = false;
		
		//Sets up the counter for the ChipCount and playerScore
		chipCount = activePlayer.getPlayerChipCount();
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
					uiT.printLine( "*** its double Skunk." );
					iExitValue = CONSTANT_IS_DOUBLE_SKUNK;
					bGameOver = true;
					
					chipCount -= CONSTANT_PENALTY_DOUBLE_SKUNK_4;
					activePlayer.setPlayerChipCount(chipCount);
					activePlayer.setPlayerScore(0);
					
					break;
				}
				else if( roll.isRegularSkunk() )
				{
					uiT.printLine( "*** its a regular Skunk." );
					iExitValue = CONSTANT_IS_REGULAR_SKUNK;
					
					bGameOver = true;
					chipCount = chipCount - CONSTANT_PENALTY_REGULAR_SKUNK_1;
					activePlayer.setPlayerChipCount(chipCount);
					
					break;
				}
				else if( roll.isSkunkDeuce() )
				{
					uiT.printLine( "*** its a SkunkDeuce." );
					iExitValue = CONSTANT_IS_SKUNK_DEUCE;
					bGameOver = true;
					chipCount = chipCount - CONSTANT_PENALTY_SKUNK_DEUCE_2;
					activePlayer.setPlayerChipCount(chipCount);
					
					break;
				}
				else 
				{
					playerScore += iValue;
					activePlayer.setPlayerScore(playerScore);
				}
				
				//Set the scores for this turn, adjust chips for penalty.
				uiT.printLine("\nPlayer " + ( activePlayer.playerNum + 1) + "\'s turn score is: " + Integer.toString(playerScore));
				uiT.printLine("Player " + ( activePlayer.playerNum + 1) + "\'s current chipcount is: "+ activePlayer.getPlayerChipCount());
				
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
		
		String strExitReason = getReasonForExit( iExitValue );
		
		//End of the turn...
		//Set the scores for this turn, adjust chips for penalty. 
		uiT.printLine("Game ended for " + activePlayer.playerName + " because " + strExitReason );
		uiT.printLine("Player " + ( activePlayer.playerNum + 1) +  " overall chipcount is: " + activePlayer.getPlayerChipCount());
		uiT.printLine("Player " + ( activePlayer.playerNum + 1) +  " overall score is: "+ activePlayer.getPlayerScore());	
		
		return iExitValue;
	}
	
	

	//**********************************************************

	public String getReasonForExit(int iExitValue) 
	{
		String strTemp = "Unknown";
		
		switch( iExitValue)
		{
		case CONSTANT_IS_REGULAR_SKUNK:
			strTemp = "of Regular skunk.";
			break;
		case CONSTANT_IS_DOUBLE_SKUNK:
			strTemp = "of double skunk.";
			break;
		case CONSTANT_IS_SKUNK_DEUCE:
			strTemp = "of skunk and a deuce.";
			break;
		case CONSTANT_PLAYER_DECLINED_ROLL:
			strTemp = "player declined roll.";
			break;
		}
		return strTemp;
	}

	//**********************************************************

	public boolean getRollChoice()
	{
		boolean bUserResp = false;
		
		if( this.iCalledFrom == 1 )
		{
			bUserResp = true;
		}
		else if( this.iCalledFrom == 2 )
		{
			bUserResp = false;
		}
		else
		{
			String szUserResp = uiT.printLineReadResponse("\nDo you want to roll? y or n");
			szUserResp.trim();
			
			bUserResp = ( szUserResp.toLowerCase().charAt(0) == 'y' );
		}
		
		return bUserResp;
	}
	
	//**********************************************************
}

