package assignment4;

import java.util.ArrayList;

public class Dishwasher extends Device implements Switchable, Bootable, Programmable, Interrupitble, Timeable {
	private String name = "DishWasher";

	private boolean IsOn = false;
	private int timer = 0;
	private String program = "None";
	private boolean IsRunning;
	private Thread DishwasherTimerThread;
	private long startTimer;
	@Override
	public void setIsRunning(boolean running) {
		this.IsRunning = running;
	
	}

	@Override
	public String getName() {
		return name;
	}
	
	// Switchable
	@Override
	public void switchOff() {
		System.out.println(name + ": Switched OFF!");
		IsOn = false;
	}

	//Switchable
	@Override
	public void switchOn() {
		System.out.println(name + ": Switched ON!");
		IsOn = true;
	}

	@Override
	public void setProgram(String program) {
		if (getPrograms().contains(program)) {
			System.out.println("Programm chosen: " + program);
			this.program = program;
			if (program.equals("Glasses")) {
				setTimer(10000);
			}
			if (program.equals("Plates")) {
				setTimer(5000);
			}
			if (program.equals("Pans")) {
				setTimer(7000);
			}
			if (program.equals("Mixed")) {
				setTimer(8000);
			}
			if (program.equals("None")) {
				setTimer(0);
			}
			
		} else {
			System.out.println("Program doesn't exist!");
		}
	}
	
	public void setTimer(int timer) {
		this.timer = timer;
		System.out.println("Timer set to: " + timer);
		
	}
	
	public void getTimer() {
		if (IsRunning == true) {
			long currentTime = System.currentTimeMillis();
			long remainingTime = (currentTime - startTimer) / 1000;
			System.out.println("Remaining time: " + remainingTime +"s" );
		} else if (IsOn) {
			System.out.println("Time required: " + timer +"s" );
		} else {
			System.out.println("Dishwascher is not running nor setup" );
		}
		
	}

	@Override
	public ArrayList<String> getPrograms() {
		ArrayList<String> programs = new ArrayList<String>();
		{
			programs.add("Glasses");
			programs.add("Plates");
			programs.add("Pans");
			programs.add("Mixed");
			programs.add("None");
			return programs;
		}
	}

	// Bootable
	@Override
	public void start() {
		if (IsOn && (!program.equals("None")) && IsRunning == false) {
			System.out.println(name + "Started washing");
			System.out.println("Timer:" + timer);
			System.out.println("Program" + program);
			this.IsRunning = true;
			DishwasherTimerThread = new Thread(new DeviceThread(this, "DishwasherTimer", this.timer));
			DishwasherTimerThread.start();
			this.startTimer = System.currentTimeMillis();
		} else {
			System.out.println("Setup for dishwasher incomplete");
			if (!IsOn) {
				System.out.println("Not switched On!");
			}
			if (program.equals("None")) {
				System.out.println("Program must be set!");
			}
			if(IsRunning == true){
				System.out.println("Device still running!");
			}
		}
	}

	public ArrayList<Command> showAvailableCommands() {
		ArrayList<Command> result = new ArrayList<Command>();
		if (IsOn == true) {
			result.add(new StartCommand(this));
			result.add(new SetUpProgrammCommand(this));
			result.add(new GetTimerCommand(this));
			result.add(new InterruptCommand(this));
			result.add(new SwitchOffCommand(this));
		}
		else{
			result.add(new SwitchOnCommand(this));
		}
		return result;
	}

	@Override
	public void interrupt() {
		if(IsRunning == true){
			this.DishwasherTimerThread.interrupt();
			this.IsRunning = false;
			this.startTimer = 0;
		}
		else{
			System.out.println("Dishwasher is not running");
		}
	}
}
