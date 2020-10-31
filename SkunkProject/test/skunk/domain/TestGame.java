package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {
	
	// Test to verify gameStatus condition 

	@Test
	public void test_game_status() {
		Game newGame = new Game();
		boolean gameStatus;
		gameStatus = newGame.getGameStatus();
		assertTrue(gameStatus);

}
}
