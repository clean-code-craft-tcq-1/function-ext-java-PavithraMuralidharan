package vitals;

public class CheckChargeRate {

	float maxValue;
	float tolerance;
	boolean flag_chargeRate = false;
	
	public CheckChargeRate(float maxValue) 
	{
		this.maxValue = maxValue;
		this.tolerance = (maxValue * 5)/100;
	}
	
	public boolean checkRate(float chargeRate) 
	{
		if(checkChargeRateBreached(chargeRate))
		{
			this.flag_chargeRate = false;
		}
		else if(checkChargeRateWarning(chargeRate))
		{
			this.flag_chargeRate = true;
		}
		else
		{
			Logger.printLogger("NORMAL", new ChargeRateMessage());
			this.flag_chargeRate = true;
		}
		return flag_chargeRate;
		
	}
	
	boolean checkChargeRateBreached(float chargeRate)
	{
		if(chargeRate > maxValue)
		{
			Logger.printLogger("BREACH", new ChargeRateMessage());
			return true;
		}
		return false;

	}
	
	boolean checkChargeRateWarning(float chargeRate)
	{
		float warningRate = maxValue - tolerance;
		if(chargeRate >= warningRate || chargeRate <= maxValue)
		{
			Logger.printLogger("WARNING", new ChargeRateMessage());
			return true;
		}
		return false;		
	}
	
}
