package ext;

public class TemperatureMessage implements IMessage {
	enum TEMP
	{
		LOW_BREACH("LOW_TEMPERATURE_BREACH"),
		HIGH_BREACH("HIGH_TEMPERATURE_BREACH"),
		LOW_WARNING("LOW_TEMPERATURE_WARNING"),
		HIGH_WARNING("HIGH_TEMPERATURE_WARNING"),
		NORMAL("NORMAL");
		
		private String message;
		
		TEMP(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}
	@Override
	public String getMessage(String message) {
		return TEMP.valueOf(message).getMessage();
	}

}
