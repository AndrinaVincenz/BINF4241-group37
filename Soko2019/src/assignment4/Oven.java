package assignment4;

import java.util.ArrayList;

public class Oven extends Device implements Switchable, Heatable, Timeable, Bootable, Programmable, Interrupitble{
	private String name = "Oven";

	private boolean IsOn = false;
	private int timer = 0;
	private int temperature = 0;
	private boolean IsRunning = false;
	private String program = "None";
	private Thread OvenTimerThread;


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

	// Switchable
	@Override
	public void switchOn() {
		System.out.println(name + ": Switched ON!");
		IsOn = true;
	}

	// heatable
	@Override
	public void setTemperature(int temperature) {
		this.temperature = temperature;
		System.out.println(name + ": Temperatur is set to " + temperature);
	}

	// Timeable
	@Override
	public void setTimer(int timer) {
		this.timer = timer;
		System.out.println(name + ": Timer is set to " + timer);
	}

	// Programmable
	@Override
	public void setProgram(String program) {
		if (getPrograms().contains(program)) {
			System.out.println("Programm chosen: " + program);
			this.program = program;
		} else {
			System.out.println("Program doesn't exist!");
		}
	}

	// Programmable
	@Override
	public ArrayList<String> getPrograms() {
		ArrayList<String> programs = new ArrayList<String>();
		{
			programs.add("Ventilated");
			programs.add("Grill");
			programs.add("None");
			return programs;
		}
	}

	// bootable
	@Override
	public void start() {
		// TODO: thread things, IsCooking to false after timer goes down to 0
		if (IsOn && (temperature > 0) && (timer > 0) && (!program.equals("None"))&& IsRunning == false) {
			System.out.println(name + ": Start Cooking!");
			System.out.println("Temperature: " + temperature);
			System.out.println("Timer: " + timer);
			System.out.println("Program: " + program);
			this.IsRunning = true;
			OvenTimerThread = new Thread(new DeviceThread(this, "OvenTimer", this.timer));
			OvenTimerThread.start();
		} else {
			System.out.println("Setup for oven incomplete!");
			if (!IsOn) {
				System.out.println("Not switched On!");
			}
			if (!(temperature > 0)) {
				System.out.println("Temperatur not set!");
			}
			if (!(timer > 0)) {
				System.out.println("Timer must be set!");
			}
			if (program.equals("None")) {
				System.out.println("Program must be set!");
			}
			if(IsRunning == true){
				System.out.println("Device still running!");
			}
		}
	}

	@Override
	public ArrayList<Command> showAvailableCommands() {
		ArrayList<Command> result = new ArrayList<Command>();
		if(IsOn == true) {
			result.add(new SetTimerCommand(this));
			result.add(new SetTemperaturCommand(this));
			result.add(new SetUpProgrammCommand(this));
			result.add(new StartCommand(this));
			result.add(new InterruptCommand(this));
			//TODO: Check Timer
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
			this.OvenTimerThread.interrupt();
			this.IsRunning = false;
		}
		else{
			System.out.println("Oven is not cooking");
		}
	}


}
