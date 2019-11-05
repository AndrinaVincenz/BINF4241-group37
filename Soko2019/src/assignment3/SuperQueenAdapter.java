package assignment3;

public class SuperQueenAdapter extends Piece implements QueenPiece {
	SuperQueen superqueen;
	
	private String name;
	
	public SuperQueenAdapter(SuperQueen superqueen, Board board){
		super(superqueen.isWhite());
		this.name = superqueen.getName();
		this.superqueen = superqueen;
		if (!superqueen.isWhite()){
		this.setField(board.getBox(0, 4));
		} else {
			this.setField(board.getBox(7, 3));
		}
		}
	

    @Override
    public String getName() {
    	return this.name;
    }

	@Override
	public boolean[][] getpossibleDestination(Board b) {
		return superqueen.getpossibleDestinationTeleport(b);
	}
	
	@Override
	public Field getField(){
		return this.currentfield;
	}

}
