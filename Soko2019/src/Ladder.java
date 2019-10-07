import java.util.ArrayList;
import java.util.Random;

public class Ladder extends Square {
	int transport;
	public Ladder(int position, int transport) {
		super(position);
		this.transport = transport;
	}
	@Override
	public Square landHereOrGoHome() {
		return placeToGo().landHereOrGoHome();
		
	}
	private Square placeToGo() {
		return square.findrelativeSquare(transport);
	}
	
	
}
