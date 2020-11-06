package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

//**********************************************************
//Turn: Series or multiple rolls until skunk or user decline to rolls
//Single player.
//**********************************************************

public class Turn
{
	private Roll roll;
	private SkunkUI uiT;
	
	//**********************************************************
	
	public Turn( SkunkUI ui )
	{
		//StdOut.println("In Turn constructor: ");
		roll = new Roll();
	
		uiT = ui;
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
					iExitValue = -33;
					break;
				}
				else if( roll.isRegularSkunk() )
				{
					uiT.printLine( "isRegularSkunk" );
					bGameOver = true;
					iExitValue = -11;
					break;
				}
				else if( roll.isSkunkDeuce() )
				{
					uiT.printLine( "isSkunkDeuce" );
					bGameOver = true;
					iExitValue = -22;
					break;
				}
				
				bWantToPlay = getRollChoice();
				
				//Set the scores for this turn
				//Adjust chips for penalty.
			}
			
			if( !bWantToPlay )
			{
				uiT.printLine( "Player declined the roll." );
				bGameOver = true;
				iExitValue = -44;
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
