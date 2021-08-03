package vitals;

public class Logger {
	
	static void printLogger(String category, IMessage type) {
		if(!category.isEmpty())
			printMessage(type.getMessage(category));
	}	
	
	static void printMessage(String message) {
		System.out.println(message);
	}
}