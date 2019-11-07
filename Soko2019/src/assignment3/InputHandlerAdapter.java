package assignment3;

public class InputHandlerAdapter implements InputHandler{
    @Override
    public int[] InputChange(String position){
        return InputHandling.inputhandle(position);
    }
}
