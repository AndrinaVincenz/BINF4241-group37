package assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]){
		
		// TEST COMMANDS
		Oven newOven = new Oven();
		Smartphone smartphone  = new Smartphone();
		
		smartphone.setCommand(new OvenSwitchOnCommand(newOven));
		smartphone.displayPressed();
		
		smartphone.setCommand(new OvenSetTemperaturCommand(newOven, 120));
		smartphone.displayPressed();
	
		
		//TODO: logic for later...
		Scanner scanner = new Scanner(System.in);
		ArrayList<Object> pickedDevice = null;
		ArrayList<String> devices = new ArrayList<String>();
		devices.add("Oven");
		devices.add("Microwave");
		
		while (pickedDevice == null){
			System.out.println("Choose one of the following devices:");
			for(String device : devices) {
	            System.out.println(device);
	        }
			String device = scanner.nextLine(); 
			if (devices.contains(device)){
				System.out.println(device);
			} else {
				System.out.println("This device doesn't exist!");
			}
		}
		
		
		
	}
	
}
