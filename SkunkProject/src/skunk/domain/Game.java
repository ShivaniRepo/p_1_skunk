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
	
	
	// Return total players
	public int getTotalPlayers()
	{
		int total = totalPlayers.size();
		return total;
		
	}

	// Method to add Player to Game. 
	public void addPlayer(String string) 
	
	{
		Player player = new Player(string);
		totalPlayers.add(player);
		
	}
	
	// Method to REMOVE Player from Game. 

	public void removePlayer(String string) 
	{
		// TODO Auto-generated method stub
		// Need method from Player class to remove player. 
		
	}

}
