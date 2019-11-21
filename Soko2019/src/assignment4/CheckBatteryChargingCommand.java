package assignment4;

public class CheckBatteryChargingCommand implements Command {

	private String name = "CheckBatteryCharging";
	private Chargeable chargeableObject;
	
	public CheckBatteryChargingCommand(Chargeable chargeableObject) {
		this.chargeableObject = chargeableObject;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
		chargeableObject.getBatteryChargingStatus();

	}

}
