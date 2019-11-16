package assignment4;

public class Dishwasher {
    private boolean IsOn = false;
    private long timer;
    private Program Program = null;
    private boolean IsWashing = false;

    public boolean isOn() {
        return IsOn;
    }

    public long getTimer() {
        return timer;
    }

    private void setTimer(long timer) {
        this.timer = timer;
    }

    public void setOn(boolean on) {
        this.IsOn = on;
    }
    public void setProgram(Program newProgram){
        if(newProgram == assignment4.Program.GLASSES){
            this.Program = assignment4.Program.GLASSES;
            this.timer = 120; // give the timer length
        }
        else if(newProgram == assignment4.Program.MIXED){
            this.Program = assignment4.Program.MIXED;
            this.timer = 150; // give the timer length
        }
        else if(newProgram == assignment4.Program.PANS){
            this.Program = assignment4.Program.PANS;
            this.timer = 180; // give the timer length
        }
        else if(newProgram == assignment4.Program.PLATES){
            this.Program = assignment4.Program.MIXED;
            this.timer = 200; // give the timer length
        }
    }

    //incomplete --> the timer should start here
    public void setWashing(boolean washing) {
        if(this.Program != null) {
            this.IsWashing = washing;
        }
        else{
            System.out.println("Setup for dishwasher incomplete");
        }
    }

    public void interruptWashing(){
        if (this.IsWashing == true){
            setWashing(false);
        }
        else{
            System.out.println("Dishwasher is not washing");
        }
    }
}