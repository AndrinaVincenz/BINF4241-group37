package assignment5_task1;
public class Player {
	Square square;
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	String getName(){
		return name;
	}
	
	public void moveForward(int moves, Board myBoard) {
		square.leave(this);
		/*for (int y = 0; y < square.board.getNumOfSquares(); y++){
			if (square.board.getSquares().get(0).getPlayer().equals(this)){
			square.board.getSquares().get(y).leave(this);
			}
		}*/
		System.out.print(this.name + " rolls :" + moves + " ");
		square = square.moveAndLand(moves, this);
		myBoard.printBoard();
		System.out.println();
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