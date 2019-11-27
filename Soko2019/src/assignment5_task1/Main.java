package assignment5_task1;
import java.util.ArrayList;


import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;
public class Main {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);

		int numOfPlayers;
		
		// ask user how many players are intended to play
		System.out.println("How many players wanna play?");
		numOfPlayers = in.nextInt();
		while (numOfPlayers < 2 || numOfPlayers > 4) {
			System.out.println("Amount of players must be between 2 & 4");
			numOfPlayers = in.nextInt();
		}
		System.out.println(numOfPlayers + " Players are playing.");
		List<String> playernames= new ArrayList<>();
		// collect the names for the players
		for (int i = 0; i < numOfPlayers; i++) {
			System.out.println("What's the name of Player " + (i+1));
			playernames.add(in.next());
			System.out.println("The name of Player " + (i+1) + " is " + playernames.get(i));
		}

		int numOfSquares;
		// ask user for numberOfSquares
		System.out.println("How is the size of the board?");
		numOfSquares = in.nextInt();
		System.out.println(numOfSquares);

		Board board = new Board(numOfSquares);
		
		Game game = new Game(playernames, board);
		
		game.play();	
		
	}
	
}
