import java.util.ArrayList;
import java.util.Random;

public class Ladder extends Square {
	int transport = 5;
	public Ladder(int position, CreateService b) {
		super(position,b);
	}
	@Override
	public Square landHereOrGoHome() {
		return placeToGo().landHereOrGoHome();
		
	}
	private Square placeToGo() {
		return findrelativeSquare(transport);
	}
	
	
}
