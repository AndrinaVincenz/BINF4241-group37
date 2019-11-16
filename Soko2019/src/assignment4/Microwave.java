package assignment4;

import java.util.ArrayList;

public class Microwave extends Device implements Switchable, Heatable, Timeable {
	private String name = "Microwave";
	private boolean IsOn = false;
    private long timer;
    private int temperature;
    private boolean IsBaking = false;
    
    @Override
    public String getName(){
    	return name;
    }

    public long getTimer() {
        return timer;
    }
    
    //Switchable
	@Override
	public void switchOff() {
		System.out.println("Microwave is switched OFF!");	
    	IsOn = false;
		
	}

	//Switchable
	@Override
	public void switchOn() {
		System.out.println("Microwave is switched ON!");	
    	IsOn = true;
	}

    //Heatable
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

    //incomplete --> the timer should start here
    public void setBaking(boolean cooking) {
        if(this.timer != 0 && this.temperature != 0) {
            this.IsBaking = cooking;
        }
        else{
            System.out.println("Setup for microwave incomplete");
        }
    }

    public void interruptBaking(){
        if (this.IsBaking == true){
            setBaking(false);
        }
        else{
            System.out.println("Microwave is not baking");
        }
    }
	
    public ArrayList<Command> showAvailableCommands(){
		ArrayList<Command> result = new ArrayList<Command>();
		result.add(new SwitchOnCommand(this));
		result.add(new SetTimerCommand(this));
		result.add(new SetTemperaturCommand(this));
		result.add(new SwitchOffCommand(this));
    	return result;
    }
}
