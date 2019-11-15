package assignment4;

public class Smartphone {

	Command theCommand;
	
	
    public void setCommand(Command theCommand) {
        this.theCommand = theCommand;
    }
	
	public void displayPressed(){
		theCommand.execute();
	}
	
	
	
	
	
}
