package assignment4;

public class OvenStartCookingCommand implements Command {
	
	private String name = "StartCooking";
	
	public OvenStartCookingCommand(Oven oven) {
		super();
		this.oven = oven;
	}

	private Oven oven;

	@Override
	public void execute() {
		oven.startCooking();
	}

	@Override
	public String getName() {
		return name;
	}
	
}
