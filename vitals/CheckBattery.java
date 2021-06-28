package ext;

import java.util.ArrayList;
import java.util.List;

public class CheckBattery {
	
	private static int Min_Temperature = 0;
	private static int Max_Temperature = 45;

	private static int Min_SOC = 20;
	private static int Max_SOC = 80;

	private static float Max_Charge_Rate = 0.8f;
	static boolean isTemperature_OK = false;
	static boolean isSOC_OK = false;
	static boolean isChargeRate_OK = false;
	static List<String> output = new ArrayList<String>();

	public static boolean batteryIsOk(int temperature, int soc, float chargeRate, String unit) 
	{
		setFlag(temperature, soc, chargeRate, unit);
		checkFlagAndPrint();
				
		return (isTemperature_OK && isSOC_OK && isChargeRate_OK);
	}

	private static void checkFlagAndPrint() {
		output.add((!isTemperature_OK) ? "Temperature Out of Range" : "Temperature Is In Range");
		output.add((!isSOC_OK) ? "SOC Out of Range" : "SOC Is In Range");
		output.add((!isChargeRate_OK) ? "ChargeRate Out of Range" : "ChargeRate Is In Range");
		printOutput(output);
	}

	private static void printOutput(List<String> output) {
		output.forEach(result -> Logger.printMessage(result));		
	}

	private static void setFlag(int temperature, int soc, float chargeRate, String unit) {
		 isTemperature_OK = checkTemperature(temperature,unit);
		 isSOC_OK = checkSOC(soc);
		 isChargeRate_OK = checkChargeRate(chargeRate);
		
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
