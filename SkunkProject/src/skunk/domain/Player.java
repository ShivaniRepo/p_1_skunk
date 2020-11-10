package skunk.domain;

public class Player {

	private int chipCount = 50;
	private int playerScore = 0;
	int playerNum = 0;
	String playerName = null;
	Game newGame = new Game();
	Roll roll = new Roll();
	
	public Player() 
	{

	}

	public Player(String playerName)
	{
		this.playerName= playerName;
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