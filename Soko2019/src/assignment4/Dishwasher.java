package assignment4;

import java.util.ArrayList;

public class Dishwasher extends Device implements Switchable, Bootable {
	private String name = "Dishwasher";

    private boolean IsOn = false; 
    long timer;
    private Program program = null;
    private boolean IsWashing = false;

    public long getTimer() {
        return timer;
    }

    private void setTimer(long timer) {
        this.timer = timer;
    }

//    public void setProgram(Program newProgram){
//        if(newProgram == assignment4.Program.GLASSES){
//            this.program = assignment4.Program.GLASSES;
//            this.timer = 120; // give the timer length
//        }
//        else if(newProgram == assignment4.Program.MIXED){
//            this.program = assignment4.Program.MIXED;
//            this.timer = 150; // give the timer length
//        }
//        else if(newProgram == assignment4.Program.PANS){
//            this.program = assignment4.Program.PANS;
//            this.timer = 180; // give the timer length
//        }
//        else if(newProgram == assignment4.Program.PLATES){
//            this.program = assignment4.Program.MIXED;
//            this.timer = 200; // give the timer length
//        }
//    }

    //incomplete --> the timer should start here
    public void setWashing(boolean washing) {

    }

//    public void interruptWashing(){
//        if (this.IsWashing == true){
//            setWashing(false);
//        }
//        else{
//            System.out.println("Dishwasher is not washing");
//        }
//    }

    //Switchable
    @Override
    public void switchOff(){
    	System.out.println(name + ": Switched OFF!");	
    	IsOn = false;
    }
    
    @Override
    public void switchOn(){
    	System.out.println(name + ": Switched ON!");	
    	IsOn = true;
    }

    //Bootable
	@Override
	public void start() {
        if(IsOn && this.program != null) {
            this.IsWashing = true;
        }
        else{
            System.out.println("Setup for dishwasher incomplete");
            if(!IsOn){
    			System.out.println("Not switched On!");
    		}
    		if(program == null){
    			System.out.println("Program must be set!");
    		}
        }
	}
	
    public ArrayList<Command> showAvailableCommands(){
		ArrayList<Command> result = new ArrayList<Command>();
		result.add(new SwitchOnCommand(this));
		result.add(new StartCommand(this));
		result.add(new SwitchOffCommand(this));
    	return result;
    }
}
