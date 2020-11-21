package skunk.domain;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

//import java.util.Random;

import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;

public class TestRoll 
{
	@Test
	public void test_roll_not_greater_than_12()
	{
		Roll roll =  new Roll();
		roll.rollDice();
		
		int iTotal = roll.getLastRollValue();
		StdOut.println("iTotal: " + iTotal );
		
		assertTrue( iTotal <= 12 );
	}
	
	//@Test
	//public void test_Roll_isSkunk()
	//{
		//fail();
	//	boolean bb;
		
	//	Roll roll =  new Roll();
	//	Random rand = new Random();
		
	//	Dice dice = new Dice();
	//	dice.getPointerDie1().setLastRoll(1);
	//	dice.getPointerDie2().setLastRoll( ( rand.nextInt(4) + 2 ) );
		
	//	bb = roll.isRegularSkunk();
		
	//	assertTrue(bb);
	//}
	
	
	
}
