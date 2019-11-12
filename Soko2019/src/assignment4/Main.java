package assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		ElectronicDevice pickedDevice = null;
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
