package assignment4;

public class SetTemperatur implements Command {

	ElectronicDevice theDevice;
	
	@Override
	public void execute() {
		theDevice.setTemperatur(180);
	}

}
