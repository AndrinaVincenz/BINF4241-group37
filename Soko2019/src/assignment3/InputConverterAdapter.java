package assignment3;

public class InputConverterAdapter implements InputConverter{
    @Override
    public int[] converter(String position){
        return Converter.convert(position);
    }
}
