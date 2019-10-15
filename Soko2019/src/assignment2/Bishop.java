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
    @Override
 	public boolean[][] getpossibleDestination(Board b) {
 		boolean[][] possibleM = new boolean[8][8];
 		for (int i = 0; i < possibleM.length; ++i) {
 			for (int j = 0; j < possibleM[i].length; ++j) {
 				possibleM[i][j] = false;
 			}
 		}

 		for (int i = 1; i <= 8; i++) {
 			
 			if (b.isValid(currentfield.getX()+i,currentfield.getY()+i)) {
 				possibleM[currentfield.getX()+i][currentfield.getY()+i] = true;
 				if (b.getBox(currentfield.getX()+i,currentfield.getY()+i).getPiece()!= null && b.getBox(currentfield.getX()+i,currentfield.getY()+i).getPiece().isWhite() == this.isWhite()) {
					possibleM[currentfield.getX()+i][currentfield.getY()+i] = false;
					break;
				}
 			} 
 			if (b.isValid(currentfield.getX()+i,currentfield.getY()-i)) {
 				possibleM[currentfield.getX()+i][currentfield.getY()-i] = true;
 				if (b.getBox(currentfield.getX()+i,currentfield.getY()-i).getPiece()!= null && b.getBox(currentfield.getX()+i,currentfield.getY()-i).getPiece().isWhite() == this.isWhite()) {
					possibleM[currentfield.getX()+i][currentfield.getY()-i] = false;
					break;
				}
 			}
 			if (b.isValid(currentfield.getX()-i,currentfield.getY()+i)) {
 				possibleM[currentfield.getX()-i][currentfield.getY()+i] = true;
 				if (b.getBox(currentfield.getX()-i,currentfield.getY()+i).getPiece()!= null && b.getBox(currentfield.getX()-i,currentfield.getY()+i).getPiece().isWhite() == this.isWhite()) {
					possibleM[currentfield.getX()-i][currentfield.getY()+i] = false;
					break;
				}
 			}
 			if (b.isValid(currentfield.getX()-i,currentfield.getY()-i)) {
 				possibleM[currentfield.getX()-i][currentfield.getY()-i] = true;
 				if (b.getBox(currentfield.getX()-i,currentfield.getY()-i).getPiece()!= null && b.getBox(currentfield.getX()-i,currentfield.getY()-i).getPiece().isWhite() == this.isWhite()) {
					possibleM[currentfield.getX()-i][currentfield.getY()-i] = false;
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