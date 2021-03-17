package extensions;

public class Message {
	enum TEMPERATURE
	{
		low_breach("LOW_TEMPERATURE_BREACH"),
		high_breach("HIGH_TEMPERATURE_BREACH"),
		low_warning("LOW_TEMPERATURE_WARNING"),
		high_waring("HIGH_TEMPERATURE_WARNING"),
		normal("NORMAL");
		
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
		low_breach("LOW_SOC_BREACH"),
		high_breach("HIGH_SOC_BREACH"),
		low_warning("LOW_SOC_WARNING"),
		high_waring("HIGH_SOC_WARNING"),
		normal("NORMAL");

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
		breach("CHARGERATE_BREACH"),
		warning("CHARGERATE_WARNING"),
		normal("NORMAL");

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
			System.out.println(TEMPERATURE.valueOf(type).getMessage());
			break;
		case "SOC":
			System.out.println(SOC.valueOf(type).getMessage());
			break;
		case "ChargeRate":
			System.out.println(CHARGERATE.valueOf(type).getMessage());
			break;
		default:
			System.out.println("Category not found");
			break;
			
		}
	}
	
	static void printMessage(String message) {
		System.out.println(message);
	}
}
