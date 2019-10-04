import java.util.ArrayList;
import java.util.Random;

public class CreateService {

	CreateService(int numOfSquares){
		this.numOfSquares = numOfSquares;
	}
	
	int numOfSquares;
	
	int createRandomLadderStartPosition(){		
		// We don't wanna have a random Number in the List as First or Last Square.
		int startPosition = 0;	
		while (startPosition == 0 || startPosition > numOfSquares-5){			
			startPosition = new Random().nextInt(numOfSquares - 1);
		}
		return startPosition;
	}
	int createRandomLadderEndPosition(){
		int endPosition = 0;
		// We don't wanna have a random tansport below 2 or or at Last Square or higher
		while (endPosition < 2 || endPosition > numOfSquares-1){
			endPosition = numOfSquares + new Random().nextInt(5);
		}
		return endPosition;
	}
	
	ArrayList<Ladder> createLadderList(){
		int numberOfLadders = (int)((new Random().nextInt(numOfSquares)+2)/1.5);
		int i = numberOfLadders;
		ArrayList<Ladder> result = new ArrayList<Ladder>();
		while(i > 0){
			result.add(new Ladder(createRandomLadderStartPosition(), createRandomLadderEndPosition()));
			i--;
		}
		return result;
	}

}
