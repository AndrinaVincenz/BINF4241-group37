package assignment5_task1;
public class Player {
	Square square;
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void moveForward(int moves, Board myBoard) {
		square.leave(this);
		System.out.print(this.name + " rolls :" + moves + " ");
		square = square.moveAndLand(moves, this);
		square.enter(this);
		myBoard.printBoard();
		System.out.println();
		
	}

	public int position() {
		return square.getPosition();
	}
	
	boolean wins(){
		return square.isLastSquare();
	};
	public Square getSquare() {
		return square;
	}
	public void setSquare(Square s) {
		this.square = s;
	}

}
