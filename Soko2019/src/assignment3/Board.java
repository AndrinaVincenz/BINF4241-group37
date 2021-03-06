package assignment3;

import java.util.ArrayList;

public class Board { 
		Field[][] boxes = new Field[8][8];
		private Board()
	{
		this.resetBoard();
	}
		private static final Board instance = new Board();
		public static Board getInstance(){return instance;};

		
		public void setBox(int x, int y) {
			
		}

		public Field getBox(int x, int y)
		{ 
			if (x < 0 || x > 7 || y < 0 || y > 7) { 
				return null;
			} 

			return boxes[x][y]; 
		} 
			
		private void resetBoard() {
			
			//Initialization for SuperQueen
			SuperQueen superQueenBlack = new SuperQueen(false);
			SuperQueen superQueenWhite = new SuperQueen(true);
			QueenPiece superQueenAdapterBlack = new SuperQueenAdapter(superQueenBlack, this);
			QueenPiece superQueenAdapterWhite = new SuperQueenAdapter(superQueenWhite, this);
			
			//Initialization for ArchBishop
			ArchBishop archBishopBlack = new ArchBishop(false);
			ArchBishop archBishopWhite = new ArchBishop(true);
			BishopPiece archBishopAdapterBlack = new ArchBishopAdapter(archBishopBlack, this);
			BishopPiece archBishopAdapterWhite = new ArchBishopAdapter(archBishopWhite, this);

			
			// initialize black pieces 
			boxes[0][0] = new Field(0, 0, new Rook(false));
			boxes[0][1] = new Field(0, 1, new Knight(false));
			boxes[0][2] = new Field(0, 2, null /*new Bishop(false)*/);
			boxes[0][3] = new Field(0, 3, new King(false));
			boxes[0][4] = new Field(0, 4, null /*new Queen(false)*/); //Currently playing with SuperQueen
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
		


			// initialize white pieces 
			boxes[7][0] = new Field(7, 0, new Rook(true));
			boxes[7][1] = new Field(7, 1, new Knight(true));
			boxes[7][2] = new Field(7, 2, null /*new Bishop(false)*/);
			boxes[7][3] = new Field(7, 3, null /*new Queen(true)*/); //Currently playing with SuperQueen
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

			//Place Queen for SuperQueenMode!!!
			boxes[0][4].setPiece((Piece)superQueenAdapterBlack);
			boxes[7][3].setPiece((Piece)superQueenAdapterWhite);
			((Piece)superQueenAdapterBlack).setField(this.getBox(0, 4));
			((Piece)superQueenAdapterWhite).setField(this.getBox(7, 3));
			
			//Place Queen for ArchBishopMode!!!
			boxes[0][2].setPiece((Piece)archBishopAdapterBlack);
			boxes[7][2].setPiece((Piece)archBishopAdapterWhite);
			((Piece)archBishopAdapterBlack).setField(this.getBox(0, 2));
			((Piece)archBishopAdapterWhite).setField(this.getBox(7, 2));

			// initialize remaining boxes without any piece 
			for (int i = 2; i < 6; i++) { 
				for (int j = 0; j < 8; j++) { 
					boxes[i][j] = new Field(i, j, null); 
				} 
			} 
			
		}
		

		public void getBoard(){
			int k = 8;
			String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h" };
			for (int i = 0; i < 8; i++) { 
				System.out.print(k + " ");
				k = k-1;
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
						System.out.print("[  ]");
					}
				}
				System.out.print("\n");	
			}  
			System.out.print("   ");
			for (int o = 0; o < 8; o++){
				System.out.print(letters[o]);
				System.out.print("   ");
			}
			System.out.println();
		}
		
		 public boolean isValid(int x, int y) {
			 if (x < 0 || x > 7 || y < 0 || y > 7) { 
					return false;
		} else {
			return true;
		}
	}

	public boolean check(boolean c) {
		boolean color = c;
		int currentKingX = -1;
		int currentKingY = -1;
		boolean check = false;
		// find currentfield King
		for (int i = 0; i < boxes.length; ++i) {
			for (int j = 0; j < boxes[i].length; ++j) {
				if ( boxes[i][j].getPiece()!= null && boxes[i][j].getPiece().getName() == "K" && boxes[i][j].getPiece().isWhite() == color) {
					currentKingX = i;
					currentKingY = j;
				}

			}
		}
		// find possibledest from other color and see if they overlapp
		for (int i = 0; i < boxes.length; ++i) {
			for (int j = 0; j < boxes[i].length; ++j) {
				if (boxes[i][j].getPiece() != null && boxes[i][j].getPiece().isWhite() != c) {
					boolean[][] possibleM = boxes[i][j].getPiece().getpossibleDestination(this);
					if (possibleM[currentKingX][currentKingY]) {
						check = true;
					}
				}

			}
		}
		return check;
	}

	public boolean checkMate(boolean co, Board board) {
		boolean color = co;
		int currentKingX = -1;
		int currentKingY = -1;
		boolean checkmate = true;
		boolean[][] possibleMovesKing = new boolean[8][8];
		
		// find currentfield King
		for (int i = 0; i < boxes.length; ++i) {
			for (int j = 0; j < boxes[i].length; ++j) {
				if (boxes[i][j].getPiece() != null &&boxes[i][j].getPiece().getName() == "K" && boxes[i][j].getPiece().isWhite() == color) {
					currentKingX = i;
					currentKingY = j;
				}

			}
		}
		possibleMovesKing = boxes[currentKingX][currentKingY].getPiece().getpossibleDestination(this);
		// find possibledest from other color and see if they overlapp
		for (int i = 0; i < boxes.length; ++i) {
			for (int j = 0; j < boxes[i].length; ++j) {
				if (boxes[i][j].getPiece() != null && boxes[i][j].getPiece().isWhite() != color) {

					boolean[][] possibleM = boxes[i][j].getPiece().getpossibleDestination(this);

					for (int c = 0; c < boxes.length; ++c) {
						for (int d = 0; d < boxes[c].length; ++d) {
							if (possibleMovesKing[c][d] == true &&  possibleM[c][d] == true) {
								possibleMovesKing[c][d] = false;
							}
						}
					}
				}

			}
		}
		possibleMovesKing [currentKingX][currentKingY] = false;
		for (int i = 0; i < possibleMovesKing.length; ++i) {
			for (int j = 0; j < possibleMovesKing[i].length; ++j) {
				if(possibleMovesKing[i][j] == true) {
					checkmate = false;
				}

			}
		}
		for (int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if (board.getBox(i,j).getPiece() != null && board.getBox(i,j).getPiece().isWhite() == co ){
					boolean[][] figuremovestocheck = new boolean[8][8];
					figuremovestocheck = board.getBox(i,j).getPiece().getpossibleDestination(board);
					for (int c = 0; c < 8; c++){
						for (int d = 0; d < 8; d++){
							if(figuremovestocheck[c][d] == true){
								Piece an = null;
								boolean bc =board.getBox(i,j).getPiece().isFirstMoveDone();
								if(board.getBox(c,d).getPiece() != null){
									an = board.getBox(c,d).getPiece();
								}
								board.getBox(i,j).getPiece().Move(board, board.getBox(i,j), board.getBox(c,d));
								if(board.check(co)!= true){
									checkmate = false;
								}
								if(an != null){
									board.getBox(c,d).getPiece().return_to_old_position(board.getBox(i,j));
									an.return_to_old_position(board.getBox(c,d));
									board.getBox(i,j).getPiece().SetFirstMove(bc);
									an.setKilled(false);
								}
								else {
									board.getBox(c, d).getPiece().return_to_old_position(board.getBox(i, j));
									board.getBox(i,j).getPiece().SetFirstMove(bc);
								}
							}
						}
					}
				}
			}
		}
		return checkmate;
	}
	
	public ArrayList<Field> findInput(String name, Boolean color) {
		
		ArrayList<Field> fieldList = new ArrayList<Field>();

		for (int i = 0; i < boxes.length; ++i) {
			for (int j = 0; j < boxes[i].length; ++j) {
				if(boxes[i][j].getPiece() != null && boxes[i][j].getPiece().getName().equals(name) && boxes[i][j].getPiece().isWhite() == color) {
				
					fieldList.add(boxes[i][j]);
				}
			}
		}
	
		return fieldList;
	}
	
	/**
	 * @param input from the player e. g. "b1"
	 * @return a int[] with 2 values, one for the row and one for the column of the matrix
	 */


}
