package assignment4;

public class GetTimerCommand implements Command {
	
	private String name = "GetTimer";
	private Timeable timeableObject;
	
	public GetTimerCommand(Timeable timeableObject){
		this.timeableObject = timeableObject;
	}
	

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
		timeableObject.getTimer();
	}

}
