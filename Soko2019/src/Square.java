public class Square implements ISquare {

	Player player;
	private CreateService board;
	int position;
	
	public Square(int position, CreateService b) {
		this.position = position;
		board = b;
	}
	

	@Override
	public boolean isFirstSquare() {
		// return false normally, override at FirstSquare class
		return false;
	}

	@Override
	public boolean isLastSquare() {
		// return false normally, override at LastSquare class
		return false;
	}

	@Override
	public void enter(Player p) {
		player = p;
		player.setSquare(this);
		
	}

	@Override
	public void leave(Player player) {
		player = null;
		
	}

	@Override
	public boolean isOccupied() {
		square.getPlayer != null;
	}

	@Override
	public int getPosition() {
		return position;
	}

	@Override
	public Square moveAndLand(int roll) {
		// it is checked if player is over winning field, if yes how far back he has to go
		int lastsquare = board.findlastSquare().getPosition();
		int currentposition = square.getPosition();
		if (currentposition + roll > lastsquare) {
			int newposition = lastsquare - (currentposition + roll - lastsquare);
			return board.findSquare(newposition).landHereOrGoHome();
		}
	}

	@Override
	public Square landHereOrGoHome() {
		// Checks if the position is empty and if so sets player to start
		if (square.isOccupied()) {
			return board.findfirstSquare();
		} else {
			return square;
		}
		
	}
	
	Player getPlayer(){
		return player;
	}
	public Square findrelativeSquare(int move) {
		return board.findSquare(position + moves);
	}

}
