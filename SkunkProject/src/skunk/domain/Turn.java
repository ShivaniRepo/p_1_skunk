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
	private Roll roll = new Roll();
	private SkunkUI uiT;
	
	//**********************************************************
	
	public Turn( SkunkUI ui )
	{
		//StdOut.println("In Turn constructor: ");
		//roll = new Roll();
		uiT = ui;
	}
	

	public Turn() 
	{
	
	}

	//**********************************************************
	
	public int playTurn()
	{
		int iExitValue = 0;
		
		//Add name of active player Todo
		uiT.printLine( "Starting Turn for player..." );
		
		//Reset the score for the activeplayer. Todo:
		
		//
		boolean bGameOver = false;
		
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
					iExitValue = CONSTANT_IS_DOUBLE_SKUNK;
					break;
				}
				else if( roll.isRegularSkunk() )
				{
					uiT.printLine( "isRegularSkunk" );
					bGameOver = true;
					iExitValue = CONSTANT_IS_REGULAR_SKUNK;
					break;
				}
				else if( roll.isSkunkDeuce() )
				{
					uiT.printLine( "isSkunkDeuce" );
					bGameOver = true;
					iExitValue = CONSTANT_IS_SKUNK_DEUCE;
					break;
				}
				
				bWantToPlay = getRollChoice();
				
				//Todo:
				//Set the scores for this turn
				//Adjust chips for penalty. may be not here
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
		//Todo:
		//Set the scores for this turn
		//Adjust chips for penalty. 
				
		return iExitValue;
	}
	
	//**********************************************************
	
	public boolean getRollChoice()
	{
		String szUserResp = uiT.printLineReadResponse("Do you want to roll? y or n");
		szUserResp.trim();
		
		boolean bUserResp = ( szUserResp.toLowerCase().charAt(0) == 'y' );
		//uiT.printLine("UserResp: " + szUserResp + " : " + bUserResp );	
		
		return bUserResp;
	}
	
	//**********************************************************
}
