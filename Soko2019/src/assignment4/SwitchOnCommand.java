package assignment4;

public class SwitchOnCommand implements Command {

Switchable switchable;
private String name = "SwitchOn";
	
	SwitchOnCommand(Switchable switchable){
		this.switchable = switchable;
	}
	
	@Override
	public void execute() {
		switchable.switchOn();
	}

	@Override
	public String getName() {
		return name;
	}
}
