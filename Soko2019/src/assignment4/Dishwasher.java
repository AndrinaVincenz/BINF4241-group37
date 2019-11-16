package assignment4;

import java.util.ArrayList;

public class Dishwasher extends Device implements Switchable, Bootable, Programmable {
	private String name = "DishWasher";

	private boolean IsOn = false;
	private long timer = 0;
	private String program = "None";
	private boolean IsWashing = false;

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
			setTimer(program);
		} else {
			System.out.println("Program doesn't exist!");
		}
	}

	private void setTimer(String program) {
		if (program.equals("Glasses")) {
			this.timer = 10000;
		}
		if (program.equals("Plates")) {
			this.timer = 5000;
		}
		if (program.equals("Pans")) {
			this.timer = 7000;
		}
		if (program.equals("Mixed")) {
			this.timer = 8000;
		}
		if (program.equals("None")) {
			this.timer = 0;
		}
		System.out.println("Timer set to: " + timer);
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
		if (IsOn && (!program.equals("None"))) {
			System.out.println(name + "Started washing");
			System.out.println("Timer:" + timer);
			System.out.println("Program" + program);
			this.IsWashing = true;
		} else {
			System.out.println("Setup for dishwasher incomplete");
			if (!IsOn) {
				System.out.println("Not switched On!");
			}
			if (program.equals("None")) {
				System.out.println("Program must be set!");
			}
		}
	}

	public ArrayList<Command> showAvailableCommands() {
		ArrayList<Command> result = new ArrayList<Command>();
		result.add(new SwitchOnCommand(this));
		result.add(new StartCommand(this));
		result.add(new SetUpProgrammCommand(this));
		//TODO: Check timer
		//TODO: Stop Dishwasher
		result.add(new SwitchOffCommand(this));
		return result;
	}

}
