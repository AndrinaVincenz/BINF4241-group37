package assignment4;

import java.util.Scanner;

public class OvenSetTemperaturCommand implements Command {

	private String name = "SetTemperatur";
	private Oven oven;
	private int temp;
	
	public OvenSetTemperaturCommand(Oven oven){
		this.oven = oven;
	}
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which temperatur?");
		int tempInput = scanner.nextInt(); 
		oven.setTemperature(tempInput);
	}

	@Override
	public String getName() {
		return name;
	}

}
