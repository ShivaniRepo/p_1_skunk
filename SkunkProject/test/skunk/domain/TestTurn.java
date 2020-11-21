package skunk.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import skunk.domain.SkunkConstant.Constant;

//**********************************************************

public class TestTurn 
{
	//local file constants.
	static final int CONSTANT_DIE_VALUE_3 = 3;
	static final int CONSTANT_DIE_VALUE_2 = 2;
	
	
	@Test
	public void test_turn_roll_getRollChoice_true()
	{
		Turn testTurn = null;
	 	testTurn = new Turn( 1, Constant.CONSTANT_PLAYER_WANTS_TO_PLAY );
	
	 	boolean bRollChoice = testTurn.getRollChoice();
	 	assertTrue( bRollChoice );
	}
	
	@Test
	public void test_turn_roll_getRollChoice_false()
	{
		Turn testTurn = null;
	 	testTurn = new Turn( Constant.CONSTANT_PLAYER_DECLINED_TO_PLAY, Constant.CONSTANT_DUMMY );
	
	 	boolean bRollChoice = testTurn.getRollChoice();
	 	assertFalse( bRollChoice );
	
	}
	
	@Test
	public void test_turn_roll_playTurn_true()
	{
		Turn testTurn = null;
	 	testTurn = new Turn( Constant.CONSTANT_PLAYER_WANTS_TO_PLAY, Constant.CONSTANT_DUMMY );
	
	 	Player testPlayer = new Player("Amy");
	 	int iExitValue = testTurn.playTurn( testPlayer, 0 );
	 	
	 	assertTrue(iExitValue == Constant.CONSTANT_IS_REGULAR_SKUNK || 
	 			iExitValue == Constant.CONSTANT_IS_DOUBLE_SKUNK || 
	 			iExitValue == Constant.CONSTANT_IS_SKUNK_DEUCE );
	}
	
	
	@Test
	public void test_turn_roll_playTurn_false()
	{
		Turn testTurn = null;
	 	testTurn = new Turn( Constant.CONSTANT_PLAYER_DECLINED_TO_PLAY, Constant.CONSTANT_DUMMY );
	
	 	Player testPlayer = new Player("Amy");
	 	int iExitValue = testTurn.playTurn( testPlayer, 0 );
	 	
	 	assertTrue(iExitValue == Constant.CONSTANT_PLAYER_DECLINED_ROLL );
	}
	
	
	@Test
	public void test_turn_playTurn_double_skunk() 
	{
		Turn testTurn = null;
	 	testTurn = new Turn( Constant.CONSTANT_PLAYER_WANTS_TO_PLAY, CONSTANT_DIE_VALUE_2 );
	
	 	Player testPlayer = new Player("Amy");
	 	int iExitValue = testTurn.playTurn( testPlayer, 0 );
	 	
	 	assertEquals( iExitValue, Constant.CONSTANT_IS_DOUBLE_SKUNK );
	}
	
	@Test
	public void test_turn_playTurn_skunk_deuce() 
	{
		Turn testTurn = null;
	 	testTurn = new Turn( Constant.CONSTANT_PLAYER_WANTS_TO_PLAY, CONSTANT_DIE_VALUE_3 );
	
	 	Player testPlayer = new Player("Amy");
	 	int iExitValue = testTurn.playTurn( testPlayer, 0 );
	 	
	 	assertEquals( iExitValue, Constant.CONSTANT_IS_SKUNK_DEUCE );
	}
	
}
