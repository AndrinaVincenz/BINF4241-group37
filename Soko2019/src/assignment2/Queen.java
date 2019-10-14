package assignment2;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Field start, Field end) {
        return false;
    }

}