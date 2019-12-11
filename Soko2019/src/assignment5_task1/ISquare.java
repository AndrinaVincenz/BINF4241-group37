package assignment5_task1;
public interface ISquare {
	
	boolean isFirstSquare();
	
	boolean isLastSquare();
	
	void enter(Player player);
	
	void leave(Player player);
	
	boolean isOccupied();
	
	int getPosition();
	
	ISquare moveAndLand(int square, Player player);
		

}
