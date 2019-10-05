import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);

		int numOfPlayers;
		ArrayList<Player> players = new ArrayList<Player>();
		
		// ask user how many players are intened to play
		System.out.println("How many players wanna play?");
		numOfPlayers = in.nextInt();
		while (numOfPlayers < 2 || numOfPlayers > 4) {
			System.out.println("Amount of players must be between 2 & 4");
			numOfPlayers = in.nextInt();
		}
		System.out.println(numOfPlayers + " Players are playing.");

		// collect the names for the players
		for (int i = 1; i <= numOfPlayers; i++) {
			System.out.println("What's the name of Player " + i);
			players.add(new Player(in.next()));
			System.out.println("The name of Player " + i + " is " + players.get(i - 1).getName());
		}

		int numOfSquares;
		// ask user for numberOfSquares
		System.out.println("How is the size of the board?");
		numOfSquares = in.nextInt();
		System.out.println(numOfSquares);

		ArrayList<Ladder> ladderList = new ArrayList<Ladder>();
		ArrayList<Snake> snakeList = new ArrayList<Snake>();
		ArrayList<Square> squareList = new ArrayList<>();
		CreateService service = new CreateService(numOfSquares);
		
		ladderList = service.createLadderList();
		snakeList = service.createSnakeList();
		squareList = service.createSquares();

		//for(int i= 0; i < players.size(); i++){
		//	squareList.get(0).player += players.get(i);
		//}
		System.out.println(players);

		for (int i=0; i < squareList.size(); i++){
			System.out.println(squareList.get(i).position);
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
		
		Game game = new Game(players, numOfSquares,ladderList, snakeList);
		System.out.print(game);

		
		
		
		// die test
		/*Die die = new Die();
		for (int i = 0; i < 1000; i++){
		System.out.println(die.roll());
		}*/
	
		
		
	}
	
}
