import java.util.ArrayList;
import java.util.Random;

public class CreateService {
	private ArrayList<Square> square = new ArrayList<>();
	private int numOfSquares;
	
	public CreateService(int numOfSquares){
		this.numOfSquares = numOfSquares;
		createSquares(numOfSquares);
		createLadderList();
		createSnakeList();
	}
	
	
	
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
			square.add(new Ladder(startPosition,this));
			i--;
		}
	
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
			square.add(new Snake(startPosition, this));
			i--;
		}
	
	}

	private void createSquares(int numOfSquares){
		int i = 0;
		
		square.add(new FirstSquare(i,this));
		i++;
		while (i < numOfSquares){
			if( i == numOfSquares){
				square.add(new LastSquare(i, this));

				i++;
			}
			else{
				square.add(new Square(i,this));
				i++;
			}
		}
	// square.add(new LastSquare(i,this));
	
	}
	public Square findSquare(int position) {
		return square.get(position);
	
	}
	public Square firstSquare() {
		return square.get(0);
	}
	public Square lastSquare() {
		return square.get(square.size()-1);
	}

	

}
