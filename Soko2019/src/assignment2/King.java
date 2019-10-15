package assignment2;

public class King extends Piece {
	private boolean castlingDone = false;
	private String name = "K";

	public King(boolean white) {
		super(white);
	}

	public boolean canMove(Board board, Field start, Field end) {
		// we can't move the piece to a Spot that
		// has a piece of the same color
		if (end.getPiece().isWhite() == this.isWhite()) {
			return false;
		}

		int x = Math.abs(start.getX() - end.getX());
		int y = Math.abs(start.getY() - end.getY());
		if (x + y == 1) {
			// check if this move will not result in the king
			// being attacked if so return true
			return true;
		}
		return false;// not ended yet, return statement only here that we don't get and error
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	
    // Possible moves from King in a Boolean file with Size board, true/false
	@Override
	public boolean[][] getpossibleDestination(Board b) {
		boolean[][] possibleM = new boolean[8][8];
		for (int i = 0; i < possibleM.length; ++i) {
			for (int j = 0; j < possibleM[i].length; ++j) {
				possibleM[i][j] = false;
			}
		}
		possibleM[currentfield.getX()][currentfield.getY()] = true;
		int[][] possibledirections = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 },
				{ -1, -1 } };

		for (int i = 0; i < possibledirections.length; i++) {
			int x = currentfield.getX();
			int y = currentfield.getY();
			x = x + (possibledirections[i][0]);

			y = y + possibledirections[i][1];
			// check if someone is on it!!!!
			if (b.isValid(x, y)) {
				possibleM[x][y] = true;
				if (b.getBox(x,y).getPiece()!= null && b.getBox(x,y).getPiece().isWhite() == this.isWhite()) {
					possibleM[x][y] = false;
				}
				
			}
		}
		

		for (int i = 0; i < possibleM.length; ++i) {
			for (int j = 0; j < possibleM[i].length; ++j) {
				System.out.print(possibleM[i][j]);
			}
			System.out.print("\n");
		}

		return possibleM;
	}
}
