package extensions;

import java.time.temporal.ValueRange;

public class vaildateTolerance {

	int minValue;
	int maxValue;
	int tolerance;
	int dischargeLimit;
	int peakLimit;
	
	boolean flag_temperature = false;
	boolean flag_SOC = false;
	
	
	
	public vaildateTolerance(int minValue,	int maxValue) 
	{
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.tolerance = (maxValue * 5)/100;
		this.dischargeLimit = minValue + tolerance;
		this.peakLimit = maxValue - tolerance;
		
	}
	public boolean checkTemperatureRange(int temperature) 
	{
		if(!checkWarning("Temperature",temperature) && !checkBreach("Temperature",temperature))
		{
			this.flag_temperature = true;
		}
		return this.flag_temperature;
	}
	
	public boolean checkSOCRange(int soc) 
	{
		if(!checkWarning("SOC",soc) && !checkBreach("SOC",soc))
		{
			this.flag_SOC = true;
		}
		return this.flag_SOC;
	}
	
	private boolean checkBreach(String type, int value) {
		
		if(isLowBreach(value))
		{
			Message.printMessage("low_breach",type);
			return true;
		}
		else if(isHighBreach(value))
		{
			Message.printMessage("high_breach",type);
			return true;
		}
		return false;
		
	}
	private boolean checkWarning(String type,int value) 
	{
		if(isDischarge(value))
		{
			Message.printMessage("low_warning",type);
			return true;
		}
		else if(isChargePeak(value))
		{
			Message.printMessage("high_warning",type);
			return true;
		}
		return false;
	}
	
	boolean isDischarge(int value)
	{
		return isValueInRange(minValue, dischargeLimit , value);
	}
	
	boolean isChargePeak(int value) 
	{
		return isValueInRange(peakLimit, maxValue , value);
	}
	
	boolean isLowBreach(int value)
	{
		return (value < minValue);
		
	}
	
	boolean isHighBreach(int value)
	{
		return (value > maxValue);
		
	}
	
	boolean isValueInRange(int minValue,int maxValue,long value)
	{
		return ValueRange.of(minValue, maxValue).isValidValue(value);
	}
	
}
