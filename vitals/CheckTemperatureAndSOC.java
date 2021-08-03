package vitals;

import java.time.temporal.ValueRange;

public class CheckTemperatureAndSOC {

	int minValue;
	int maxValue;
	int tolerance;
	int dischargeLimit;
	int peakLimit;

	boolean flag_temperature = false;
	boolean flag_SOC = false;

	String temp_msg = "";
	String SOC_msg = "";

	public CheckTemperatureAndSOC(int minValue, int maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.tolerance = (maxValue * 5) / 100;
		this.dischargeLimit = minValue + tolerance;
		this.peakLimit = maxValue - tolerance;

	}

	public boolean checkTemperatureRange(int temperature) {
		String warning = checkWarning(temperature);
		String breach = checkBreach(temperature);

		if (warning != null) {
			temp_msg = warning;
			this.flag_temperature = true;
		} else if (breach != null) {
			temp_msg = breach;
			this.flag_temperature = true;
		}
		Logger.printLogger(temp_msg, new TemperatureMessage());
		return this.flag_temperature;
	}

	public boolean checkSOCRange(int soc) {
		String warning = checkWarning(soc);
		String breach = checkBreach(soc);

		if (warning != null) {
			SOC_msg = warning;
			this.flag_SOC = true;
		} else if (breach != null) {
			SOC_msg = breach;
			this.flag_SOC = true;
		}
		Logger.printLogger(SOC_msg, new SOCMessage());
		return this.flag_SOC;
	}

	private String checkBreach(int value) {

		if (isLowBreach(value)) {
			return "LOW_BREACH";
		} else if (isHighBreach(value)) {
			return "HIGH_BREACH";
		}
		return null;

	}

	private String checkWarning(int value) {
		if (isDischarge(value)) {
			return "LOW_WARNING";
		} else if (isChargePeak(value)) {
			return "HIGH_WARNING";
		}
		return null;
	}

	boolean isDischarge(int value) {
		return isValueInRange(minValue, dischargeLimit, value);
	}

	boolean isChargePeak(int value) {
		return isValueInRange(peakLimit, maxValue, value);
	}

	boolean isLowBreach(int value) {
		return (value < minValue);

	}

	boolean isHighBreach(int value) {
		return (value > maxValue);

	}

	boolean isValueInRange(int minValue, int maxValue, long value) {
		return ValueRange.of(minValue, maxValue).isValidValue(value);
	}

}
