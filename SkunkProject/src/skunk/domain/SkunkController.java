package skunk.domain;

//import edu.princeton.cs.introcs.StdOut;

public class SkunkController
{
	private Game game;
	
	public SkunkController()
	{
		this.game = new Game();
	}
	
	public boolean run()
	{
		return game.run();
	}
	
	public void startGame()
	{
		game.startGame();
	}
}
