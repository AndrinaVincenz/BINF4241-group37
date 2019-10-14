package assignment2;

public class Bishop extends Piece {
	private String name = "B";
	
    public Bishop(boolean white) {
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