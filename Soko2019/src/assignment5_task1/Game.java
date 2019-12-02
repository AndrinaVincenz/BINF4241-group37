package assignment5_task1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;


public class Game {
	private LinkedList<Player> players = new LinkedList <Player>();
	private Board board;
	private int numberOfSquares;
	private Player winner;
	
	
	public Game(List<String>playernames,  Board board){
		for(String s: playernames) {
			Player p = new Player(s);
			numberOfSquares = board.getNumOfSquares();
			players.add(p);
			this.board = board;
		}
		numberOfSquares = board.getNumOfSquares();		
	}
	 public void startGame() {
		 for (Player p: players) {
			 board.firstSquare().enter(p);
		 } 
		 winner = null;
		 System.out.print("Initial state: ");
		 board.printBoard();
		 System.out.println();
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
	
	private void movePlayer(int roll) {
		// player is removed from the head, he plays one round and put to the tail
		Player currentp = players.remove();
		currentp.moveForward(roll, board);
		players.add(currentp);
		if (currentp.wins()) {
			winner = currentp;
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
	
}
