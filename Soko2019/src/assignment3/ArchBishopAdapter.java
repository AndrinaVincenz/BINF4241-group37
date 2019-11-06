package assignment3;

public class ArchBishopAdapter extends Piece implements BishopPiece {
	ArchBishop archbishop;
	
	private String name;
	
	public ArchBishopAdapter(ArchBishop archbishop, Board board){
		super(archbishop.isWhite());
		this.name = archbishop.getName();
		this.archbishop = archbishop;
		}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean[][] getpossibleDestination(Board b) {
		return archbishop.getpossibleDestinationGallop(b);
	}

}
