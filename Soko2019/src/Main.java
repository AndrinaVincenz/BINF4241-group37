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
			System.out.println("What's the name of Player " + i);
			playernames.add(in.next());
			System.out.println("The name of Player " + i + " is " + playernames.get(i));
		}

		int numOfSquares;
		// ask user for numberOfSquares
		System.out.println("How is the size of the board?");
		numOfSquares = in.nextInt();
		System.out.println(numOfSquares);

		Board board = new Board(numOfSquares);
		System.out.print("hello");
		Game game = new Game(playernames, numOfSquares);
		

		game.play();
		
		
		// die test
		/*Die die = new Die();
		for (int i = 0; i < 1000; i++){
		System.out.println(die.roll());
		//for(int i= 0; i < players.size(); i++){
		//	squareList.get(0).player += players.get(i);
		//}
		System.out.println(players);
		for (int i=0; i < players.size(); i++){
			System.out.println(players.get(i));
			(players.get(i));
			System.out.println(squareList.get(0).player);
		}

		for (int i=0; i < squareList.size(); i++){
			System.out.println(squareList.get(i).player);
		}
		
		for (int i=0; i < ladderList.size(); i++){
		System.out.println(ladderList.get(i));
		System.out.println(ladderList.get(i).position + " index:" + i + "<-- position");
		System.out.println(ladderList.get(i).transport + " index:" + i +"<-- transport");
		}
		
		for (int i=0; i < snakeList.size(); i++){
			System.out.println(snakeList.get(i));
			System.out.println(snakeList.get(i).position + " index:" + i + "<-- position");
			System.out.println(snakeList.get(i).transport + " index:" + i +"<-- transport");
			}
		}*/
	
		
		
	}
	
}
