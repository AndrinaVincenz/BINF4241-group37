package assignment2;

public class Knight extends Piece { 
	  private String name = "N";
	
    public Knight(boolean white) {
    	super(white);
    } 
  
    @Override
    public boolean canMove(Board board, Field start, Field end) 
    { 
        // we can't move the piece to a spot that has 
        // a piece of the same colour 
        if (end.getPiece().isWhite() == this.isWhite()) { 
            return false; 
        } 
  
        int x = Math.abs(start.getX() - end.getX()); 
        int y = Math.abs(start.getY() - end.getY()); 
        return x * y == 2; 
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
		
		int[][] possibledirections =   {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};

		for (int i = 0; i < possibledirections.length; i++) {
			int x = currentfield.getX();
			int y = currentfield.getY();
			x = x + (possibledirections[i][0]);

			y = y + possibledirections[i][1];
			// check if someone is on it!!!!
			if (b.isValid(x, y)) {
				possibleM[x][y] = true;
				if (b.getBox(x,y).getPiece()!= null && b.getBox(x,y).getPiece().isWhite() == this.isWhite()) {
					possibleM[x][y] = false;
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