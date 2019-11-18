package assignment4;

import java.util.ArrayList;

public class WashingMachine extends Device implements Switchable, Programmable, Bootable, Heatable{
	private String name = "WashingMachine";

	private boolean IsOn = false;
	private int timer = 0;
	private int temperature;
	private String program = null;
	private boolean IsRunning = false;
	private Thread WashingMachineTimerThread;

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

	// Programmable
	@Override
	public void setProgram(String program) {
		if (getPrograms().contains(program)) {
			System.out.println("Programm chosen: " + program);
			this.program = program;
			setTimer(program);
		} else {
			System.out.println("Program doesn't exist!");
		}
	}

	// Programmable
	@Override
	public ArrayList<String> getPrograms() {
		ArrayList<String> programs = new ArrayList<String>();
		{
			programs.add("DoubleRinse");
			programs.add("Intense");
			programs.add("Quick");
			programs.add("Spin");
			programs.add("None");
			return programs;
		}
	}

	private void setTimer(String program) {
		if (program.equals("DoubleRinse")) {
			this.timer = 10000;
		}
		if (program.equals("Intense")) {
			this.timer = 5000;
		}
		if (program.equals("Quick")) {
			this.timer = 7000;
		}
		if (program.equals("Spin")) {
			this.timer = 8000;
		}
		if (program.equals("None")) {
			this.timer = 0;
		}
		System.out.println("Timer set to: " + timer);
	}

	@Override
	public ArrayList<Command> showAvailableCommands() {
		ArrayList<Command> result = new ArrayList<Command>();
		if(IsOn == true) {
			result.add(new SetTemperaturCommand(this));
			result.add(new SetUpProgrammCommand(this));
			result.add(new StartCommand(this));
			result.add(new SwitchOffCommand(this));
		}
		else{
			result.add(new SwitchOnCommand(this));
		}
		return result;
	}

	@Override
	public void start() {
		if (IsOn && this.timer != 0 && this.temperature != 0 && this.program != null && IsRunning == false){
			this.IsRunning = true;
			System.out.println(name + ": Start Washing!");
			System.out.println("Temperatur: " + temperature);
			System.out.println("Program: " + this.program);
			System.out.println("Timer: " + timer);

			WashingMachineTimerThread = new Thread(new DeviceThread(this,"MicrowaveTimer", this.timer));
			WashingMachineTimerThread.start();
		} else {
			System.out.println("Setup for microwave incomplete!");
			if (!IsOn) {
				System.out.println("Not switched On!");
			}
			if (!(temperature > 0)) {
				System.out.println("Temperatur not set!");
			}
			if (!(timer > 0)) {
				System.out.println("Timer must be set!");
			}
			if(IsRunning == true){
				System.out.println("Device still running!");
			}
		}
	}

	@Override
	public void setTemperature(int temperature) {
		this.temperature = temperature;
		System.out.println(name + ": Temperatur is set to " + temperature + "!");
	}
}
