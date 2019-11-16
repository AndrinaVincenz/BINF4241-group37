package assignment4;

import java.util.ArrayList;

public class Dishwasher extends Device implements Switchable, Bootable, Programmable {
	private String name = "DishWasher";

    private boolean IsOn = false; 
    private long timer = 0;
    private String program = null;
    private boolean IsWashing = false;
    
    @Override
    public String getName(){
    	return name;
    }

    private void setTimer(String program) {
    	if(program.equals("Glasses")){
    		 this.timer = 10000;
    	}
    	if(program.equals("Plates")){
   		 this.timer = 5000;
    	}
    	if(program.equals("Pans")){
      		 this.timer = 7000;
       	}
    	if(program.equals("Mixed")){
     		 this.timer = 8000;
      	}
    	if(program.equals("None")){
    		 this.timer = 0;
     	}
    	System.out.println("Timer set to: " + timer);
    }

	@Override
	public void setProgram(String program) {
		if (getPrograms().contains(program)){
			System.out.println("Programm chosen: " + program );
			this.program = program;
			setTimer(program);
		} else {
    		System.out.println("Program doesn't exist!");
		}
	}

	@Override
	public ArrayList<String> getPrograms() {
		ArrayList<String> programs = new ArrayList<String>(); {
		programs.add("Glasses");
		programs.add("Plates");
		programs.add("Pans");
		programs.add("Mixed");
		programs.add("None");
		return programs;
	}
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
        	System.out.println(name + "Started washing");
    		System.out.println("Timer:" + timer);
    		System.out.println("Program" + program);
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
		//No setTimerCommand according it is set automatically depending on the program
		result.add(new SwitchOnCommand(this));
		result.add(new StartCommand(this));
		result.add(new SetUpProgrammCommand(this));
		result.add(new SwitchOffCommand(this));
    	return result;
    }

}
