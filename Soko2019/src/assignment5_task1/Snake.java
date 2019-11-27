package assignment5_task1;
import java.util.ArrayList;
import java.util.Random;

public class Snake extends Square {
	
	int endPosition;

	public Snake(int position, int endPosition, Board b){
		super(position,b);
		this.endPosition = endPosition;
	}
		
	
	public int getEndPosition() {
		return endPosition;
	}
	
}
