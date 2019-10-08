public class Player {
	private Square square;
	private String name;
	
	public Player(String name, Square square) {
		this.name = name;
		this.square = square;
	}
	
	String getName(){
		return name;
	}
	
	public void moveForward(int moves) {
		square.leave(this);
		square = square.moveAndLand(moves, this);;
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
