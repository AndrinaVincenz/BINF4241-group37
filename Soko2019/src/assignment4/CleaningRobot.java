package assignment4;

import java.util.ArrayList;

public class CleaningRobot extends Device implements Timeable {
	private String name = "CleaningRobot";
    
	private long timer = 0;
	
    @Override
    public String getName(){
    	return name;
    }

    //Timeable
    @Override
    public void setTimer(long timer) {
    	this.timer = timer;
    	System.out.println(name + ": Timer is set to " + timer);
    }
	
    @Override
    public ArrayList<Command> showAvailableCommands(){
		ArrayList<Command> result = new ArrayList<Command>();
		result.add(new SetTimerCommand(this));
    	return result;
    }

}
