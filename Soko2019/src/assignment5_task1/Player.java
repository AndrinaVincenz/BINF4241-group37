package assignment5_task1;
public class Player {
	Square square;
	private String name;
	Board myBoard;
	
	public Player(String name) {
		this.name = name;
	}
	
	String getName(){
		return name;
	}
	
	public void moveForward(int moves) {
		square.leave(this);
		square = square.moveAndLand(moves, this);
		square.enter(this);
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
