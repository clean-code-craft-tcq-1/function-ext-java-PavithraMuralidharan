package extensions;

public class Message {
	enum TEMPERATURE
	{
		LOW_BREACH("LOW_TEMPERATURE_BREACH"),
		HIGH_BREACH("HIGH_TEMPERATURE_BREACH"),
		LOW_WARNING("LOW_TEMPERATURE_WARNING"),
		HIGH_WARNING("HIGH_TEMPERATURE_WARNING"),
		NORMAL("NORMAL");
		
		private String message;
		
		TEMPERATURE(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}
	
	enum SOC
	{
		LOW_BREACH("LOW_SOC_BREACH"),
		HIGH_BREACH("HIGH_SOC_BREACH"),
		LOW_WARNING("LOW_SOC_WARNING"),
		HIGH_WARNING("HIGH_SOC_WARNING"),
		NORMAL("NORMAL");

		private String message;
		
		SOC(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}
	
	enum CHARGERATE
	{
		BREACH("CHARGERATE_BREACH"),
		WARNING("CHARGERATE_WARNING"),
		NORMAL("NORMAL");

		private String message;
		
		CHARGERATE(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}
	
	static void printMessage(String type, String category) {
		
		switch(category)
		{
		case "Temperature":
			printMessage(TEMPERATURE.valueOf(type).getMessage());
			break;
		case "SOC":
			printMessage(SOC.valueOf(type).getMessage());
			break;
		case "ChargeRate":
			printMessage(CHARGERATE.valueOf(type).getMessage());
			break;
		default:
			printMessage("Category not found");
			break;
			
		}
	}
	
	static void print(String type,boolean flag) {
		String msg = !flag ? "Out of Range" : "Is In Range"; 
		printMessage(String.format("%s %s",type,msg));
	}
	
	static void printMessage(String message) {
		System.out.println(message);
	}
}
