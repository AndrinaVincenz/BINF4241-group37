package assignment4;

public class Oven {
    private boolean IsOn = false;
    private long timer;
    private int temperature;
    private boolean IsCooking = false;
    private Program Program = null;

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
    public void setProgram(Program Program){
        this.Program = Program;
    }

    //incomplete --> the timer should start here
    public void setCooking(boolean cooking) {
        if(this.timer != 0 && this.temperature != 0 && this.Program != null ) {
            this.IsCooking = cooking;
        }
        else{
            System.out.println("Setup for oven incomplete");
        }
    }
    public void interruptCooking(){
        if (this.IsCooking == true){
            setCooking(false);
        }
        else{
            System.out.println("Oven is not cooking");
        }
    }
}
