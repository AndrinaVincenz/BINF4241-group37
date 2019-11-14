package assignment4;

public class OvenSwitchOnCommand implements Command {

	Oven oven;
	
	OvenSwitchOnCommand(Oven oven){
		this.oven = oven;
	}
	
	@Override
	public void execute() {
		oven.switchOn();
	}

}
