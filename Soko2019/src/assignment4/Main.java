package assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		// TEST COMMANDS
		// Oven newOven = new Oven();
		// Smartphone smartphone = new Smartphone();
		//
		// smartphone.setCommand(newOven.showAvailableCommands().get(1));
		// smartphone.displayPressed();
		//
		// smartphone.setCommand(newOven.showAvailableCommands().get(0));
		// smartphone.displayPressed();

		// TODO: logic for later...
		Scanner scanner = new Scanner(System.in);
		Device pickedDevice = null;
		Command pickedCommand = null;
		ArrayList<Device> devices = new ArrayList<Device>();
		devices.add(new Oven());
		devices.add(new Microwave());

		while (pickedDevice == null) {
			System.out.println("Choose one of the following devices:");
			for (Device device : devices) {
				System.out.println(device.getName());
			}
			String deviceInput = scanner.nextLine();
			for (Device device : devices) {
				if (device.getName().equals(deviceInput)) {
					System.out.println("You have chosen " + deviceInput);
					pickedDevice = device;
					break;
				} else if (!device.getName().equals(deviceInput) && !devices.contains(device)) {
					System.out.println("This device doesn't exist!");
					System.out.println("--------------------------");
					System.out.println("Try again!");
					System.out.println();
					break;
				}
			}
		}

		while (pickedCommand == null && pickedDevice != null) {
			System.out.println("Choose one of the following services or write 'back' to return!");
			ArrayList<Command> tempCommands = pickedDevice.showAvailableCommands();
			for (Command tempCommand : tempCommands) {
				System.out.println(tempCommand.getName());
			}
			String commandInput = scanner.nextLine();
			boolean commandFound = false;
			for (Command tempCommand : tempCommands) {
				if (tempCommand.getName().equals(commandInput)) {
					System.out.println("You have chosen " + commandInput);
					pickedCommand = tempCommand;
					commandFound = true;
					pickedCommand.execute();
					pickedCommand = null;
					break;
				}
				if (!commandFound && !tempCommands.contains(tempCommand)) {
					System.out.println("This command doesn't exist!");
					System.out.println("--------------------------");
					System.out.println("Try again!");
					System.out.println();
					break;
				}
			}
		}
	}

}
