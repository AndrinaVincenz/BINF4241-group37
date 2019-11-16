package assignment4;

import java.util.Scanner;

public class SetTimerCommand implements Command {

	private String name = "SetTimer";
	private Timeable timeableObject;
	private long timer;
	
	public SetTimerCommand(Timeable timeableObject){
		this.timeableObject = timeableObject;
	}
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many seconds?");
		int tempInput = scanner.nextInt(); 
		timeableObject.setTimer(tempInput);
	}

	@Override
	public String getName() {
		return name;
	}

}
