public class Square implements ISquare {

	private Player player;
	protected Board board;
	protected int position;

	private Square square;
	
	
	public Square(int p, Board b) {
		position = p;
		board = b;
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
		player = null;
		
	}


	public boolean isOccupied() {
		return this.player != null;
	}
	
	public int getPosition() {
		return position;
	}


	public Square moveAndLand(int roll) {
		// it is checked if player is over winning field, if yes how far back he has to go
		int lastsquare = board.lastSquare().getPosition();
		int currentposition = getPosition();
		if (currentposition + roll > lastsquare) {
			int newposition = lastsquare - (currentposition + roll - lastsquare);
			return board.findSquare(newposition).landHereOrGoHome();
		} else {
		return findrelativeSquare(roll).landHereOrGoHome();
	}
	}

	public Square landHereOrGoHome() {
		// Checks if the position is empty and if so sets player to start
		if (isOccupied()) {
			return board.firstSquare();
		} else {
			return square;
		}
		
	}
	
	Player getPlayer(){
		return player;
	}
	public Square findrelativeSquare(int move) {
		return board.findSquare(position + move);
	}

}
