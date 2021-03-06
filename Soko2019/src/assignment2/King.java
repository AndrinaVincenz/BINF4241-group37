package assignment2;

public class King extends Piece {
	private boolean castlingDone = false;
	private String name = "K";

	public King(boolean white) {
		super(white);
	}


	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public boolean[][] getpossibleDestination(Board b) {
		boolean[][] possibleM = new boolean[8][8];
		for (int i = 0; i < possibleM.length; ++i) {
			for (int j = 0; j < possibleM[i].length; ++j) {
				possibleM[i][j] = false;
			}
		}

		int[][] possibledirections = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 },
				{ -1, -1 } };

		for (int i = 0; i < possibledirections.length; i++) {
			int x = currentfield.getX();
			int y = currentfield.getY();
			x = x + (possibledirections[i][0]);

			y = y + possibledirections[i][1];
			
			if (b.isValid(x, y)) {
				possibleM[x][y] = true;
				if (checkIfSameColor(b,x,y) == 1) {
					possibleM[x][y] = false;
				} else if (checkIfSameColor(b,x,y) == 2) {
					possibleM[x][y] = true;
				}
				
			}
		}
		possibleM[currentfield.getX()][currentfield.getY()] = true;
		return possibleM;
	}
}
