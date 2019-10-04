import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);

		int numOfSquares;
		int numOfPlayers;
		List<String> nameOfPlayer = new ArrayList<>();
		
		//
		System.out.println("How is the size of the board?");
		numOfSquares = in.nextInt();
		System.out.println(numOfSquares);
	
		System.out.println("How many players wanna play?");
		numOfPlayers = in.nextInt();
		while (numOfPlayers < 2 || numOfPlayers > 4){
			System.out.println("Amount of players must be between 2 & 4");
			numOfPlayers = in.nextInt();
		}
		System.out.println(numOfPlayers + " Players are playing.");
		
		for (int i = 1; i <= numOfPlayers; i++){
		System.out.println("What's the name of Player " + i);
		nameOfPlayer.add(in.next());
		System.out.println("The name of Player " + i +" is " + nameOfPlayer.get(i-1));
		}
	
		
	}
}
