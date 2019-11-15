package assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]){
		
		// TEST COMMANDS
//		Oven newOven = new Oven();
//		Smartphone smartphone  = new Smartphone();
//		
//		smartphone.setCommand(newOven.showAvailableCommands().get(1));
//		smartphone.displayPressed();
//		
//		smartphone.setCommand(newOven.showAvailableCommands().get(0));
//		smartphone.displayPressed();
	
		
		//TODO: logic for later...
		Scanner scanner = new Scanner(System.in);
		Device pickedDevice = null;
		ArrayList<Device> devices = new ArrayList<Device>();
		devices.add(new Oven());
		
		while (pickedDevice == null){
			System.out.println("Choose one of the following devices:");
			for(Device device : devices) {
	            System.out.println(device);
	        }
			String deviceInput = scanner.nextLine(); 
			for(Device device : devices) {
				if (device.getName().equals(deviceInput)){
					System.out.println(deviceInput);
					System.out.println("You have chosen " + deviceInput);
					pickedDevice = device;
					System.out.println("Choose one of the following services or write 'back' to return");
					ArrayList<Command> tempCommands = device.showAvailableCommands();
					for(Command tempCommand : tempCommands){
						tempCommand.getName();
					}
					
				} else {
					System.out.println("This device doesn't exist!");
				}
	        }
			
		}
		
		
		
	}
	
}
