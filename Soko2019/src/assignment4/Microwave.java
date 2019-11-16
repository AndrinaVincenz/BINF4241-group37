package assignment4;

import java.util.ArrayList;

public class Microwave extends Device implements Switchable {
	private String name = "Microwave";
	private boolean IsOn = false;
    private long timer;
    private int temperature;
    private boolean IsBaking = false;
    
    @Override
    public String getName(){
    	return name;
    }

    public boolean isOn() {
        return IsOn;
    }

    public long getTimer() {
        return timer;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    public void setOn(boolean on) {
        this.IsOn = on;
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

	@Override
	public void switchOff() {
		System.out.println("Microwave is switched OFF!");	
    	IsOn = false;
		
	}

	@Override
	public void switchOn() {
		System.out.println("Microwave is switched ON!");	
    	IsOn = true;
	}
	
    public ArrayList<Command> showAvailableCommands(){
		ArrayList<Command> result = new ArrayList<Command>();
		result.add(new SwitchOnCommand(this));
		result.add(new SwitchOffCommand(this));
    	return result;
    }
}
