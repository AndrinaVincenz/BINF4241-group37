package assignment4;

public class SwitchOff implements Command {

	ElectronicDevice theDevice;
	
	SwitchOff(ElectronicDevice newDevice){
		theDevice = newDevice;
	}
	
	@Override
	public void execute() {
		theDevice.switchOff();
	}
	
}
