package assignment4;

import java.util.ArrayList;

public class Oven extends Device implements Switchable, Heatable, Timeable, Bootable {
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

    //heatable
    @Override
    public void setTemperature(int temperature) {
    	this.temperature = temperature;
    	System.out.println(name + ": Temperatur is set to " + temperature);
    }

    //Timeable
    @Override
    public void setTimer(long timer) {
    	this.timer = timer;
    	System.out.println(name + ": Timer is set to " + timer);
    }

    //not defined yet
    public void setProgram(Program program){
    	System.out.println(name + ": Programm set to " + program.toString());
        this.program = program;
    }
    
    //bootable
	@Override
	public void start() {
		//TODO: thread things, IsCooking to false after timer goes down to 0
    	if (IsOn && (temperature > 0) && (timer > 0) && (program != null)){
    		this.IsCooking = true;
    		System.out.println(name + ": Start Cooking!");
    		System.out.println("Temperatur:" + temperature);
    		System.out.println("Timer:" + timer);
    		System.out.println("Program" + program);
    		//TODO thread things idk
    	} else {
    		System.out.println("Setup for oven incomplete!");
    		if(!IsOn){
    			System.out.println("Not switched On!");
    		}
    		if(!(temperature > 0)){
    			System.out.println("Temperatur not set!");
    		}
    		if(!(timer > 0)){
    			System.out.println("Timer must be set!");
    		}
    		if(program == null){
    			System.out.println("Program must be set!");
    		}
    	}
	}
    
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
    
    @Override
    public ArrayList<Command> showAvailableCommands(){
		ArrayList<Command> result = new ArrayList<Command>();
		result.add(new SwitchOnCommand(this));
		result.add(new SetTemperaturCommand(this));
		result.add(new SetTimerCommand(this));
		result.add(new OvenSetUpProgrammCommand(this, Program.GLASSES));
		result.add(new StartCommand(this));
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
