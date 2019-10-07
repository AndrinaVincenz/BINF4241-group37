public class Player {
	private Square s;
	
	public Player(String name) {
		super();
		this.name = name;
	}

	private String name;
	
	String getName(){
		return name;
	}
	
	public void moveForward(int moves) {
		return 0;
	}

	int position() {
		return 0;
	}
	
	boolean wins(){
		return false;
	};
	public Square getSquare() {
		return sqaure;
	}
	public void setSquare(Square s) {
		this.square = s;
	}
}
