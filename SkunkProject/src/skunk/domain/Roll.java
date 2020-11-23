
package skunk.domain;

//import edu.princeton.cs.introcs.StdOut;

//Roll: Throw Dice ( pair of die ) once and save the sum of values.

public class Roll
{
	private static final int CONSTANT_REGULAR_GAME = 0;
	
	
	private Dice dice;
	private int iRollTotal;
	private SkunkUI ui1;
	private int iTestCall = 0;
	private int iTestDieValue = 0;
	
	//**********************************************************
	
	public Roll()
	{
		ui1 = new SkunkUI();
		dice = new Dice();
	}

	//**********************************************************
	
	public Roll( SkunkUI ui, int iTestCall, int iTestDieValue )
	{
		ui1 = ui;
		dice = new Dice();
		this.iTestCall = iTestCall;
		this.iTestDieValue = iTestDieValue;
	}

	//**********************************************************
	
	public void rollDice() 
	{
		dice.roll();
		ui1.printLine( dice.toString() );
		return;
	}
		
	//**********************************************************
	
	public int getLastRollValue() 
	{
		int iValue = 0;
		
		if( this.iTestCall == CONSTANT_REGULAR_GAME )
		{
			iValue = dice.getLastRoll();
			dice.toString();
		}
		else
		{
			iValue = this.iTestDieValue;
		}
		
		set_iRollTotal( iValue);
		return iValue;
	}
	
	//**********************************************************
	
	public int get_iRollTotal() 
	{
		return iRollTotal;
	}

	//**********************************************************
	
	public void set_iRollTotal(int iRollTotal) 
	{
		this.iRollTotal = iRollTotal;
	}
	
	//*********************roll*************************************
	
	public boolean isRegularSkunk()
	{
		int iDie1 = dice.getPointerDie1().getLastRoll();
		int iDie2 = dice.getPointerDie2().getLastRoll();
		
		if( iDie1 == 1 && iDie2 == 1)
		{
			return false;
		}
		else if( iDie1 == 1 || iDie2 == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//**********************************************************
	
	public boolean isDoubleSkunk()
	{
		if( getLastRollValue() == 2 )
			return true;
		else
			return false;
	}
	
	//**********************************************************
	
	public boolean isSkunkDeuce()
	{
		if( getLastRollValue() == 3 )
			return true;
		else
			return false;
	}
}
