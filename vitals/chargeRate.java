package extensions;

public class chargeRate {

	float maxValue;
	float tolerance;
	boolean flag_chargeRate = false;
	
	public chargeRate(float maxValue) 
	{
		this.maxValue = maxValue;
		this.tolerance = (maxValue * 5)/100;
	}
	
	public boolean checkChargeRate(float chargeRate) 
	{
		if(!checkChargeRateBreached(chargeRate))
		{
			this.flag_chargeRate = true;
		}
		return flag_chargeRate;
		
	}
	
	boolean checkChargeRateBreached(float chargeRate)
	{
		if(chargeRate > maxValue)
		{
			Message.printMessage("breach", "ChargeRate");
			return true;
		}
		return false;

	}
	
	boolean checkChargeRateWarning(float chargeRate)
	{
		float warningRate = maxValue - tolerance;
		if(chargeRate >= warningRate || chargeRate <= maxValue)
		{
			Message.printMessage("warning", "ChargeRate");
			return true;
		}
		return false;		
	}
	
}
