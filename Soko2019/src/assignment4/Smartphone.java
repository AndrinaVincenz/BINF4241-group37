package assignment4;

public class Smartphone {

	Command theCommand;
	
	public Smartphone(Command newCommand){
		theCommand = newCommand;
	}
	
	public void press(){
		theCommand.execute();
	}
	
}
