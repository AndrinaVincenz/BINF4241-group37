public interface ISquare {
	
	boolean isFirstSquare();
	
	boolean isLastSquare();
	
	void enter(Player player);
	
	void leave(Player player);
	
	boolean isOccupied();
	
	int getPosition();
	
	ISquare moveAndLand(int square);
	
	ISquare landHereOrGoHome();
	

}