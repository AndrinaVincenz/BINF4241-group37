package assignment3;

public class SuperQueenAdapter extends Piece implements QueenPiece {
	SuperQueen superqueen;
	
	private String name;
	
	public SuperQueenAdapter(SuperQueen superqueen, Board board){
		super(superqueen.isWhite());
		this.name = superqueen.getName();
		this.superqueen = superqueen;
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
