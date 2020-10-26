package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPredictableDie
{

	private static final int CONSTANT_TO_TEST_SKUNKAPP = 111;
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
	
	

	@Test public void test_PD_4_5_6()
	{
		PredictableDie die = new PredictableDie( new int[] {4, 5, 6});
		
		die.roll();
		assertEquals(4, die.getLastRoll());
		
		die.roll();
		assertEquals(5, die.getLastRoll());
		
		die.roll();
		assertEquals(6, die.getLastRoll());
	}
	
	@Test public void test_PD_Addition_of_2_Dice()
	{
		PredictableDie die = new PredictableDie( new int[] {1, 3});

		die.roll();
		int die1 = die.getLastRoll();
		die.roll();
		int die2 = die.getLastRoll();
		int sum = Integer.sum(die1, die2);
		assertEquals(sum, 4);
	}
	

	@Test
	public void test_SkunkApp_class_object_create()
	{
		SkunkApp skunk = new SkunkApp();
		assertEquals( CONSTANT_TO_TEST_SKUNKAPP, skunk.testSkunkAppClass());
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

}
