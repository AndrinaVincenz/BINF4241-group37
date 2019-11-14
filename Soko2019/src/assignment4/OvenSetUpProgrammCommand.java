package assignment4;

public class OvenSetUpProgrammCommand implements Command {
	
	private Oven oven;
	private Program programmTyp;
	
	public OvenSetUpProgrammCommand(Oven oven, Program programmTyp) {
		this.oven = oven;
		this.programmTyp = programmTyp;
	}

	@Override
	public void execute() {
		oven.setProgram(programmTyp);
	}
	
}
