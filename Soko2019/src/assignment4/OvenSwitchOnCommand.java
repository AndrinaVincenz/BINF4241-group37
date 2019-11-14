package assignment4;

public class SwitchOn implements Command {

	ElectronicDevice theDevice;
	
	SwitchOn(ElectronicDevice newDevice){
		theDevice = newDevice;
	}
	
	@Override
	public void execute() {
		theDevice.switchOn();
	}

}
