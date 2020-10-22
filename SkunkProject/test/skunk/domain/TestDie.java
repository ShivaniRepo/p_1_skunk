package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDie
{

	@Test
	public void test_Roll_Value()
	{
		Die die = new Die();
		die.roll();
        assertTrue(die.getLastRoll() >= 1 && die.getLastRoll() <= 6);
	}

}
