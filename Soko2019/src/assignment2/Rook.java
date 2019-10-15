package assignment2;

public class Rook extends Piece {
	private String name = "R";
	
    public Rook(boolean white) {
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
 // Possible moves from King in a Boolean file with Size board, true/false
 	@Override
 	public boolean[][] getpossibleDestination(Board b) {
 		boolean[][] possibleM = new boolean[8][8];
 		for (int i = 0; i < possibleM.length; ++i) {
 			for (int j = 0; j < possibleM[i].length; ++j) {
 				possibleM[i][j] = false;
 			}
 		}
 		
 

 		for (int i = 0; i < 8; i++) {
 			// check if someone is on it!!!!
 			if (b.isValid(currentfield.getX(), i)) {
 				possibleM[currentfield.getX()][i] = true;
 				if (b.getBox(currentfield.getX(),i).getPiece()!= null && b.getBox(currentfield.getX(),i).getPiece().isWhite() == this.isWhite()) {
					possibleM[currentfield.getX()][i] = false;
					break;
				}
 			} 
 			if (b.isValid(i, currentfield.getY())) {
 				if (b.getBox(i, currentfield.getY()).getPiece()!= null && b.getBox(i, currentfield.getY()).getPiece().isWhite() == this.isWhite()) {
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