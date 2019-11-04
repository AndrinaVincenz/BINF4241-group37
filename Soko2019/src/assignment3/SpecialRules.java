package assignment3;

public class SpecialRules {
	
	public boolean castlingLong(Game game, Board b, boolean color) {
		if (color == true){
			if (b.getBox(7, 4).getPiece() != null && b.getBox(7, 0).getPiece() != null){
			if (b.getBox(7, 4).getPiece().isFirstMoveDone() == true || b.getBox(7, 0).getPiece().isFirstMoveDone() == true){
				System.out.println("Requirement for castling not met");
				return false;
			}	
			}
			if (b.getBox(7, 1).getPiece() != null || b.getBox(7, 2).getPiece() != null || b.getBox(7, 3).getPiece() != null){
				System.out.println("Figure between King and Rook, castling not allowed!");
				return false;
			} else if (game.getStatus() == GameStatus.WHITE_CHECK){
				System.out.println("King is Check, Castling not allowed!");
			} else {
				//move King
				b.getBox(7, 4).getPiece().Move(b, b.getBox(7, 4),
						b.getBox(7, 2));
				//move Rook
				b.getBox(7, 0).getPiece().Move(b, b.getBox(7, 0),
						b.getBox(7, 3));
				return true;
			}
		} else {
			if (b.getBox(0, 4).getPiece() != null && b.getBox(0, 0).getPiece() != null){
				if (b.getBox(0, 4).getPiece().isFirstMoveDone() == true || b.getBox(0, 0).getPiece().isFirstMoveDone() == true){
					System.out.println("Already moved King or Rook, castling not allowed anymore!");
					return false;
				}	
				}
				if (b.getBox(0, 1).getPiece() != null || b.getBox(0, 2).getPiece() != null || b.getBox(0, 3).getPiece() != null){
					System.out.println("Figure between King and Rook, castling not allowed!");
					return false;
				} else if (game.getStatus() == GameStatus.BLACK_CHECK){
					System.out.println("King is Check, Castling not allowed!");
				} else {
					//move King
					b.getBox(0, 4).getPiece().Move(b, b.getBox(0, 4),
							b.getBox(0, 2));
					//move Rook
					b.getBox(0, 0).getPiece().Move(b, b.getBox(0, 0),
							b.getBox(0, 3));
					return true;
				}
		}
		// should never appear
		return false;		
	}
	

	public boolean castlingShort(Game game, Board b, boolean color) {
		if (color == true){
			if (b.getBox(7, 4).getPiece() != null && b.getBox(7, 7).getPiece() != null){
			if (b.getBox(7, 4).getPiece().isFirstMoveDone() == true || b.getBox(7, 7).getPiece().isFirstMoveDone() == true){
				System.out.println("Already moved King or Rook, castling not allowed anymore!");
				return false;
			}	
			}
			if (b.getBox(7, 5).getPiece() != null || b.getBox(7, 6).getPiece() != null){
				System.out.println("Figure between King and Rook, castling not allowed!");
				return false;
			} else if (game.getStatus() == GameStatus.WHITE_CHECK){
				System.out.println("King is Check, Castling not allowed!");
			} else {
				//move King
				b.getBox(7, 4).getPiece().Move(b, b.getBox(7, 4),
						b.getBox(7, 6));
				//move Rook
				b.getBox(7, 7).getPiece().Move(b, b.getBox(7, 7),
						b.getBox(7, 5));
				return true;
			}
		} else {
			if (b.getBox(0, 4).getPiece() != null && b.getBox(0, 7).getPiece() != null){
				if (b.getBox(0, 4).getPiece().isFirstMoveDone() == true || b.getBox(0, 7).getPiece().isFirstMoveDone() == true){
					System.out.println("Already moved King or Rook, castling not allowed anymore!");
					return false;
				}	
				}
				if (b.getBox(0, 5).getPiece() != null || b.getBox(0, 6).getPiece() != null){
					System.out.println("Figure between King and Rook, castling not allowed!");
					return false;
				} else if (game.getStatus() == GameStatus.BLACK_CHECK){
					System.out.println("King is Check, Castling not allowed!");
				} else {
					//move King
					b.getBox(0, 4).getPiece().Move(b, b.getBox(0, 4),
							b.getBox(0, 6));
					//move Rook
					b.getBox(0, 7).getPiece().Move(b, b.getBox(0, 7),
							b.getBox(0, 5));
					return true;
				}
		}
		// should never appear
		return false;		
	}
	
}
