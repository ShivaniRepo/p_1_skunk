package skunk.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


public class TestTurn 
{
	private static final int CONSTANT_PLAYER_DECLINED_TO_PLAY = 2;
	private static final int CONSTANT_PLAYER_WANTS_TO_PLAY = 1;
	
	
	private SkunkConstant c;
	
	@Test
	public void test_turn_roll_getRollChoice_true()
	{
		Turn testTurn = null;
	 	testTurn = new Turn( CONSTANT_PLAYER_WANTS_TO_PLAY );
	
	 	boolean bRollChoice = testTurn.getRollChoice();
	 	assertTrue( bRollChoice );
	}
	
	@Test
	public void test_turn_roll_getRollChoice_false()
	{
		Turn testTurn = null;
	 	testTurn = new Turn( CONSTANT_PLAYER_DECLINED_TO_PLAY );
	
	 	boolean bRollChoice = testTurn.getRollChoice();
	 	assertFalse( bRollChoice );
	
	}
	
	@Test
	public void test_turn_roll_playTurn_true()
	{
		Turn testTurn = null;
	 	testTurn = new Turn( CONSTANT_PLAYER_WANTS_TO_PLAY );
	
	 	Player testPlayer = new Player("test");
	 	int iExitValue = testTurn.playTurn( testPlayer, 0 );
	 	
	 	//List ExitCodeList = Array.asList( -11, -22, -33);
	 	assertTrue(iExitValue <= -11 && iExitValue >= -33 );
	}
	
	
	@Test
	public void test_turn_roll_playTurn_false()
	{
		Turn testTurn = null;
	 	testTurn = new Turn( CONSTANT_PLAYER_DECLINED_TO_PLAY );
	
	 	Player testPlayer = new Player("test");
	 	int iExitValue = testTurn.playTurn( testPlayer, 0 );
	 	
	 	assertTrue(iExitValue == -44 );
	}
}
