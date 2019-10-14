package assignment2;

	public class Board { 
		Field[][] boxes = new Field[8][8]; 

		public Board() 
		{ 
			this.resetBoard(); 
		} 

		public Field getBox(int x, int y) throws Exception 
		{ 
			if (x < 0 || x > 7 || y < 0 || y > 7) { 
				throw new Exception("Index out of bound"); 
			} 

			return boxes[x][y]; 
		} 

		public void resetBoard() {
			// initialize white pieces 
			boxes[0][0] = new Field(0, 0, new Rook(false));
			boxes[0][1] = new Field(0, 1, new Knight(false));
			boxes[0][2] = new Field(0, 2, new Bishop(false));
			boxes[0][3] = new Field(0, 3, new Queen(false));
			boxes[0][4] = new Field(0, 4, new King(false));
			boxes[0][5] = new Field(0, 5, new Bishop(false));
			boxes[0][6] = new Field(0, 6, new Knight(false));
			boxes[0][7] = new Field(0, 7, new Rook(false));
			boxes[1][0] = new Field(1, 0, new Pawn(false));
			boxes[1][1] = new Field(1, 1, new Pawn(false));
			boxes[1][2] = new Field(1, 2, new Pawn(false));
			boxes[1][3] = new Field(1, 3, new Pawn(false));
			boxes[1][4] = new Field(1, 4, new Pawn(false));
			boxes[1][5] = new Field(1, 5, new Pawn(false));
			boxes[1][6] = new Field(1, 6, new Pawn(false));
			boxes[1][7] = new Field(1, 7, new Pawn(false));
			//...


			// initialize black pieces 
			boxes[7][0] = new Field(7, 0, new Rook(true));
			boxes[7][1] = new Field(7, 1, new Knight(true));
			boxes[7][2] = new Field(7, 2, new Bishop(true));
			boxes[7][3] = new Field(7, 3, new Queen(true));
			boxes[7][4] = new Field(7, 4, new King(true));
			boxes[7][5] = new Field(7, 5, new Bishop(true));
			boxes[7][6] = new Field(7, 6, new Knight(true));
			boxes[7][7] = new Field(7, 7, new Rook(true));
			boxes[6][0] = new Field(6, 0, new Pawn(true));
			boxes[6][1] = new Field(6, 1, new Pawn(true));
			boxes[6][2] = new Field(6, 2, new Pawn(true));
			boxes[6][3] = new Field(6, 3, new Pawn(true));
			boxes[6][4] = new Field(6, 4, new Pawn(true));
			boxes[6][5] = new Field(6, 5, new Pawn(true));
			boxes[6][6] = new Field(6, 6, new Pawn(true));
			boxes[6][7] = new Field(6, 7, new Pawn(true));
			//... 

			// initialize remaining boxes without any piece 
			for (int i = 2; i < 6; i++) { 
				for (int j = 0; j < 8; j++) { 
					boxes[i][j] = new Field(i, j, null); 
				} 
			} 
		}

		public void getBoard(){
			for (int i = 0; i < 8; i++) { 
				for (int j = 0; j < 8; j++) { 
					if (boxes[i][j].getPiece() != null) {
						if ((boxes[i][j].getPiece().isWhite())) {
							String c = "W";
							System.out.print("[" + c + boxes[i][j].getPiece().getName() + "]");
						} else {
							String c = "B";
							System.out.print("[" + c + boxes[i][j].getPiece().getName() + "]");
						}
					} else {
						System.out.print("[]");
					}
				} System.out.print("\n");
			} 
		}
		
		 public boolean isValid(int x, int y) {
			 if (x < 0 || x > 7 || y < 0 || y > 7) { 
					return false;
			} else {
				return true;
			}
		 }
	} 
