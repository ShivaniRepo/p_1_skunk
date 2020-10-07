package skunk.domain;

public class PredictableDie
{
	private int[] theRolls; //Array
	private int nextInt; //index pointer for next element
	private int lastRoll; //keeps track
	
	//default constructor
	public PredictableDie()
	{
		
	}
	
	//Constructor
	public PredictableDie(int[] is)
	{
		if( is.length == 0 )
		{
			throw new RuntimeException();
		}
		
		this.theRolls = is;
		this.nextInt = 0;		
	}

	public void roll()
	{
		this.lastRoll = this.theRolls[ this.nextInt ];
		
		//increment
		this.nextInt++;
		
		//Wrap around if index value is greater than the length of the array.
		if( this.nextInt == this.theRolls.length )
		{
			this.nextInt = 0;
		}
	}

	public int getLastRoll()
	{
		return this.lastRoll;
	}
	
}
