package skunk.domain;

public class Player 
{

	private int chipCount;
	private int playerScore;
	int playerNum = 0;
	String playerName = null;
	
	public Player() 
	{
		this.chipCount = 50;
		this.playerScore = 0;
	}

	public Player(String playerName)
	{
		this.playerName= playerName;
		this.chipCount = 50;
		this.playerScore = 0;
	}

	public String getPlayerName() 
	{
		return this.playerName;
	}

	public int getPlayerNum() 
	{
		return this.playerNum;
	}
	
	public int getPlayerScore() 
	{
		return this.playerScore;
	}

	public void setPlayerScore(int x) 
	{
		this.playerScore = x;
	}
	
	public int getPlayerChipCount() 
	{
		return this.chipCount;
	}

	public void setPlayerChipCount(int x) 
	{
		this.chipCount = x;
	}

}