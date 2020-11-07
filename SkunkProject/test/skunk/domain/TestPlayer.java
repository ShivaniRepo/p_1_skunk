package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer
{
	Player player = new Player();	
	
	// Test to verify Player's score 

	@Test
	public void testPlayer1()
	{
		assertEquals("testPlayer1", 0, player.getPlayerScore());
	}
	
	// Test to verify Player's name
	
	@Test	
	public void testPlayer4() {
		
		fail();
		
	}

}
