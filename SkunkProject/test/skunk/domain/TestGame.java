package skunk.domain;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class TestGame {
	
	private static final int RETURN_OK = 0;
	private static final int ERROR_INVALID_PLAYER_NUMBER = -1;

	@Test
	public void test_game_status() 
	{
		Game newGame = new Game();
		String gameStatus;
		
		// Test to verify game NOT started.
		
		gameStatus = newGame.getGameStatus();
		assertEquals("Skunk game has NOT started.", gameStatus);
		
		// Test to verify game started.
		
		newGame.startGame();
		gameStatus = newGame.getGameStatus();
		assertEquals("Skunk game has started.", gameStatus);
		
	}
	
	@Test
	public void test_game_invalid_player_number_negative()
	{
		Game newGame = new Game();
		
		int iReturn = newGame.getNumberOfPlayers(-1);
		assertEquals(ERROR_INVALID_PLAYER_NUMBER, iReturn);
		
	}

	@Test
	public void test_skunk_game_valid_player_number_zero_to_Max()
	{
		Game newGame = new Game();
		Random rand = new Random();
		
		int min = 1;
		int max = 30;
		
		int iPlayerCount = rand.nextInt(max - min + 1) + min;
		
		int iReturn = newGame.getNumberOfPlayers( iPlayerCount );
		assertEquals( RETURN_OK, iReturn );
	}
	
	@Test
	public void test_end_game()
	{
		Game newGame = new Game();
		boolean gameStatus;
		
		gameStatus = newGame.endGame();
		assertTrue(gameStatus == false);
	}

//	//  Test to ADD Player to Skunk Game. 
//	
//	@Test
//	public void test_game_add_player()
//	{
//		Game newGame = new Game();
//		newGame.addPlayer("Quan");
//		assertTrue(newGame.getTotalPlayers() == 1);
//	}
//	
//	// Test to REMOVE Player from Skunk Game. 
//	
//	@Test
//	public void test_game_remove_player()
//	{
//		Game newGame = new Game();
//		newGame.addPlayer("Quan");
//		newGame.addPlayer("Shivani");
//		newGame.addPlayer("Ayan");
//		newGame.removePlayers();
//		assertTrue(newGame.getTotalPlayers() == 0);
//	}
//	
//	// Test for Total Players in Skunk Game.
//	
//	@Test
//	public void test_game_total_player()
//	{
//		Game newGame = new Game();
//		int total = newGame.getTotalPlayers();
//		assertNotNull(total);
//	}
//	
//	// Test to verify Game object	
//		
//	@Test
//	public void test_game_object() 
//	{
//		Game newGame = new Game();
//		assertNotNull(newGame);
//
//	}	
//	
}

