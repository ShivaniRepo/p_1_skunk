package skunk.domain;

public class Kitty 
{
	private static int iChips = 0;

	public static int get_iChips() 
	{
		return Kitty.iChips;
	}

	public static void set_iChips(int iChips) 
	{
		Kitty.iChips = iChips;
	}
	
	public static void add_iChips(int iChips) 
	{
		Kitty.iChips += iChips;
	}

}
