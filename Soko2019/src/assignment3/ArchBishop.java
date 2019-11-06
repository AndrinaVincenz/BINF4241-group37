package assignment3;

public class ArchBishop extends Piece implements ArchBishopPiece {
	private String name = "B";
	
	public ArchBishop(boolean white){
		super(white);
	}
	
	@Override
    public String getName() {
    	return this.name;
    }

	@Override
	public boolean[][] getpossibleDestinationGallop(Board b) {
		boolean[][] possibleM = new boolean[8][8];
   		for (int i = 0; i < possibleM.length; ++i) {
   			for (int j = 0; j < possibleM[i].length; ++j) {
   				possibleM[i][j] = false;
   				if (b.getBox(i, j).getPiece() instanceof ArchBishopAdapter){
   					if (b.getBox(i, j).getPiece().isWhite() && this.isWhite()){
   						this.currentfield =  b.getBox(i, j).getPiece().getField();
   					} else if (!b.getBox(i, j).getPiece().isWhite() && !this.isWhite()){
   						this.currentfield =  b.getBox(i, j).getPiece().getField();
   					}
   				}
   			}
   		}
   		//Standard moves for Bishop
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
		
		//moves for Knight
		int[][] possibledirections =   {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};

		for (int i = 0; i < possibledirections.length; i++) {
			int x = currentfield.getX();
			int y = currentfield.getY();
			x = x + (possibledirections[i][0]);

			y = y + possibledirections[i][1];
			
			if (b.isValid(x, y)) {
				possibleM[x][y] = true;
				if (checkIfSameColor(b,x,y) == 1) {
					possibleM[x][y] = false;
				} else if (checkIfSameColor(b,x,y) == 2) {
					possibleM[x][y] = true;
				}
				
			}
		}
   		
   		possibleM[currentfield.getX()][currentfield.getY()] = true;
   		return possibleM;
	}
	
	
}
