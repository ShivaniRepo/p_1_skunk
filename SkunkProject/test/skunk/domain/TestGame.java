package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {
	
	// Test to verify gameStatus 

	@Test
	public void test_game_status() 
	{
		
		Game newGame = new Game();
		String gameStatus;
		
		gameStatus = newGame.getGameStatus();
		assertEquals("Skunk game has NOT started", gameStatus);
		
//		gameStatus = newGame.getGameStatus();
//		assertEquals("Skunk game has started", gameStatus);
		
	}
		
	// Test to verify Game object	
		
	@Test
	public void test_game_object() 
	{
		fail();
		Game newGame = new Game();
	}	
}

