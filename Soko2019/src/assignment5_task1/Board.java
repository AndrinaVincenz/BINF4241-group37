package assignment5_task1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Board {
	private ArrayList<Square> squaresList = new ArrayList<>();
	private int numOfSquares;
	
	public Board(int numOfSquares){
		this.numOfSquares = numOfSquares;
		this.squaresList = createBoard(0.2, 0.2);
	}
	
	public int getNumOfSquares(){
		return numOfSquares;
	}
	
	public ArrayList<Square> getSquares(){
		return squaresList;
	}
	
	
	
	public int createRandomPosition(){		
		// We don't wanna have a random Number in the List as First or Last Square.
		int position = 0;	
		while (position == 0 || position > numOfSquares - 1){			
			position = new Random().nextInt(numOfSquares);
		}
		return position;
	}
	
	/**
	 * @param percentage is how many ladders should be approximately created according to the size of the board
	 * the percentage has to be between 0 to 50%, if below it would be taken 0, if higher it takes 50%.
	 * @return ArrayList<Square> with randomly generated Snakes
	 */
	public ArrayList<Square> createLadderList(double percentage){
		if (percentage > 0.5) {
			percentage = 0.5;
		} else if (percentage < 0){
			percentage = 0;
		}
		ArrayList<Square> ladders = new ArrayList<>();
		int numberOfLadders = (int)(numOfSquares*percentage);
		while(ladders.size() < numberOfLadders){
			int startPosition = createRandomPosition();
			int endPosition = createRandomPosition();
			while (endPosition <= startPosition){
				startPosition = createRandomPosition();
				endPosition = createRandomPosition();
			}
			ladders.add(new Ladder(startPosition, endPosition, this));
		}
	return ladders;
	}
	
	/**
	 * @param percentage is how many snakes should be approximately created according to the size of the board
	 * the percentage has to be between 0 to 50%, if below it would be taken 0, if higher it takes 50%.
	 * @return ArrayList<Square> with randomly generated Snakes
	 */
	public ArrayList<Square> createSnakeList(double percentage){
		if (percentage > 0.5) {
			percentage = 0.5;
		} else if (percentage < 0){
			percentage = 0;
		}
		ArrayList<Square> snakes = new ArrayList<>();
		int numberOfSnakes = (int)(numOfSquares*percentage);
		while(snakes.size() < numberOfSnakes){
			int startPosition = createRandomPosition();
			int endPosition = createRandomPosition();
			while (endPosition >= startPosition){
				startPosition = createRandomPosition();
				endPosition = createRandomPosition();
			}
			if (endPosition > 1){
				snakes.add(new Snake(startPosition, endPosition, this));
			}
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
		if (result.get(0).getPosition() == 1) {
			result.remove(0);
		}
		return result;
	} 

	public ArrayList<Square> createBoard(double percentageLadders, double percentageSnakes){
		ArrayList<Square> snakes = createSnakeList(percentageSnakes);
		ArrayList<Square> ladders = createLadderList(percentageLadders);
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
				return result;
		}
	
	public void printBoard(){
		// 1st Square
		System.out.print("[1");
		for (int y = 0; y < ((FirstSquare)this.getSquares().get(0)).getPlayers().size(); y++){
			if (((FirstSquare)this.getSquares().get(0)).getPlayers().get(y) != null){
			System.out.print("<" + ((FirstSquare)this.getSquares().get(0)).getPlayers().get(y).getName() + ">");
			}
		}
		System.out.print("]");
		//Rest
		for (int i = 2; i < this.getNumOfSquares(); i++){
			String currentPlayer = "";
			if (this.findSquare(i).getPlayer() != null){
				currentPlayer = ("<" + this.findSquare(i).getPlayer().getName() + ">");
			}
			if (this.findSquare(i) instanceof Ladder){
				System.out.print("[" + currentPlayer + ((Ladder)this.findSquare(i)).getPosition() + "->" + ((Ladder)this.findSquare(i)).endPosition  + "]");
			} else if (this.findSquare(i) instanceof Snake){
				System.out.print("[" + currentPlayer + ((Snake)this.findSquare(i)).getPosition() + "->" + ((Snake)this.findSquare(i)).endPosition  + "]");
			} else {
				System.out.print("[" + this.findSquare(i).getPosition() + currentPlayer + "]");
			}
		}
		String currentPlayer = "";
		if (this.findSquare(numOfSquares).getPlayer() != null){
			currentPlayer = ("<" + this.findSquare(numOfSquares).getPlayer().getName() + ">");
		}
		System.out.print("[" + currentPlayer + (this.getNumOfSquares()) + "]");
	}
	
	public Square findSquare(int position) {
		return squaresList.get(position - 1);
	
	}
	
	public Square getFirstSquare() {
		return squaresList.get(0);
	}
	
	public Square getLastSquare() {
		return squaresList.get(squaresList.size()-1);
	}
	

}
