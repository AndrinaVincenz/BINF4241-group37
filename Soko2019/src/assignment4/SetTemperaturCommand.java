package assignment4;

import java.util.Scanner;

public class SetTemperaturCommand implements Command {

	private String name = "SetTemperatur";
	private Heatable heatbleObject;
	private int temp;
	
	public SetTemperaturCommand(Heatable heatbleObject){
		this.heatbleObject = heatbleObject;
	}
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which temperatur?");
		int tempInput = scanner.nextInt(); 
		heatbleObject.setTemperature(tempInput);
	}

	@Override
	public String getName() {
		return name;
	}

}
