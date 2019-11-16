package assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		Device pickedDevice = null;
		Command pickedCommand = null;
		boolean end = false;
		ArrayList<Device> devices = new ArrayList<Device>();
		devices.add(new Oven());
		devices.add(new Microwave());
		devices.add(new CleaningRobot());

		while (!end) {
			while (pickedDevice == null) {
				boolean foundDevice = false;
				System.out.println("Choose one of the following devices:");
				for (Device device : devices) {
					System.out.println(device.getName());
				}
				String deviceInput = scanner.nextLine();
				if (deviceInput.equals("quit")) {
					end = true;
					foundDevice = true;
					break;
				}
				for (Device device : devices) {
					if (device.getName().equals(deviceInput)) {
						System.out.println("You have chosen " + deviceInput);
						foundDevice = true;
						pickedDevice = device;
						break;
					}
				}
				if (!foundDevice) {
					System.out.println("This device doesn't exist!");
					System.out.println("--------------------------");
					System.out.println("Try again!");
					System.out.println();
					break;
				}
			}

			while (pickedCommand == null && pickedDevice != null && !end) {
				boolean commandFound = false;
				System.out.println("Choose one of the following services or write 'back' to return!");
				ArrayList<Command> tempCommands = pickedDevice.showAvailableCommands();
				for (Command tempCommand : tempCommands) {
					System.out.println(tempCommand.getName());
				}
				String commandInput = scanner.nextLine();
				if (commandInput.equals("quit")) {
					end = true;
					break;
				}
				if (commandInput.equals("back")) {
					pickedDevice = null;
					commandFound = true;
				}
				for (Command tempCommand : tempCommands) {
					if (tempCommand.getName().equals(commandInput)) {
						pickedCommand = tempCommand;
						commandFound = true;
						pickedCommand.execute();
						System.out.println();
						pickedCommand = null;
						break;
					}
				}
				if (!commandFound) {
					System.out.println("This command doesn't exist!");
					System.out.println("--------------------------");
					System.out.println("Try again!");
					System.out.println();
					break;
				}
			}
		}
		System.out.print("You left the App!");
		System.exit(0);
	}

}
