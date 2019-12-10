package assignment5_task1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;


public class Game {
	private LinkedList<Player> players = new LinkedList <Player>();
	private Board board;
	private Player winner;
	private Player currentPlayer;
	
	
	public Game(ArrayList<String> playernames,  Board board){
		for(String s: playernames) {
			Player p = new Player(s);
			players.add(p);
			
		}
		this.board = board;
	}
	
	Player currentPlayer(){
		// player not empty, return head (first element)
		assert players.size()>0;
		return players.peek();
		
	}
	
	public boolean notOver() {
		if (board.lastSquare().getPlayer() != null){
			return true;
		} else { 
			return false;
		}
	}
	
	public void movePlayer(int roll) {
		// player is removed from the head, he plays one round and put to the tail
		currentPlayer = players.remove();
		currentPlayer.moveForward(roll, board);
		players.add(currentPlayer);
		if (currentPlayer.wins()) {
			winner = currentPlayer;
		}
		
	}
	
	void play() {
		Die die = new Die();
		startGame();
		
		while (notOver() == false) {
			int roll = die.roll();
			movePlayer(roll);
		
		}
		System.out.println("Winner: " + winner.getName());
	}
	
	 public void startGame() {
		 for (Player p: players) {
			 board.firstSquare().enter(p);
		 } 
		 this.currentPlayer = players.get(0);
		 this.winner = null;
		 System.out.print("Initial state: ");
		 board.printBoard();
		 System.out.println();
	 }
	
	/**
	 * @return the currentPlayer
	 * --> Used for test purposes only
	 */
	public Player getCurrentPlayer(){
		return this.currentPlayer;
	}
	
}
