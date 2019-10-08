import java.util.ArrayList;
import java.util.Random;

public class Ladder extends Square {
	int transport = 5;
	
	int endPosition;
	
	public Ladder(int position, int endPosition, Board b) {
		super(position,b);
		this.endPosition = endPosition;
	}
	
	@Override
	public Square landHereOrGoHome() {
		return placeToGo().landHereOrGoHome();
		
	}
	private Square placeToGo() {
		return findrelativeSquare(transport);
	}
	
	public int getEndPosition() {
		return endPosition;
	}
	
	
}
