package assignment2;

public class Queen extends Piece {
	private String name = "Q";
	
    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Field start, Field end) {
        return false;
    }
    @Override
    public String getName() {
    	return this.name;
    }
}