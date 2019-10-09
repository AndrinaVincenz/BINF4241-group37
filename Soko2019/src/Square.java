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
			return board.findSquare(newposition);
		} else {
			if (isOccupied(currentposition + roll)) {
				System.out.println("New Position: " + board.firstSquare().getPosition() + " Playername: " + player.getName());
				return board.firstSquare();
			} else {
				int newField2 = currentposition + roll;
				System.out.println("New Position: " + newField2 + " Playername: " + player.getName());
				return board.findSquare(currentposition + roll);
			}
		}
	}
	
	Player getPlayer(){
		return player;
	}
	public Square findrelativeSquare(int move) {
		return board.findSquare(position + move);
	}


}
