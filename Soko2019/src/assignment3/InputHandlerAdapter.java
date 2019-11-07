package assignment3;

public class InputHandlerAdapter implements InputHandler{
    @Override
    public int[] converter(String position){
        return InputHandling.convert(position);
    }
}
