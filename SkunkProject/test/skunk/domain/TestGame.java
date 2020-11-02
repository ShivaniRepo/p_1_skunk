package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {
	
	// Test to verify Skunk game NOT started and started

	@Test
	public void test_game_status() 
	{
		
		Game newGame = new Game();
		String gameStatus;
		
		// Test to verify game NOT started.
		
		gameStatus = newGame.getGameStatus();
		assertEquals("Skunk game has NOT started.", gameStatus);
		
		// Test to verify game started.
		
		newGame.gameStart();
		gameStatus = newGame.getGameStatus();
		assertEquals("Skunk game has started.", gameStatus);
		
	}
	
	
	// Test to ADD Player to Skunk Game. 
	
	@Test
	public void test_game_add_player()
	{
		Game newGame = new Game();
		newGame.addPlayer("Quan");
	}
	
	// Test to REMOVE Player from Skunk Game. 
	
	@Test
	public void test_game_remove_player()
	{
		Game newGame = new Game();
		newGame.removePlayer("Quan");
	}
	
		
	// Test to verify Game object	
		
	@Test
	public void test_game_object() 
	{
		Game newGame = new Game();
	}	
}

