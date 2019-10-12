package assignment2;

public class Player {
	boolean whitePlayer;
	String playerName;
	
	Player(String name, boolean whitePlayer){
		this.playerName = name;
		this.whitePlayer = whitePlayer;
	}
	
	public String getName(){
		return this.playerName;
	}
	
}
