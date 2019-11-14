package assignment4;

public class OvenSwitchOffCommand implements Command {

	Oven oven;
	
	OvenSwitchOffCommand(Oven oven){
		this.oven = oven;
	}
	
	@Override
	public void execute() {
		oven.switchOff();
	}
	
}
