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
			String input = null;
			int[] tempStartField = new int[2];
			int[] tempEndField = new int[2];
			if (Game1.getStatus() == GameStatus.WHITE_TURN){
				b.getBoard();
				System.out.println("It's your turn " + playernames[0] + "! (white player), make your choice?");
				input = in.next();
				while (checkValidityOfInput(input, Game1, b, true) == false){
					//Validity
					input = in.next();
				}
				//Ausführung
				tempStartField = converted(startField);
				System.out.println("You move the figure on position:" + startField);
				
				
				tempEndField = converted(endField);
				System.out.println(endField);
				System.out.println(b.getBox(tempStartField[0], tempStartField[1]).getPiece().canMove(b, b.getBox(tempStartField[0], tempStartField[1]), b.getBox(tempEndField[0], tempEndField[1])));
				
				// TODO: here comes a check if the game is over, if not status is set to Black_Turn
				Game1.setStatus(GameStatus.BLACK_TURN);
			} else if (Game1.getStatus() == GameStatus.BLACK_TURN){
				b.getBoard();
				
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
	static boolean checkValidityOfInput(String input, Game game, Board b, boolean color){
		List<String> validLetters = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
		List<String> validNumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
		
		if (input.length() < 3){
			System.out.println("Not valid input: Too short!");
			return false;
		}
		String endPosition = input.substring(input.length()-2, input.length());
		System.out.println(endPosition + "<- endposition");
		String figure = input.substring(0,1);
		System.out.println(figure + "<- Figure");
		
		
		ArrayList<Field> possibleMoves = b.findInput(figure, color);
		System.out.println(possibleMoves + "before removes");
		
		for (Field f : possibleMoves){
			boolean [][] possibleFields = b.getBox(f.getX(), f.getY()).getPiece().getpossibleDestination(b);
			int tempField[] = converted(endPosition);
			if (possibleFields[tempField[0]][tempField[1]] != true){
				possibleMoves.remove(f);
			};
		}
		System.out.println(possibleMoves + "after removes");
		
		if (possibleMoves.size() == 0) {
			System.out.println("This move is invalid! Please try again!");
		} else if (possibleMoves.size() == 1) {
			System.out.println("This move is possible!");
			return true;
		} else {
			System.out.println("Mulitple possible start position: Be more precise!");
			return false;
		}

		
		//6 cases
		if (input.contains("x")){
			return false;
		}

		return false;
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
