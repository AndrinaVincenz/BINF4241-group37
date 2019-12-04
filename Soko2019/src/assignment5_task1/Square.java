package assignment5_task1;
public class Square implements ISquare {

	private static final String Square = null;
	private Player player;
	protected Board board;
	protected int position;

	private Square square;
	
	
	public Square(int p, Board b) {
		position = p;
		board = b;
	}
	
	Player getPlayer(){
		return player;
	}

	

	@Override
	public boolean isFirstSquare() {
		// return false normally, override at FirstSquare class
		return false;
	}

	
	public boolean isLastSquare() {
		// return false normally, override at LastSquare class
		return false;
	}

	public void enter(Player p) {
		player = p;
		player.setSquare(this);
		
	}

	public void leave(Player player) {
		this.player = null; //forgot keyword this lead to bug!!!
	}


	public boolean isOccupied(int position) {
		if (board.findSquare(position).getPlayer() != null){
		return true;
		} else {
			return false;
		}
		
	}
	
	public int getPosition() {
		return position;
	}


	public Square moveAndLand(int roll, Player player) {
		// it is checked if player is over winning field, if yes how far back he has to go
		int lastsquare = board.lastSquare().getPosition();
		int currentposition = position;
		if (currentposition + roll > lastsquare) {
			int newposition = lastsquare - (currentposition + roll - lastsquare);
			System.out.print("...too high! -> " + newposition + " ");
			//maybe fixed, just return new position if its no ladder or snake???
			return checkForSpecialSquares(newposition);
		} else {
			if (isOccupied(currentposition + roll)) {
				System.out.print("... already Occupied, back to start!");
				return board.firstSquare();
			} else {
				return checkForSpecialSquares(currentposition + roll);
			}
		}
	}
	
	private Square checkForSpecialSquares(int neuePosition){
		if (board.findSquare(neuePosition) instanceof Ladder){
			Ladder tempLadder;
			tempLadder = (Ladder) board.findSquare(neuePosition);
			return board.findSquare(tempLadder.getEndPosition());
		} else if (board.findSquare(neuePosition) instanceof Snake) {
			Snake tempSnake;
			tempSnake = (Snake) board.findSquare(neuePosition);
			return board.findSquare(tempSnake.getEndPosition());
		} else {
			return board.findSquare(neuePosition);
		} 
	}
	
	private Square findrelativeSquare(int move) {
		return board.findSquare(position + move);
	}


}
