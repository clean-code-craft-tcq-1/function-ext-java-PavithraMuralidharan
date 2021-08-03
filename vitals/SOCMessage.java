package vitals;

public class SOCMessage implements IMessage
{
	enum STATEOFCHARGE
	{
		LOW_BREACH("LOW_SOC_BREACH"),
		HIGH_BREACH("HIGH_SOC_BREACH"),
		LOW_WARNING("LOW_SOC_WARNING"),
		HIGH_WARNING("HIGH_SOC_WARNING"),
		NORMAL("NORMAL");

		private String message;
		
		STATEOFCHARGE(String message) {
			this.message = message;
		}

	}

	@Override
	public String getMessage(String message) {
		return "STATE OF CHARGE:" + STATEOFCHARGE.valueOf(message).message;
		
	}

	
}
