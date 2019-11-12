package assignment4;

public class Oven implements ElectronicDevice {

	int temperatur;
	
	@Override
	public void switchOn() {
		System.out.println("Oven is switched ON!");	
	}

	@Override
	public void switchOff() {
		System.out.println("Oven is switched OFF!");	
	}

	@Override
	public void setTemperatur(int temperatur) {
		this.temperatur = temperatur;
		System.out.println("The temperatur is set at " + temperatur);
	}

}
