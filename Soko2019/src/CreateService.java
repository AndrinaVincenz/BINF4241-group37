import java.util.ArrayList;
import java.util.Random;

public class CreateService {

	CreateService(int numOfSquares){
		this.numOfSquares = numOfSquares;
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
	
	ArrayList<Ladder> createLadderList(){
		int numberOfLadders = (int)((new Random().nextInt(numOfSquares)+2)/1.5);
		int i = numberOfLadders;
		ArrayList<Ladder> result = new ArrayList<Ladder>();
		while(i > 0){
			int startPosition = createRandomPosition();
			int endPosition = createRandomPosition();
			while (endPosition <= startPosition){
				startPosition = createRandomPosition();
				endPosition = createRandomPosition();
			}
			result.add(new Ladder(startPosition, endPosition));
			i--;
		}
		return result;
	}
	
	ArrayList<Snake> createSnakeList(){
		int numberOfSnakes = (int)((new Random().nextInt(numOfSquares)+2)/1.5);
		int i = numberOfSnakes;
		ArrayList<Snake> result = new ArrayList<Snake>();
		while(i > 0){
			int startPosition = createRandomPosition();
			int endPosition = createRandomPosition();
			while (endPosition >= startPosition){
				startPosition = createRandomPosition();
				endPosition = createRandomPosition();
			}
			result.add(new Snake(startPosition, endPosition));
			i--;
		}
		return result;
	}

	ArrayList<Square> createSquares(){
		int i = 1;
		ArrayList<Square> result = new ArrayList<>();
		result.add(new FirstSquare(i));
		i++;
		while (i < numOfSquares){
			if( i == numOfSquares){
				result.add(new LastSquare(i));
				i++;
			}
			else{
				result.add(new Square(i));
				i++;
			}
		}
		result.add(new LastSquare(i));
		return result;
	}

}
