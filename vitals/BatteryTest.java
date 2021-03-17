package extensions;

public class BatteryTest {
	public static void main(String[] args) {

		  assert(checkBattery.batteryIsOk(98, 70, 0.7f,"F") == true);
		  assert(checkBattery.batteryIsOk(50, 85, 0.0f,"C") == false);
		  assert(checkBattery.batteryIsOk(-1, 85, 0.0f,"C") == false);
		  assert(checkBattery.batteryIsOk(123, 85, 0.0f,"F") == false);
		  assert(checkBattery.batteryIsOk(25, 15, 0.0f,"F") == false);
		  assert(checkBattery.batteryIsOk(25, 25, 0.9f,"C") == false);
		 
		System.out.println("Some more tests needed");
	}
}
