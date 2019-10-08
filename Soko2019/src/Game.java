import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;


public class Game {
	private LinkedList<Player> players = new LinkedList <Player>();
	private Board board;
	private int numberOfSquares;
	private Player winner;
	
	
	public Game(String[]playernames, int numberOfSquares){
		for(String s: playernames) {
			Player p = new Player(s);
			players.add(p);
		}
		this.numberOfSquares = numberOfSquares;
		board = new Board(numberOfSquares);
		
	}
	 public void startGame() {
		 for (Player p: players) {
			 board.firstSquare().enter(p);
		 } winner = null;
	 }
	


	


	
	Player currentPlayer(){
		// player not empty, return head (first element)
		assert players.size()>0;
		return players.peek();
		
	}
	
	private boolean notOver() {
		return winner == null;
	}
	
	private void movePlayer(int roll) {
		// player is removed from the head, he plays one round and put to the tail
		Player currentp = players.remove();
		currentp.moveForward(roll);
		players.add(currentp);
		if (currentp.wins()) {
			winner = currentp;
		}
		
	}
	
	void play() {
		Die die = new Die();
		startGame();
		
		System.out.println("State: " + this);
		while (notOver()) {
			int roll = die.roll();
			movePlayer(roll);
			System.out.println("State: " + this);
		}
		System.out.println("Winner: " + winner);
	}
	
}
