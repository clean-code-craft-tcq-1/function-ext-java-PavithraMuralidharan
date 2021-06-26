package ext;

public class Logger {
	
	static void printLogger(String category, IMessage type) {
		
		printMessage(type.getMessage(category));
	}
	
	static void printMessage(String message) {
		System.out.println(message);
	}
}
