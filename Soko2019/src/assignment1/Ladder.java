package assignment1;
import java.util.ArrayList;
import java.util.Random;

public class Ladder extends Square {
	int endPosition;
	
	public Ladder(int position, int endPosition, Board b) {
		super(position,b);
		this.endPosition = endPosition;
	}
	
	public int getEndPosition() {
		return endPosition;
	}
	
	
}
