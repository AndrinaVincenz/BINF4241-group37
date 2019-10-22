package assignment2;

public class Bishop extends Piece {
	private String name = "B";
	
    public Bishop(boolean white) {
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

 		
 		for (int i = 1; i <= 8; i++) {	
 			if (b.isValid(currentfield.getX()+i,currentfield.getY()+i)) {
 				possibleM[currentfield.getX()+i][currentfield.getY()+i] = true;
 				if (checkIfSameColor(b,currentfield.getX()+i,currentfield.getY()+i) == 1) {
					possibleM[currentfield.getX()+i][currentfield.getY()+i] = false;
					i = 8;
				} else if (checkIfSameColor(b,currentfield.getX()+i,currentfield.getY()+i) == 2) {
					possibleM[currentfield.getX()+i][currentfield.getY()+i] = true;
					i = 8;
				}
 			} 
 		}
 		for (int i = 1; i <= 8; i++) {	
 			if (b.isValid(currentfield.getX()+i,currentfield.getY()-i)) {
 				possibleM[currentfield.getX()+i][currentfield.getY()-i] = true;
 				if (checkIfSameColor(b,currentfield.getX()+i,currentfield.getY()-i) == 1) {
					possibleM[currentfield.getX()+i][currentfield.getY()-i] = false;
					i = 8;
				} else if (checkIfSameColor(b,currentfield.getX()+i,currentfield.getY()-i) == 2) {
					possibleM[currentfield.getX()+i][currentfield.getY()-i] = true;
					i = 8;
				}
 			} 
 		}
 		for (int i = 1; i <= 8; i++) {	
 			if (b.isValid(currentfield.getX()-i,currentfield.getY()+i)) {
 				possibleM[currentfield.getX()-i][currentfield.getY()+i] = true;
 				if (checkIfSameColor(b,currentfield.getX()-i,currentfield.getY()+i) == 1) {
					possibleM[currentfield.getX()-i][currentfield.getY()+i] = false;
					i = 8;
				} else if (checkIfSameColor(b,currentfield.getX()-i,currentfield.getY()+i) == 2) {
					possibleM[currentfield.getX()-i][currentfield.getY()+i] = true;
					i = 8;
				}
 			} 
 		}
		for (int i = 1; i <= 8; i++) {	
 			if (b.isValid(currentfield.getX()-i,currentfield.getY()-i)) {
 				possibleM[currentfield.getX()-i][currentfield.getY()-i] = true;
 				if (checkIfSameColor(b,currentfield.getX()-i,currentfield.getY()-i) == 1) {
					possibleM[currentfield.getX()-i][currentfield.getY()-i] = false;
					i = 8;
				} else if (checkIfSameColor(b,currentfield.getX()-i,currentfield.getY()-i) == 2) {
					possibleM[currentfield.getX()-i][currentfield.getY()-i] = true;
					i = 8;
				}
 			} 
 		}
 
 		possibleM[currentfield.getX()][currentfield.getY()] = true;
 		return possibleM;
 	}

}