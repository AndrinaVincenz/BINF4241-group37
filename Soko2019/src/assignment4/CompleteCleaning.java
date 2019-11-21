package assignment4;

public class CompleteCleaning implements Command {

	private String name = "CompleteCleaning";
	private Chargeable chargeableObject;
	
	public CompleteCleaning(Chargeable chargeableObject) {
		this.chargeableObject = chargeableObject;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
		chargeableObject.completeCleaning();

	}

}
