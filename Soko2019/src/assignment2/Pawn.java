package assignment2;

public class Pawn extends Piece {
	
	private String name = "P";
    
	public Pawn(boolean white) {
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