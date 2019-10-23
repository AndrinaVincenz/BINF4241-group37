package assignment2;

public class Pawn extends Piece {

	private String name = "P";
	private boolean firstMove = true;
	private int c = 0;

	public Pawn(boolean white) {
		super(white);
		this.firstMove = true;
		this.c = 0;
	}

	@Override
	public void SetCount(int b) {
		this.c += b;
	}

	@Override
	public int getCount() {
		return this.c;
	}

	@Override
	public void SetFirstMove(boolean b) {
		this.firstMove = b;
	}

	@Override
	public boolean GetFirstMove() {
		return this.firstMove;
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
		possibleM[currentfield.getX()][currentfield.getY()] = true;

		if (!(this.isWhite())) {
			int[][] possibledirections = { { 1, 0 }, { 1, 1 }, { 1, -1 } };

			for (int i = 0; i < possibledirections.length; i++) {
				int x = currentfield.getX() + (possibledirections[i][0]);
				int y = currentfield.getY() + possibledirections[i][1];
				if (b.isValid(x, y)) {
					
					if (i == 0 && b.getBox(x,y).getPiece() == null) {
						possibleM[x][y] = true;
					} else if (i > 0 && b.getBox(x, y).getPiece() != null && checkIfSameColor(b, x, y) == 2) {
						possibleM[x][y] = true;
					} else if (i > 0 && currentfield.getX() == 4) {
						if (b.getBox(x, y).getPiece() == null && b.getBox(x - 1, y).getPiece() instanceof Pawn) {
							if (b.getBox(x - 1, y).getPiece().getCount() == 1) {
								possibleM[x][y] = true;
							}

						}
					}
				}
			}
			if (firstMove) {
				int x = currentfield.getX() + 2;
				int y = currentfield.getY();
				if (b.isValid(x, y)) {
					
					if (b.getBox(x,y).getPiece() == null) {
						possibleM[x][y] = true;
					}
				}

			}

		}
		if (this.isWhite()) {
			int[][] possibledirections = { { -1, 0 }, { -1, -1 }, { -1, 1 } };

			for (int i = 0; i < possibledirections.length; i++) {
			
				int x = currentfield.getX() + (possibledirections[i][0]);
				int y = currentfield.getY() + possibledirections[i][1];

				if (b.isValid(x, y)) {
					
					if (i == 0 && b.getBox(x,y).getPiece() == null) {
						possibleM[x][y] = true;
					} else if (i > 0 && b.getBox(x, y).getPiece() != null && checkIfSameColor(b, x, y) == 2) {
						possibleM[x][y] = true;
						// check if there is en passant possible
					} else if (i > 0 && currentfield.getX() == 3) {
						if (b.getBox(x, y).getPiece() == null && b.getBox(x + 1, y).getPiece() instanceof Pawn) {
							if (b.getBox(x + 1, y).getPiece().getCount() == 1) {
								possibleM[x][y] = true;
							}

						}
					}

				}
			}
			if (firstMove) {
				int x = currentfield.getX() - 2;
				int y = currentfield.getY();
				if (b.isValid(x, y)) {
					
					if (b.getBox(x,y).getPiece() == null) {
						possibleM[x][y] = true;
					}
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

	@Override
	public boolean canEat(Board board, Field end) {
		int endx = end.getX();
		int endy = end.getY();
		if (board.getBox(endx, endy).getPiece() != null
				&& this.isWhite() != board.getBox(endx, endy).getPiece().isWhite()) {
			return true;
		} // ckeck en passant
		else if (this.isWhite() && endx == 2 && board.getBox(endx, endy).getPiece() == null) {
			return true;
		} else if (this.isWhite() == false && endx == 5 && board.getBox(endx, endy).getPiece() == null) {
			return true;
		}
		return false;
	}

	@Override
	public void Eat(Board board, Field end) {
		int endx = end.getX();
		int endy = end.getY();
		if (board.getBox(endx, endy).getPiece() != null
				&& this.isWhite() != board.getBox(endx, endy).getPiece().isWhite()) {
			board.getBox(endx, endy).getPiece().setKilled(true);
			board.getBox(endx, endy).getPiece().setField(null);
			board.getBox(endx, endy).setPiece(null);
		} // kill en passant
		else if (this.isWhite() && endx == 2 && board.getBox(endx, endy).getPiece() == null) {
			board.getBox(endx + 1, endy).getPiece().setKilled(true);
			board.getBox(endx + 1, endy).getPiece().setField(null);
			board.getBox(endx + 1, endy).setPiece(null);
		} else if (this.isWhite() == false && endx == 5 && board.getBox(endx, endy).getPiece() == null) {
			board.getBox(endx - 1, endy).getPiece().setKilled(true);
			board.getBox(endx - 1, endy).getPiece().setField(null);
			board.getBox(endx - 1, endy).setPiece(null);

		}
	}

}