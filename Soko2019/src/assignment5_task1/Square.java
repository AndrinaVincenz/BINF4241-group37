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
			//TODO: regading a forum post in OLAT this is not necessary, therefore it needs to be tested before final implementation
		return false;
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
			System.out.println("Player: " + player.getName() + ", current:"+ currentposition + " ...you rolled: "+ roll + " -> ... too high! new: " + newposition);
			return board.findSquare(newposition);
		} else {
			if (isOccupied(currentposition + roll)) {
				System.out.println("Player: " + player.getName() + ", current:"+ currentposition  + " ...you rolled: "+ roll  + "... already Occupied!!! new Position: " + board.firstSquare().getPosition());
				return board.firstSquare();
			} else {
				if (board.findSquare(currentposition + roll) instanceof Ladder){
					Ladder tempLadder;
					tempLadder = (Ladder) board.findSquare(currentposition + roll);
					System.out.println("Player: " + player.getName() + ", current:"+ currentposition + " ...you rolled: "+ roll +"...LADDER!!! new Position: " + tempLadder.getEndPosition());
					return board.findSquare(tempLadder.getEndPosition());
				} else if (board.findSquare(currentposition + roll) instanceof Snake) {
					Snake tempSnake;
					tempSnake = (Snake) board.findSquare(currentposition + roll);
					System.out.println("Player: " + player.getName() + ", current:"+ currentposition + " ...you rolled: "+ roll   + "...SNAKE!!! new Position: " + tempSnake.getEndPosition());
					return board.findSquare(tempSnake.getEndPosition());
				} else {
					int newField2 = currentposition + roll;
					System.out.println("Player: " + player.getName() + ", current:"+ currentposition + " ...you rolled: "+ roll  + " -> " + newField2);
					return board.findSquare(currentposition + roll);
				}
				
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
