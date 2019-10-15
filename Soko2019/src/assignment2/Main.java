package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		//Initialize players, second parameter set the color to white:true/black:false
		Player player1 = new Player(playernames[0], true);
		Player player2 = new Player(playernames[1], false);
		Game Game1 = new Game();
		Game1.initialize(player1, player2);
		
		
		while (Game1.getStatus() != GameStatus.BLACK_WIN || Game1.getStatus() != GameStatus.WHITE_WIN || Game1.getStatus() != GameStatus.STALEMATE){
			String startField = null;
			String endField = null;
			if (Game1.getStatus() == GameStatus.WHITE_TURN){
				b.getBoard();
				System.out.println("It's your turn " + playernames[0] + "! (white player), which figure do you wanna move?");
				startField = in.next();
				while (checkValidityOfInput(startField) == false){
					System.out.print("Invalid input! Try Again!");
					startField = in.next();
				}
				//test print
				System.out.println(startField);
				System.out.println("Move to?");
				endField = in.next();
				while (checkValidityOfInput(endField) == false){
					System.out.print("Invalid input! Try Again!");
					endField = in.next();
				}
				//test print
				System.out.println(endField);
				// move function comes here
				Game1.setStatus(GameStatus.BLACK_TURN);
			} else if (Game1.getStatus() == GameStatus.BLACK_TURN){
				b.getBoard();
				System.out.println("It's your turn " + playernames[1] + "! (black player)");
				startField = in.next();
				while (checkValidityOfInput(startField) == false){
					System.out.print("Invalid input! Try Again!");
					startField = in.next();
				}
				//test print
				System.out.println(startField);
				System.out.println("Move to?");
				endField = in.next();
				while (checkValidityOfInput(endField) == false){
					System.out.print("Invalid input! Try Again!");
					endField = in.next();
				}
				//test print
				System.out.println(endField);
				// move function comes here
				Game1.setStatus(GameStatus.WHITE_TURN);
			}
			
		}
		System.out.println(Game1.getStatus());		
	}	
	
	static boolean checkValidityOfInput(String input){
		List<String> validLetters = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
		List<String> validNumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
		if (input.length() == 2 && (validLetters.contains(input.substring(0, 1)) && validNumbers.contains(input.substring(1, 2)))){
			return true;
		} else {
			return false;
		}
	}
	
	static int[] converted(String input){
		int[] result = new int[2];
		String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h" };
		String[] numbers = { "8", "7", "6", "5", "4", "3", "2", "1" };
		int x = -1;
		int y = -1;
		for (int i = 0; i < letters.length; i++) {
			if (input.substring(0, 1) == letters[i]) {
				x = i;
			}
			if (input.substring(1, 2) == numbers[i]) {
				y = i;
			}
		}
		result[0] = x;
		result[1] = y;
		return result;
	}

}
