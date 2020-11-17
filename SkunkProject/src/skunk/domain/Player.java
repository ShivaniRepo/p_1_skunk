package skunk.domain;

public class Player {

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
	
	public Player(int playerCount, String playerID) {
		this.playerName = playerID;
		this.playerNum = playerCount;
	}

	
	// Draft - Needs to be updated
//	public void setPlayer() {
//		playerName = newGame.getPlayerName();
//		playerNum = newGame.getNumPlayers();
//	}

	public String getPlayerName() {
		return this.playerName;
	}

	public int getPlayerNum() {
		return this.playerNum;
	}
	
	public int getPlayerScore() {
		return this.playerScore;
	}

	public int getPlayerChipCount() 
	{
		//to be added later
//		if (roll.getDie1Score() == 1 & roll.getDie2Score() == 1) {
//			this.chipCount = 0;
//			return this.chipCount;
//		} else {
//			return this.chipCount += roll.updateChipCount();
//		}
		return this.chipCount;
	}

	public void setPlayerChipCount(int x) 
	{
		this.chipCount = x;
	}

}