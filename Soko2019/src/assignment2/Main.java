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
			int[] tempStartField = new int[2];
			int[] tempEndField = new int[2];
			if (Game1.getStatus() == GameStatus.WHITE_TURN){
				b.getBoard();
				System.out.println("It's your turn " + playernames[0] + "! (white player), which figure do you wanna move?");
				startField = in.next();
				while (checkValidityOfInput(startField, Game1, b) == false){
					startField = in.next();
				}
				tempStartField = converted(startField);
				System.out.println("You move the figure on position:" + startField);
				
				System.out.println("Move to?");
				endField = in.next();
				while (checkValidityOfInput_moveto(endField, Game1, b) == false){
					endField = in.next();
				}
				tempEndField = converted(endField);
				System.out.println(endField);
				System.out.println(b.getBox(tempStartField[0], tempStartField[1]).getPiece().canMove(b, b.getBox(tempStartField[0], tempStartField[1]), b.getBox(tempEndField[0], tempEndField[1])));
				
				// TODO: here comes a check if the game is over, if not status is set to Black_Turn
				Game1.setStatus(GameStatus.BLACK_TURN);
			} else if (Game1.getStatus() == GameStatus.BLACK_TURN){
				b.getBoard();
				System.out.println("It's your turn " + playernames[1] + "! (black player)");
				startField = in.next();
				while (checkValidityOfInput(startField, Game1, b) == false){
					startField = in.next();
				}
				tempStartField = converted(startField);
				//test print
				System.out.println(startField);
				System.out.println("Move to?");
				endField = in.next();
				while (checkValidityOfInput_moveto(endField, Game1, b) == false){
					endField = in.next();
				}
				tempEndField = converted(endField);
				//test print
				System.out.println(endField);
				b.getBox(tempStartField[0], tempStartField[1]).getPiece().canMove(b, b.getBox(tempStartField[0], tempStartField[1]), b.getBox(tempEndField[0], tempEndField[1]));

				// TODO: here comes a check if the game is over, if not status is set to White_Turn
				Game1.setStatus(GameStatus.WHITE_TURN);
			}
			
		}
		System.out.println(Game1.getStatus());		
	}	
	
	
	/**
	 * @param input from the player e. g. "b1"
	 * @return true if the input is valid, and false if the input is invalid
	 */
	static boolean checkValidityOfInput(String input, Game game, Board b){
		List<String> validLetters = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
		List<String> validNumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
		boolean validString = false;
		boolean validPiece = false;
		if (input.length() == 2 && (validLetters.contains(input.substring(0, 1)) && validNumbers.contains(input.substring(1, 2)))){
			validString = true;
		} else {
		System.out.print("Invalid input! Try Again!");
		return false;
		}
		int tempField[] = converted(input);
		if (GameStatus.WHITE_TURN == game.getStatus()) {
			if (b.getBox(tempField[0], tempField[1]).getPiece() != null && b.getBox(tempField[0], tempField[1]).getPiece().isWhite() == true){
			System.out.println("You did choose: " + b.getBox(tempField[0], tempField[1]).getPiece());
			validPiece = true;
			} else {
			System.out.println("You have to choose a white Piece! Try again!");
			}
		}
		if (GameStatus.BLACK_TURN == game.getStatus()) {
			if (b.getBox(tempField[0], tempField[1]).getPiece() != null && b.getBox(tempField[0], tempField[1]).getPiece().isWhite() == false){
			System.out.println("You did choose: " + b.getBox(tempField[0], tempField[1]).getPiece());
			validPiece = true;
			}
			else {
			System.out.println("You have to choose a black Piece! Try again!");
			}
		}
		return (validString && validPiece);
	}

	static boolean checkValidityOfInput_moveto(String input, Game game, Board b){
		List<String> validLetters = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
		List<String> validNumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
		boolean validString = false;
		boolean validPiece = true;
		if (input.length() == 2 && (validLetters.contains(input.substring(0, 1)) && validNumbers.contains(input.substring(1, 2)))){
			validString = true;
		} else {
			System.out.print("Invalid input! Try Again!");
			return false;
		}
		int tempField[] = converted(input);
		if (GameStatus.WHITE_TURN == game.getStatus() && b.getBox(tempField[0],tempField[1]).getPiece() != null) {
			if (b.getBox(tempField[0], tempField[1]).getPiece().isWhite() == true){
				System.out.println("You have to choose a field with a white Piece! Try again!");
				validPiece = false;
			} else {
				System.out.println("You did choose: " + b.getBox(tempField[0], tempField[1]).getPiece());
			}
		}
		if (GameStatus.BLACK_TURN == game.getStatus() && b.getBox(tempField[0],tempField[1]).getPiece() != null ) {
			if (b.getBox(tempField[0], tempField[1]).getPiece().isWhite() == false){
				System.out.println("You have to choose a field with a black Piece! Try again!");
				validPiece = false;
			}
			else {
				System.out.println("You did choose: " + b.getBox(tempField[0], tempField[1]).getPiece());
			}
		}
		return (validString && validPiece);
	}


	/**
	 * @param input from the player e. g. "b1"
	 * @return a int[] with 2 values, one for the row and one for the column of the matrix
	 */
	static int[] converted(String input){
		int[] result = new int[2];
		String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h" };
		String[] numbers = { "8", "7", "6", "5", "4", "3", "2", "1" };
		int x = -1;
		int y = -1;
		for (int i = 0; i < letters.length; i++) {
			if (input.substring(0, 1).equals(letters[i])) {
				x = i;
			}
			if (input.substring(1, 2).equals(numbers[i])) {
				y = i;
			}
		}
		result[0] = x;
		result[1] = y;
		return result;
	}

}
