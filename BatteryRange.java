
public class BatteryRange {
	
	private float minValue; 
	private float maxValue;
	private float chargeRate;

	public BatteryRange(float minValue, float maxValue , float chargeRate) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.chargeRate = chargeRate;
	}

	public float getMinValue() {
		return minValue;
	}

	public float getMaxValue() {
		return maxValue;
	}

	public float getChargeRate() {
		return chargeRate;
	}
	
	static boolean inRange(String type,float value,BatteryRange cond) {
    	if(type.equals("ChargeRate"))
    		return (value > cond.getChargeRate());
    	else
    		return (value < cond.getMinValue() && value > cond.getMaxValue());
    }   

}
