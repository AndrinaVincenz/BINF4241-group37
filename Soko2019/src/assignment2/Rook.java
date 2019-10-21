package assignment2;

public class Rook extends Piece {
	private String name = "R";

	public Rook(boolean white) {
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
		for (int i = 0; i < 8; i++) {
			if (b.isValid(currentfield.getX(), i)) {
				possibleM[currentfield.getX()][i] = true;
				if (checkIfSameColor(b, currentfield.getX(), i) == 1) {
					possibleM[currentfield.getX()][i] = false;
					break;
				} else if (checkIfSameColor(b, currentfield.getX(), i) == 2) {
					possibleM[currentfield.getX()][i] = true;
					break;
				}
			}
		}
		for (int i = 0; i < 8; i++) {
			if (b.isValid(i, currentfield.getY())) {
				possibleM[i][currentfield.getY()] = true;
				if (checkIfSameColor(b, i, currentfield.getY()) == 1) {
					possibleM[i][currentfield.getY()] = false;
					break;
				} else if (checkIfSameColor(b, i, currentfield.getY()) == 2) {
					possibleM[i][currentfield.getY()] = true;
					break;
				}
			}

		}

		for (int i = 0; i < possibleM.length; ++i) {
			for (int j = 0; j < possibleM[i].length; ++j) {
				System.out.print(possibleM[i][j]);
			}
			System.out.print("\n");
		}
		possibleM[currentfield.getX()][currentfield.getY()] = true;
		return possibleM;

	}
}