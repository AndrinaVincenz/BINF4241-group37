import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public Game(ArrayList<Player> players, int numberOfSquares, ArrayList<Ladder> ladders, ArrayList<Snake> snakes){
		this.players = players;
		this.numberOfSquares = numberOfSquares;
		this.ladders = ladders;
		this.snakes = snakes;
	}
	
	ArrayList<Player> players;
	
	ArrayList<Square> board;
	
	ArrayList<Ladder> ladders;
	
	ArrayList<Snake> snakes;
	
	int numberOfSquares;
	
	Scanner in = new Scanner(System.in);
	
	Player winner;
	
	void createGame(){
		
	}
	
	Player currentPlayer(){
		return null;
	}
	
	boolean notOver() {
		return false;
	}
	
	void movePlayer(int player) {
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