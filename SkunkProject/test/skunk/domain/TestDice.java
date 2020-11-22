package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDice 
{
	
	@Test
	public void test_Dice_Roll_Value() 
	{
		Dice dice = new Dice();
		dice.roll();
		assertTrue(dice.getLastRoll() >= 2 && dice.getLastRoll() <= 12);
	}

	@Test
	public void test_Dice_main()
	{
		fail();
	}
}
