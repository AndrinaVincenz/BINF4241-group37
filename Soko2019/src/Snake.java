import java.util.ArrayList;
import java.util.Random;

public class Snake extends Square {
	int transport = -5;
	
	int endPosition;

	public Snake(int position, int endPosition, Board b){
		super(position,b);
		this.endPosition = endPosition;
	}
		
	private Square placeToGo() {
		return findrelativeSquare(transport);
	}
	
	public int getEndPosition() {
		return endPosition;
	}
	
}
