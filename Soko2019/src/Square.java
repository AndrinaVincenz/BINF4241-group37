public class Square implements ISquare {

	Player player;
	
	int position;
	
	public Square(int position) {
		this.position = position;
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
	public void enter(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leave(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOccupied() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ISquare moveAndLand(int square) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISquare landHereOrGoHome() {
		// TODO Auto-generated method stub
		return null;
	}
	
	Player getPlayer(){
		return player;
	}

}
