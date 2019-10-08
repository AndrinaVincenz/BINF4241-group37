public class Player {
	private Square square;
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	String getName(){
		return name;
	}
	
	public void moveForward(int moves) {
		square.leave(this);
		square = square.moveAndLand(moves);
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
