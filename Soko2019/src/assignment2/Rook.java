package assignment2;

public class Rook extends Piece {
	private String name = "R";
	
    public Rook(boolean white) {
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