package assignment4;

public class OvenSetTemperaturCommand implements Command {

	private Oven oven;
	private int temp;
	
	public OvenSetTemperaturCommand(Oven oven, int temp){
		this.oven = oven;
		this.temp = temp;
	}
	
	@Override
	public void execute() {
		oven.setTemperature(temp);
	}

}
