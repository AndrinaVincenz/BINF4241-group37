package assignment2;

public class Player {
	boolean whitePlayer;
	String playerName;
	
	Player(String name, boolean whitePlayer){
		this.playerName = name;
		this.whitePlayer = whitePlayer;
	}
	public boolean isWhiteSide() {
		if (whitePlayer == true) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getName(){
		return this.playerName;
	}
	
}
