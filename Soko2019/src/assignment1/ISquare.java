package assignment1;
public interface ISquare {
	
	boolean isFirstSquare();
	
	boolean isLastSquare();
	
	void enter(Player player);
	
	void leave(Player player);
	
	boolean isOccupied(int position);
	
	int getPosition();
	
	ISquare moveAndLand(int square, Player player);
		

}
