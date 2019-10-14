package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);

		System.out.println("Welcome to chess!!!");
		// collect the names for the players
		String[] playernames= new String[2];
		for (int i = 0; i < 2; i++) {
		System.out.println("What's the name of Player " + (i+1) + "?");
		playernames[i] = (in.next());
		System.out.println("The name of Player " + (i+1) + " is " + playernames[i] + ".");
		}
		Board b = new Board();
	
		b.getBoard();
	
		
		//Initialize players, second parameter set the color to white:true/black:false
		Player player1 = new Player(playernames[0], true);
		Player player2 = new Player(playernames[1], false);
		Game Game1 = new Game();
		Game1.initialize(player1, player2);
	}	

}
