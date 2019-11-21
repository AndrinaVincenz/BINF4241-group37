package assignment4;

public class CheckCleaningCompletionCommand implements Command {
	
	private String name = "CheckCleaningCompletion";
	private Chargeable chargeableObject;
	
	public CheckCleaningCompletionCommand(Chargeable chargeableObject) {
		this.chargeableObject = chargeableObject;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
		chargeableObject.getCleaningCompletion();
	}

}
