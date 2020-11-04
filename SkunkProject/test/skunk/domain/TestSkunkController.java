package skunk.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestSkunkController
{
	private static final int ERROR_INVALID_PLAYER_NUMBER = -1;

	//@Test
	//public void test_skunk_controller_run()
	//{
	//	SkunkController skunk = new SkunkController();

	//	boolean bStatus = skunk.run();

	//	assertFalse(bStatus);
	//}
	
	
	@Test
	public void test_skunk_controller_invalid_player_number_negative()
	{
		SkunkController skunk = new SkunkController();
		
		int iReturn = skunk.getNumberOfPlayers(-1);
		assertEquals(ERROR_INVALID_PLAYER_NUMBER, iReturn );
	}
	
}
