package skunk.domain;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPlayer
{
	Player player = new Player("test");	
	
	// Test to verify Player's score 

	@Test
	public void testPlayer1()
	{
		assertEquals("testPlayer1", 0, player.getPlayerScore());
	}
	
	// Test to verify Player's name
	
	@Test	
	public void testPlayer2() {
		
		Player player1 = new Player("test");
		assertEquals("test",player1.getPlayerName());
		
	}

}
