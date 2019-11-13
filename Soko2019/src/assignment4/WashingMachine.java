package assignment4;

public class WashingMachine {
    private boolean IsOn = false;
    private long timer;
    private int temperature;
    private  Program Program = null;
    private boolean IsWashing = false;

    public boolean isOn() {
        return IsOn;
    }

    public long getTimer() {
        return timer;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    private void setTimer(long timer) {
        this.timer = timer;
    }

    public void setOn(boolean on) {
        this.IsOn = on;
    }
    public void setProgram(Program newProgram){
        if(newProgram == assignment4.Program.DOUBLE_RINSE){
            this.Program = assignment4.Program.DOUBLE_RINSE;
            this.timer = 120; // give the timer length
        }
        else if(newProgram == assignment4.Program.INTENSE){
            this.Program = assignment4.Program.INTENSE;
            this.timer = 150; // give the timer length
        }
        else if(newProgram == assignment4.Program.QUICK){
            this.Program = assignment4.Program.QUICK;
            this.timer = 180; // give the timer length
        }
        else if(newProgram == assignment4.Program.SPIN){
            this.Program = assignment4.Program.SPIN;
            this.timer = 200; // give the timer length
        }
    }

    //incomplete --> the timer should start here
    public void setWashing(boolean washing) {
        if(this.Program != null && this.temperature != 0) {
            this.IsWashing = washing;
        }
        else{
            System.out.println("Setup for washing machine incomplete");
        }
    }

}
