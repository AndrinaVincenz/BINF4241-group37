import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Board {
	private ArrayList<Square> squaresList = new ArrayList<>();
	private int numOfSquares;
	
	public Board(int numOfSquares){
		this.numOfSquares = numOfSquares;
		squaresList = createBoard();
	}
	
	public int getNumOfSquares(){
		return numOfSquares;
	}
	
	public ArrayList<Square> getSquares(){
		return squaresList;
	}
	
	
	
	int createRandomPosition(){		
		// We don't wanna have a random Number in the List as First or Last Square.
		int position = 0;	
		while (position == 0 || position > numOfSquares - 1){			
			position = new Random().nextInt(numOfSquares);
		}
		return position;
	}
	
	public ArrayList<Square> createLadderList(){
		ArrayList<Square> ladders = new ArrayList<>();
		int numberOfLadders = (int)(numOfSquares*0.20);
		int i = numberOfLadders;
		while(i > 0){
			int startPosition = createRandomPosition();
			int endPosition = createRandomPosition();
			while (endPosition <= startPosition){
				startPosition = createRandomPosition();
				endPosition = createRandomPosition();
			}
			ladders.add(new Ladder(startPosition, endPosition, this));
			i--;
		}
	return ladders;
	}
	
	public ArrayList<Square> createSnakeList(){
		ArrayList<Square> snakes = new ArrayList<>();
		int numberOfSnakes = (int)(numOfSquares*0.20);
		int i = numberOfSnakes;
		while(i > 0){
			int startPosition = createRandomPosition();
			int endPosition = createRandomPosition();
			while (endPosition >= startPosition){
				startPosition = createRandomPosition();
				endPosition = createRandomPosition();
			}
			snakes.add(new Snake(startPosition, endPosition, this));
			i--;
		}
		return snakes;
	}
	
	public ArrayList<Square> mergeLaddersAndSnakes(ArrayList<Square> snakes, ArrayList<Square> ladders){
		ArrayList<Square> result = new ArrayList();
		result.addAll(snakes);
		result.addAll(ladders);
		
		 Collections.sort(result, new Comparator<Square>() {
			    public int compare(Square s1, Square s2) {
			        return s1.getPosition() - (s2.getPosition());
			    }
			});
		 
		 int j = 0;
		 while (j < result.size()-2){
			 if (result.get(j).getPosition() == (result.get(j+1).getPosition())){
				 result.remove(j);
			 }
			 if (result.get(j).getPosition() != result.get(j+1).getPosition()){
				 j++;
			 }			 
		 }
		 if (result.get(result.size()-1).getPosition() == result.get(result.size()-2).getPosition()){
			 result.remove(result.size()-1);
		 }
		return result;
	} 

	public ArrayList<Square> createBoard(){
		ArrayList<Square> snakes = createSnakeList();
		ArrayList<Square> ladders = createLadderList();
		ArrayList<Square> mergedList = mergeLaddersAndSnakes(snakes, ladders);
		ArrayList<Square> result = new ArrayList();
		
		int i = 0;
		result.add(new FirstSquare(1,this));
		i++;
		while (i < numOfSquares-1){
			if (mergedList.size() != 0 && mergedList.get(0).getPosition() == i+1){
				result.add(mergedList.get(0));
				mergedList.remove(0);
			} else {
				result.add(new Square(i+1, this));
			}
			i++;
			}
				result.add(new LastSquare(numOfSquares, this));
				
				for (int z = 0; z < result.size(); z++){
					if (result.get(z) instanceof FirstSquare){
						System.out.println("Position " + result.get(z).getPosition() + " is the First Square.");
						} 
					if (result.get(z) instanceof Ladder){
					System.out.println("Position " + result.get(z).getPosition() + " is a LADDER :D goes up to Position " + (((Ladder) result.get(z)).getEndPosition()));
					} 
					if (result.get(z) instanceof Square && !(result.get(z) instanceof Ladder) && !(result.get(z) instanceof Snake) && !(result.get(z) instanceof FirstSquare) && !(result.get(z) instanceof LastSquare)){
						System.out.println("Position " + result.get(z).getPosition() + " is a normal Square.");
					} 
					if (result.get(z) instanceof Snake){
						System.out.println("Position " + result.get(z).getPosition() + " is a SNAKE!!! goes down to Position " + (((Snake) result.get(z)).getEndPosition()));
					} 
					if (result.get(z) instanceof LastSquare){
						System.out.println("Position " + result.get(z).getPosition() + " is the Last Square.");
						} 
				}
				
				return result;
		}
	
	
	public Square findSquare(int position) {
		return squaresList.get(position);
	
	}
	public Square firstSquare() {
		return squaresList.get(0);
	}
	public Square lastSquare() {
		return squaresList.get(squaresList.size()-1);
	}
	

}
