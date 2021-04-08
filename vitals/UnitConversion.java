package extensions;

public class UnitConversion 
{
	UnitConversion(){}

	static int convertFarenheitToCelsius(int temperature) 
	{
		return ((temperature - 32) * 5)/9;
	}
}
