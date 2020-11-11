package skunk.domain;

import java.util.ArrayList;

public class Game {
	
	private boolean StartGame = false;
	private boolean EndGame = false;
	private ArrayList<Player> totalPlayers = new ArrayList();
	
	public String getGameStatus()
	{
		if (StartGame == true) 
		{
			return "Skunk game has started.";
		}
		else 
		{
			return "Skunk game has NOT started.";
		}
		
	}
	
	public void startGame()
	{
		this.StartGame = true;
	}
	
	public boolean endGame()
	{
		return this.EndGame = false;
	}
	
	
	// Method to return total number of players. Need to follow up with Player class. 
	public int getTotalPlayers()
	{
		int total = totalPlayers.size();
		return total;
		
	}

	// Method to add Player to Game. 
	public void addPlayer(String string) 
	
	{
		// TODO Auto-generated method stub
		
	}
	
	// Method to REMOVE Player from Game. 

	public void removePlayer(String string) 
	{
		// TODO Auto-generated method stub
		// Need method from Player class to remove player. 
		
	}

}
