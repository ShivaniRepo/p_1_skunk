package skunk.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestSkunkController
{
	//@Test
	//public void test_skunk_controller_run()
	//{
	//	SkunkController skunk = new SkunkController();

	//	boolean bStatus = skunk.run();

	//	assertFalse(bStatus);
	//}
	
	@Test
	public void test_controller_object() 
	{
		SkunkController controller = new SkunkController();
		assertNotNull(controller);
	}	

}
