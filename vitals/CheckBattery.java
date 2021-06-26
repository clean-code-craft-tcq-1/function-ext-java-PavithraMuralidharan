package ext;

public class CheckBattery {
	
	private static int Min_Temperature = 0;
	private static int Max_Temperature = 45;

	private static int Min_SOC = 20;
	private static int Max_SOC = 80;

	private static float Max_Charge_Rate = 0.8f;

	public static boolean batteryIsOk(int temperature, int soc, float chargeRate, String unit) 
	{
		boolean isTemperature_OK = checkTemperature(temperature,unit);
		boolean isSOC_OK = checkSOC(soc);
		boolean isChargeRate_OK = checkChargeRate(chargeRate);
		
		Logger.printMessage((!isTemperature_OK) ? "Temperature Out of Range" : "Temperature Is In Range");
		Logger.printMessage((!isSOC_OK) ? "SOC Out of Range" : "SOC Is In Range");
		Logger.printMessage((!isChargeRate_OK) ? "ChargeRate Out of Range" : "ChargeRate Is In Range");
		
		return (isTemperature_OK && isSOC_OK && isChargeRate_OK);
	}

	private static boolean checkTemperature(int temperature, String unit) {
		if(unit.equals("F"))
			temperature = UnitConversion.convertFarenheitToCelsius(temperature);
		
		return new CheckTemperatureAndSOC(Min_Temperature,Max_Temperature)
				.checkTemperatureRange(temperature);
	}

	private static boolean checkSOC(int soc) {
		return new CheckTemperatureAndSOC(Min_SOC,Max_SOC)
				.checkSOCRange(soc);
	}
	
	private static boolean checkChargeRate(float chargeRate) {
		return new CheckChargeRate(Max_Charge_Rate)
				.checkRate(chargeRate);
		
	}
	
}
