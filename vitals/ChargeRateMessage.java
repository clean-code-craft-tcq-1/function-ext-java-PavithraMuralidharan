package vitals;

public class ChargeRateMessage implements IMessage {
	enum CHARGERATE {
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

	@Override
	public String getMessage(String message) {
		return "CHARGE RATE:" + CHARGERATE.valueOf(message).getMessage();
	}
}