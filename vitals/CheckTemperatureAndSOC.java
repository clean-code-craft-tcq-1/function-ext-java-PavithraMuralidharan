package ext;

import java.time.temporal.ValueRange;

public class CheckTemperatureAndSOC {

	int minValue;
	int maxValue;
	int tolerance;
	int dischargeLimit;
	int peakLimit;
	
	boolean flag_temperature = false;
	boolean flag_SOC = false;
	
	
	
	public CheckTemperatureAndSOC(int minValue,	int maxValue) 
	{
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.tolerance = (maxValue * 5)/100;
		this.dischargeLimit = minValue + tolerance;
		this.peakLimit = maxValue - tolerance;
		
	}
	public boolean checkTemperatureRange(int temperature) 
	{
		if(!checkWarning(new TemperatureMessage(),temperature) && !checkBreach(new TemperatureMessage(),temperature))
		{
			this.flag_temperature = true;
		}
		return this.flag_temperature;
	}
	
	public boolean checkSOCRange(int soc) 
	{
		if(!checkWarning(new SOCMessage(),soc) && !checkBreach(new SOCMessage(),soc))
		{
			this.flag_SOC = true;
		}
		return this.flag_SOC;
	}
	
	private boolean checkBreach(IMessage type, int value) {
		
		if(isLowBreach(value))
		{
			Logger.printLogger("LOW_BREACH",type);
			return true;
		}
		else if(isHighBreach(value))
		{
			Logger.printLogger("HIGH_BREACH",type);
			return true;
		}
		return false;
		
	}
	private boolean checkWarning(IMessage type,int value) 
	{
		if(isDischarge(value))
		{
			Logger.printLogger("LOW_WARNING",type);
			return true;
		}
		else if(isChargePeak(value))
		{
			Logger.printLogger("HIGH_WARNING",type);
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
