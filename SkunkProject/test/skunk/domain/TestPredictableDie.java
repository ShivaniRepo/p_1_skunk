package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;

public class TestPredictableDie
{

	private static final int CONSTANT_SKUNK_DEUCE_TOTAL = 3;
	private static final int CONSTANT_SKUNK = 1;
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
		PredictableDie die = new PredictableDie( new int[] {CONSTANT_SKUNK});
		
		die.roll();
		assertEquals(CONSTANT_SKUNK, die.getLastRoll());
		
		die.roll();
		assertEquals(CONSTANT_SKUNK, die.getLastRoll());
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
	
	
	@Test
	public void test_PD_Check_for_Skunk_and_Deuce()
	{
		int iTotal = 0;
		
		PredictableDie die = new PredictableDie( new int[] {CONSTANT_SKUNK,CONSTANT_DEUCE});
		
		die.roll();
		assertEquals(CONSTANT_SKUNK, die.getLastRoll());
		iTotal = die.getLastRoll();
		
		die.roll();
		assertEquals(CONSTANT_DEUCE, die.getLastRoll());
		iTotal += die.getLastRoll();
		
		assertEquals( CONSTANT_SKUNK_DEUCE_TOTAL, iTotal );
	}
	
	@Test
	public void test_PD_Addition_Not_Greater_than_12()
	{
		int firstroll = 0;
		int secondroll= 0;
		int result = 0;
		
		Die die = new Die();
		
		die.roll();
		firstroll = die.getLastRoll();
		
		die.roll();
		secondroll = die.getLastRoll();
		
		result = firstroll + secondroll;
		
		assert(result <=12);
		
	}
	
	@Test
	public void test_PD_Check_for_Skunk()
	{
		
		PredictableDie die = new PredictableDie (new int[] {1,2});
		
		die.roll();
		int firstroll = die.getLastRoll();
		
		die.roll();
		int secondroll = die.getLastRoll();
		
		assertTrue(firstroll == 1 || secondroll == 1);
	}
	
	

}
