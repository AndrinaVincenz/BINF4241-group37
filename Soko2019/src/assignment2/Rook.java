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
 		possibleM[currentfield.getX()][currentfield.getY()] = true;
 

 		for (int i = 0; i < 8; i++) {
 			// check if someone is on it!!!!
 			if (b.isValid(currentfield.getX(), i)) {
 				possibleM[currentfield.getX()][i] = true;
 			} 
 			if (b.isValid(i, currentfield.getY())) {
 				possibleM[i][currentfield.getY()] = true;
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