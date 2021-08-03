package vitals;

public class Main {
	public static void main(String[] args) 
	{
		assert (CheckBattery.batteryIsOk(98, 75, 0.7f, "F") == true);
		assert (CheckBattery.batteryIsOk(50, 85, 0.0f, "C") == false);
		assert (CheckBattery.batteryIsOk(-1, 85, 0.0f, "C") == false);
		assert (CheckBattery.batteryIsOk(123, 85, 0.0f, "F") == false);
		assert (CheckBattery.batteryIsOk(25, 15, 0.0f, "F") == false);
		assert (CheckBattery.batteryIsOk(25, 25, 0.9f, "C") == false);

		System.out.println("Some more tests needed");
	}
}
