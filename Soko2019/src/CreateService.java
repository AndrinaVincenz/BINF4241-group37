import java.util.ArrayList;
import java.util.Random;

public class CreateService {
	ArrayList<Square> square = new ArrayList<>();
	
	
	public CreateService(int numOfSquares){
		this.numOfSquares = numOfSquares;
		createSquares(numOfSquares);¨
		createLadderList();
		createSnakeList();
	}
	
	int numOfSquares;
	
	int createRandomPosition(){		
		// We don't wanna have a random Number in the List as First or Last Square.
		int position = 0;	
		while (position == 0 || position > numOfSquares - 1){			
			position = new Random().nextInt(numOfSquares);
		}
		return position;
	}
	
	private void createLadderList(){
		int numberOfLadders = (int)((new Random().nextInt(numOfSquares)+2)/1.5);
		int i = numberOfLadders;
		
		while(i > 0){
			int startPosition = createRandomPosition();
			int endPosition = createRandomPosition();
			while (endPosition <= startPosition){
				startPosition = createRandomPosition();
				endPosition = createRandomPosition();
			}
			square.add(new Ladder(startPosition, endPosition));
			i--;
		}
		return
	}
	
	private void createSnakeList(){
		int numberOfSnakes = (int)((new Random().nextInt(numOfSquares)+2)/1.5);
		int i = numberOfSnakes;
		
		while(i > 0){
			int startPosition = createRandomPosition();
			int endPosition = createRandomPosition();
			while (endPosition >= startPosition){
				startPosition = createRandomPosition();
				endPosition = createRandomPosition();
			}
			square.add(new Snake(startPosition, endPosition));
			i--;
		}
	
	}

	private void createSquares(int numOfSquares){
		int i = 0;
		
		square.add(new FirstSquare(i,this));
		i++;
		while (i < numOfSquares){
			if( i == numOfSquares){
				square.add(new LastSquare(i,this));
				i++;
			}
			else{
				square.add(new Square(i,this));
				i++;
			}
		}
		square.add(new LastSquare(i,this));
	
	}
	public Square firstSquare() {
		return square.get(0);
	}


}
