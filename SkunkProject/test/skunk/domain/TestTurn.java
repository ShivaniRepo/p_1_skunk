package skunk.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


public class TestTurn 
{
	
	@Test
	public void test_turn_roll_getRollChoice_true()
	{
		Turn testTurn = null;
	 	testTurn = new Turn( 1 );
	
	 	boolean bRollChoice = testTurn.getRollChoice();
	 	assertTrue( bRollChoice );
	 	
		//Player testPlayer = new Player("test");
		//testTurn.playTurn(testPlayer, 0 );
		//StdOut.println( 'y' );
		
	}
	
	
}
