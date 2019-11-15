package assignment4;

public class SwitchOffCommand implements Command {

	Switchable switchable;
	private String name = "SwitchOff";
	
	SwitchOffCommand(Switchable switchable){
		this.switchable = switchable;
	}
	
	@Override
	public void execute() {
		switchable.switchOff();
	}

	@Override
	public String getName() {
		return name;
	}
	
}
