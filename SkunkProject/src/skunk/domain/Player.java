package skunk.domain;

public class Player 
{

	private int chipCount;
	private int playerScore;
	int playerNum = 0;
	boolean bChipsFromKitty_updated = false;
	boolean bChipsFromPlayers_updated = false;

	String playerName = null;
	boolean bIsPlayerInTheGame = true;
	
	
	public Player() 
	{
		this.chipCount = 50;
		this.playerScore = 0;
	}

	public Player(String playerName )
	{
		this.playerName= playerName;
		this.chipCount = 50;
		this.playerScore = 0;
	}
	
	public Player(String playerName, int iNum )
	{
		this.playerName= playerName;
		this.chipCount = 50;
		this.playerScore = 0;
		this.playerNum = iNum;
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

	public void update_PlayerChipCount(int x) 
	{
		this.chipCount += x;
	}
	
	public boolean get_bUpdatedChips_FromKitty_Flag() 
	{
		return this.bChipsFromKitty_updated;
	}

	public void set_bUpdatedChips_FromKitty_Flag(boolean bFlag) 
	{
		this.bChipsFromKitty_updated = bFlag;
	}
	
	public boolean get_bChipsFromPlayers_updated() 
	{
		return this.bChipsFromPlayers_updated;
	}

	public void set_bChipsFromPlayers_updated(boolean bFlag)
	{
		this.bChipsFromPlayers_updated = bFlag;
	}
	
	
	public boolean is_bIsPlayerInTheGame() 
	{
		return this.bIsPlayerInTheGame;
	}

	public void set_bIsPlayerInTheGame(boolean bIsPlayerInTheGame) 
	{
		this.bIsPlayerInTheGame = bIsPlayerInTheGame;
	}
}