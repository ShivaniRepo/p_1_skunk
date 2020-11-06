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
		
		//Reset the score for the activeplayer. Todo
		
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
				bWantToPlay = false;
				iExitValue = -33;
				break;
			}
			else if( roll.isRegularSkunk() )
			{
				uiT.printLine( "isRegularSkunk" );
				bWantToPlay = false;
				iExitValue = -11;
				break;
			}
			else if( roll.isSkunkDeuce() )
			{
				uiT.printLine( "isSkunkDeuce" );
				bWantToPlay = false;
				iExitValue = -22;
				break;
			}
						
			//Set the scores for this turn
			//Adjust chips for penalty.
			
			//Or if player chooses to decline the roll
			bWantToPlay = getRollChoice();
		};
		

		
		uiT.printLine( "Player declined the roll." );
		return 0;
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
