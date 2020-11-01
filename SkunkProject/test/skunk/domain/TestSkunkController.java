package skunk.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestSkunkController
{
	@Test
	public void test_skunk_controller_run()
	{
		SkunkController skunk = new SkunkController();

		boolean bStatus = skunk.run();

		assertFalse(bStatus);
	}
}
