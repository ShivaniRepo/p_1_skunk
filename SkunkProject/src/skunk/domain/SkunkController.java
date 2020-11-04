package skunk.domain;

//import edu.princeton.cs.introcs.StdOut;

public class SkunkController
{

	private SkunkUI ui;
	private int iNumOfPlayers;
	private String[] NameOfPlayers;
	
	//**********************************************************
	
	public SkunkController()
	{
		ui = new SkunkUI();
		this.NameOfPlayers = new String[30];
	}
	
	//**********************************************************
	
	public boolean run()
	{
		ui.printLine( "in SkunkController class run()" );
		
		//ask for number of player.
		String strTemp = ui.printLineReadResponse( "Enter number of players?" );
		this.iNumOfPlayers = Integer.parseInt( strTemp );
		
		if( this.iNumOfPlayers < 0 )
		{
			ui.printLine( "invalid iNumOfPlayers: " + this.iNumOfPlayers + "Enter number of players greater than 0?" );
		}
		else if( this.iNumOfPlayers == 1 )
		{
			ui.printLine( "iNumOfPlayers: " + this.iNumOfPlayers );
		}
		else
		{
			ui.printLine( "iNumOfPlayers: " + this.iNumOfPlayers );
		}
		
		//ask for player name
		for ( int iii =0; iii < this.iNumOfPlayers; iii++ )
		{
			strTemp = ui.printLineReadResponse( "\nEnter Name of Player: " );
			this.NameOfPlayers[iii] = strTemp;
			ui.printLine( "Name of Player " + iii + ": " + this.NameOfPlayers[iii]  );
		}
		
		
		//
		Dice dice = new Dice();
				
		dice.roll();
		
		ui.printLine("Dice roll");
		ui.printLine(dice.toString());
		
	
		return false;
	}
	
	//**********************************************************

}
