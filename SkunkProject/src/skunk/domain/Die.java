package skunk.domain;

public class Die
{
	private int lastRoll;
	SkunkUI uid;

	//**********************************************************
	
	public Die()
	{
		uid =  new SkunkUI();
		this.roll();
	}

	//**********************************************************
	
	public int getLastRoll() // getter or accessor method
	{
		return this.lastRoll;
	}

	public void setLastRoll( int rollValue ) // getter or accessor method
	{
		this.lastRoll = rollValue;
		uid.printLine( "setLastRoll: " + this.lastRoll );
	}
	
	//**********************************************************
	
	public void roll() // note how this changes Die's state, but doesn't return anything
	{
		this.lastRoll = (int) (Math.random() * 6 + 1);
	}

	//**********************************************************
	
	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}
	
	//**********************************************************

}
