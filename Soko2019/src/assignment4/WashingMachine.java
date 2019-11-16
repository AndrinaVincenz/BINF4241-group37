package assignment4;

import java.util.ArrayList;

public class WashingMachine extends Device implements Switchable, Programmable {
	private String name = "WashingMachine";

	private boolean IsOn = false;
	private long timer = 0;
	private int temperature;
	private String program = null;
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
		result.add(new SwitchOnCommand(this));
		// TODO: select Degrees command
		result.add(new SetUpProgrammCommand(this));
		result.add(new SwitchOffCommand(this));
		return result;
	}

}
