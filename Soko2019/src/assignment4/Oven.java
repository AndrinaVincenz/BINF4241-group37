package assignment4;

import java.util.ArrayList;

public class Oven extends Device implements Switchable {
	private String name = "Oven";
    private boolean IsOn = false;
    private long timer = 0;
    private int temperature = 0;
    private boolean IsCooking = false;
    private Program program;

    @Override
    public String getName(){
    	return name;
    }
    
    public long getTimer() {
        return timer;
    }

    public void setTemperature(int temperature) {
    	System.out.println("Temperatur is set to " + temperature);
        this.temperature = temperature;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    public void setProgram(Program program){
    	System.out.println("Programm set to " + program.toString());
        this.program = program;
    }
    
    public void switchOff(){
    	System.out.println("Oven is switched OFF!");	
    	IsOn = false;
    }
    
    public void switchOn(){
    	System.out.println("Oven is switched ON!");	
    	IsOn = true;
    }
    
    void startCooking(){
    	if ((temperature > 0) && (timer > 0) && (program != null)){
    		this.IsCooking = true;
    		System.out.println("Start Cooking if true bla bla");
    	} else {
    		System.out.println("Setup for oven incomplete");
    	}
    }
    
    public ArrayList<Command> showAvailableCommands(){
		ArrayList<Command> result = new ArrayList<Command>();
		result.add(new OvenSetTemperaturCommand(this, 0));
		result.add(new OvenSetUpProgrammCommand(this, Program.GLASSES));
		result.add(new SwitchOnCommand(this));
		result.add(new SwitchOffCommand(this));
    	return result;
    }
    
//    public void interruptCooking(){
//        if (this.IsCooking == true){
//            setCooking(false);
//        }
//        else{
//            System.out.println("Oven is not cooking");
//        }
//    }
}
