package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

//Turn: Series or multiple rolls until skunk or user decline to rolls
//Single player.

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
		uiT.printLine( "Turn Starting..." );
		
		boolean bWantToPlay = getRollChoice();
		//boolean bGameOver = false;
		
		while( bWantToPlay )
		{
			roll.rollDice();
			
			int iValue = roll.getLastRollValue();
			uiT.printLine( "iValue: " + iValue );
			
			//if skunk or deuce or double skunk, game ends
			//Check for double skunk before regular skunk
			if( roll.isDoubleSkunk() )
			{
				uiT.printLine( "isDoubleSkunk" );
				bWantToPlay = false;
				return -33;
			}
			
			if( roll.isRegularSkunk() )
			{
				uiT.printLine( "isRegularSkunk" );
				bWantToPlay = false;
				return -11;
			}
			
			if( roll.isSkunkDeuce() )
			{
				uiT.printLine( "isSkunkDeuce" );
				bWantToPlay = false;
				return -22;
			}
						
			
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
