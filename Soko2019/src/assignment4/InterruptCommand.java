package assignment4;

public class InterruptCommand implements Command {

    private String name = "InterruptTimer";
    private Interrupitble InterrupitbleObject;


    public InterruptCommand (Interrupitble InterrupitbleObject){
        this.InterrupitbleObject = InterrupitbleObject;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void execute() {
        this.InterrupitbleObject.interrupt();
    }
}
