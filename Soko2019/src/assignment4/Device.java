package assignment4;

import java.util.ArrayList;

public abstract class Device {
	public void setIsRunning(boolean running){};

	public String getName() {
		return "NameNotDefined";
	}
	
	void setName(String name){}
	
	public ArrayList<Command> showAvailableCommands(){
    	return null;
    }
	
}
