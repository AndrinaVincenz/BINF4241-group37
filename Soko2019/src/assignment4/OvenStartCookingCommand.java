package assignment4;

public class OvenStartCookingCommand implements Command {
	
	public OvenStartCookingCommand(Oven oven) {
		super();
		this.oven = oven;
	}

	private Oven oven;

	@Override
	public void execute() {
		oven.startCooking();
	}
	
}
