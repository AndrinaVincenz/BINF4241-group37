import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;


public class Game {
	private LinkedList<Player> players = new LinkedList <Player>();
	private CreateService board;
	private int numberOfSquares;
	private Player winner;
	
	
	public Game(LinkedList<Player> player, int numberOfSquares){
		this.players = player;
		this.numberOfSquares = numberOfSquares;
		board = new CreateService(numberOfSquares);
		
	}
	 public void startGame() {
		 for (Player p: players) {
			 board.firstSquare().enter(p);
		 }
	 }
	


	

	void createGame(){
		
	}
	
	Player currentPlayer(){
		// player not empty, return head (first element)
		assert players.size()>0;
		return players.peek();
		
	}
	
	boolean notOver() {
		return false;
	}
	
	void movePlayer(int roll) {
		// player is removed from the head
		Player currentp = players.remove();
		
		
	}
	
	void play() {
	}
	
	ISquare findSquare(int square) {
		return null;
	}
	
	ISquare findLastSquare(){
		return null;	
	}
}
