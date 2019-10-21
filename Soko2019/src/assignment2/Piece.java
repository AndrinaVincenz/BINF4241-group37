package assignment2;

public abstract class Piece {
	String name = "";
	private boolean killed = false;
	private boolean white = false;
	protected Field currentfield;

	public Piece(boolean white) {
		this.setWhite(white);

	}

	public boolean isWhite() {
		return this.white == true;
	}

	public void setWhite(boolean white) {
		this.white = white;
	}

	public boolean isKilled() {
		return this.killed == true;
	}

	public void setKilled(boolean killed) {
		this.killed = killed;
	}

	public void setField(Field field) {
		this.currentfield = field;
	}

	public Field getField() {
		return this.currentfield;
	}

	public boolean canMove(Board board, Field start, Field end) {
		boolean[][] posd = this.getpossibleDestination(board);
		int endx = end.getX();
		int endy = end.getY();
		boolean res = false;
		//check if right startfield
		if (this.currentfield == start) {
			// checks if he can land on the field
			if(posd[endx][endy] == true) {
				// checks if he can eat someone 
				if(canEat(board,end)) {
					board.getBox(endx,endy).getPiece().setKilled(true);
					board.getBox(endx,endy).getPiece().setField(null);	
				}
				start.setPiece(null);
				this.currentfield = end;
				board.getBox(endx,endy).setPiece(this);
				res = true;
			}
		}
		return res;
		
	}
	public boolean canEat(Board board, Field end) {
		int endx = end.getX();
		int endy = end.getY();
		if (board.getBox(endx,endy).getPiece() != null && this.isWhite() != board.getBox(endx,endy).getPiece().isWhite()) {
			return true;
		} else {
			return false;
		}
	}

	public String getName() {
		return this.name;
	}

	public boolean[][] getpossibleDestination(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

	public int checkIfSameColor(Board b, int x, int y) {
		int k = 0;
		if (b.getBox(x, y).getPiece() != null && b.getBox(x, y).getPiece().isWhite() == this.isWhite()) {
			k = 1;
		} else if (b.getBox(x, y).getPiece() != null && b.getBox(x, y).getPiece().isWhite() != this.isWhite()) {
			k = 2;
		}
		return k;
	}
}

