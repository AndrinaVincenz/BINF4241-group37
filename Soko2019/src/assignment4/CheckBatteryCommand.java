package assignment4;

public class CheckBatteryCommand implements Command {
	private String name = "CheckBatteryStatus";
	private Chargeable chargeableObject;
	
	public CheckBatteryCommand(Chargeable chargeableObject) {
		this.chargeableObject = chargeableObject;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
		chargeableObject.getBatteryStatus();

	}

}
