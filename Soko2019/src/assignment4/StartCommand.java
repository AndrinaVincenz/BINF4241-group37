package assignment4;

public class StartCommand implements Command{

	Bootable bootable;
	private String name = "Start";
	
	StartCommand(Bootable bootable){
		this.bootable = bootable;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
		bootable.start();
	}

}
