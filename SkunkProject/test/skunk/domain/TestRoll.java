package skunk.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
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
	
	@Test
	public void test_get_iRollTotal()
	{
		Roll roll =  new Roll();
		int iTestingValue = 10;
		
		roll.set_iRollTotal( iTestingValue );
		int iReurnValue = roll.get_iRollTotal();
		
		assertEquals( iReurnValue, iTestingValue);
	};
	
	
}
