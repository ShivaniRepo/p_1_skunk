package skunk.domain;

import skunk.domain.SkunkConstant.Constant;


//**********************************************************
//Turn: Series or multiple rolls until skunk or user decline to rolls
//Single player.
//**********************************************************

public class Turn
{
	private int playerScore;
	private int chipCount;
	private Roll roll;
	private int iCalledFrom;
	
	private SkunkUI uiT;
	public SkunkConstant sk;
	public Player p;
	
	//**********************************************************
	
	public Turn()
	{
		roll = new Roll();
		uiT = new SkunkUI();
	}
	
	//**********************************************************
	
	public Turn( int iCallFrom, int iTestDieValue )
	{
		uiT = new SkunkUI();
		roll = new Roll( uiT, iCallFrom, iTestDieValue );
		this.iCalledFrom =  iCallFrom;
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
					iExitValue = Constant.CONSTANT_IS_DOUBLE_SKUNK;
					bGameOver = true;
					
					chipCount -= Constant.CONSTANT_PENALTY_DOUBLE_SKUNK_4;
					activePlayer.setPlayerChipCount(chipCount);
					
					activePlayer.setPlayerScore(0);
					
					break;
				}
				else if( roll.isSkunkDeuce() )
				{
					iExitValue = Constant.CONSTANT_IS_SKUNK_DEUCE;
					bGameOver = true;
					
					chipCount -= Constant.CONSTANT_PENALTY_SKUNK_DEUCE_2;
					activePlayer.setPlayerChipCount(chipCount);
					
					break;
				}
				else if( roll.isRegularSkunk() )
				{
					iExitValue = Constant.CONSTANT_IS_REGULAR_SKUNK;
					bGameOver = true;
					
					chipCount -= Constant.CONSTANT_PENALTY_REGULAR_SKUNK_1;
					activePlayer.setPlayerChipCount(chipCount);
					
					break;
				}
				else 
				{
					playerScore += iValue;
					activePlayer.setPlayerScore(playerScore);
				}
				
				//Set the scores for this turn, adjust chips for penalty.
				printScore( activePlayer );
				bWantToPlay = getRollChoice();
			}
			
			if( !bWantToPlay )
			{
				bGameOver = true;
				iExitValue = Constant.CONSTANT_PLAYER_DECLINED_ROLL;
				break;
			}
		}
		
		String strExitReason = getReasonForExit( iExitValue );
		
		//End of the turn...
		//Set the scores for this turn, adjust chips for penalty.
		uiT.printLine("\nGame ended for " + activePlayer.playerName + " because ***" + strExitReason );
		printOverAllScore( activePlayer );
		
		return iExitValue;
	}
	
	

	//**********************************************************

	private void printScore(Player aPlayer) 
	{
		uiT.printLine("\nPlayer " + ( aPlayer.playerNum + 1) +": "+ aPlayer.playerName + "\'s turn score is: " + Integer.toString(playerScore));
		uiT.printLine("Player " + ( aPlayer.playerNum + 1)  +": "+ aPlayer.playerName +  "\'s current chipcount is: "+ aPlayer.getPlayerChipCount());
	}

	//**********************************************************

	private void printOverAllScore( Player aPlayer ) 
	{
		uiT.printLine("Player " + ( aPlayer.playerNum + 1) + ": "+ aPlayer.playerName + " overall score is: "+ aPlayer.getPlayerScore());
		uiT.printLine("Player " + ( aPlayer.playerNum + 1) + ": "+ aPlayer.playerName + " overall chipcount is: " + aPlayer.getPlayerChipCount());
	}

	//**********************************************************
	
	public String getReasonForExit(int iExitValue) 
	{
		String strTemp = "Unknown";
		
		switch( iExitValue)
		{
		case Constant.CONSTANT_IS_REGULAR_SKUNK:
			strTemp = "of Regular skunk.";
			break;
		case Constant.CONSTANT_IS_DOUBLE_SKUNK:
			strTemp = "of double skunk.";
			break;
		case Constant.CONSTANT_IS_SKUNK_DEUCE:
			strTemp = "of skunk and a deuce.";
			break;
		case Constant.CONSTANT_PLAYER_DECLINED_ROLL:
			strTemp = "player declined roll.";
			break;
		}
		return strTemp;
	}

	//**********************************************************

	public boolean getRollChoice()
	{
		boolean bUserResp = false;
		
		if( this.iCalledFrom == Constant.CONSTANT_PLAYER_WANTS_TO_PLAY )
		{
			bUserResp = true;
		}
		else if( this.iCalledFrom == Constant.CONSTANT_PLAYER_DECLINED_TO_PLAY )
		{
			bUserResp = false;
		}
		else
		{
			String szUserResp = uiT.printLineReadResponse("\nDo you want to roll? y or n");
			szUserResp.trim();
			
			char chResp = szUserResp.toLowerCase().charAt(0);
			
			if( chResp == 'y' )
				bUserResp = true;
			else if( chResp == 'n' )
				bUserResp = false;
			else
			{
				uiT.printLine("invalid response.");
				bUserResp = false;
			}
		}
		
		return bUserResp;
	}
	
	//**********************************************************
}