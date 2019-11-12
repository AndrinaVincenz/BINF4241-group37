package assignment4;

public class Main {
	
	public static void main(String args[]){
		
		ElectronicDevice newOven = new Oven();
		
		SwitchOn onCommand = new SwitchOn(newOven);
		
		Smartphone smartphone  = new Smartphone(onCommand);
		
		smartphone.press();
		
		//---------
		
		SwitchOff offCommand = new SwitchOff(newOven);
		
		smartphone  = new Smartphone(offCommand);
		
		smartphone.press();
		
		
	}
}
