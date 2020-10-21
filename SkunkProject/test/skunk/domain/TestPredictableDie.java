package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPredictableDie
{

	private static final int CONSTANT_DEUCE = 2;

	@Test
	public void test_PD_1_2_3()
	{
		PredictableDie die = new PredictableDie( new int[] {1,2,3});
		
		die.roll();
		assertEquals(1, die.getLastRoll());
		
		die.roll();
		assertEquals(2, die.getLastRoll());
		
		die.roll();
		assertEquals(3, die.getLastRoll());		
	}
	
	
	@Test
	public void test_PD_1_more_than_once()
	{
		PredictableDie die = new PredictableDie( new int[] {1});
		
		die.roll();
		assertEquals(1, die.getLastRoll());
		
		die.roll();
		assertEquals(1, die.getLastRoll());
	}

	
	@Test(expected = RuntimeException.class)
	public void test_PD_with_empty_initial_int_array()
	{
		PredictableDie die = new PredictableDie( new int[] {});
		die.roll();
	}
	
	@Test
	public void test_SkunkApp_welcome_message()
	{
		SkunkApp skunk = new SkunkApp();
	}
	
	@Test
	public void test_PD_Check_for_Deuce()
	{
		PredictableDie die = new PredictableDie( new int[] {CONSTANT_DEUCE});
	
		die.roll();
		assertEquals(CONSTANT_DEUCE, die.getLastRoll());
	}
}
