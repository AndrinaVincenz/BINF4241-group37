package assignment1;
import java.util.ArrayList;
import java.util.Random;

import assignment1.Board;
import assignment1.Square;

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
