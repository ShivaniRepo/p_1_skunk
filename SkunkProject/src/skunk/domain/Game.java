package skunk.domain;

public class Game {
	
	private boolean gameStarted = false;
	
	public String getGameStatus()
	{
		if (gameStarted == true) 
		{
			return "Skunk game has started";
		}
		else 
		{
			return "Skunk game has NOT started";
		}
		
	}
	
	public void gameStart()
	{
		this.gameStarted = true;
	}

}
