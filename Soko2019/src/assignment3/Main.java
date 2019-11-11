package assignment3;

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
		Board b =  Board.getInstance();
		
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
			System.out.println(Game1.getStatus());
			if (Game1.getStatus() == GameStatus.WHITE_TURN){
				b.getBoard();
				System.out.println("It's your turn " + playernames[0] + "! (white player), make your choice?");
				input = in.next();
				while (checkValidityOfInput(input, Game1, b, true) == false){
					//Validity
					input = in.next();
				}
				System.out.println("You did your move");
				if(b.checkMate(false, b) == true){
					Game1.setStatus(GameStatus.WHITE_WIN);
				}
				if (b.check(false) == true) {
					Game1.setStatus(GameStatus.BLACK_CHECK);
				} else {
					Game1.setStatus(GameStatus.BLACK_TURN);
				}
			} else if (Game1.getStatus() == GameStatus.BLACK_TURN){
				b.getBoard();
				System.out.println("It's your turn " + playernames[1] + "! (black player), make your choice?");
				input = in.next();
				while (checkValidityOfInput(input, Game1, b, false) == false){
					//Validity
					input = in.next();
				}
				System.out.println("You did your move");
				if(b.checkMate(true, b) == true){
					Game1.setStatus(GameStatus.BLACK_WIN);
				}
				if (b.check(true) == true) {
					Game1.setStatus(GameStatus.WHITE_CHECK);
				} else {
					Game1.setStatus(GameStatus.WHITE_TURN);
				}
			}
			else if (Game1.getStatus() == GameStatus.WHITE_CHECK) {
				b.getBoard();
				System.out.println("It's your turn " + playernames[0] + ",you are checked! (white player), make your choice?");
				input = in.next();
				while (checkValidityOfInput(input, Game1, b, true) == false) {
					//Validity
					input = in.next();
				}
				System.out.println("You did your move");
				if(b.checkMate(false, b) == true){
					Game1.setStatus(GameStatus.WHITE_WIN);
				}
				if (b.check(false) == true) {
					Game1.setStatus(GameStatus.BLACK_CHECK);
				} else {
					Game1.setStatus(GameStatus.BLACK_TURN);
				}
			}
			else if (Game1.getStatus() == GameStatus.BLACK_CHECK) {
				b.getBoard();
				System.out.println("It's your turn " + playernames[1] + ",you are checked! (black player), make your choice?");
				input = in.next();
				while (checkValidityOfInput(input, Game1, b, false) == false) {
					//Validity
					input = in.next();
				}
				System.out.println("You did your move");
				if(b.checkMate(true, b) == true){
					Game1.setStatus(GameStatus.BLACK_WIN);
				}
				if (b.check(true) == true) {
					Game1.setStatus(GameStatus.WHITE_CHECK);
				} else {
					Game1.setStatus(GameStatus.WHITE_TURN);
				}
			}
		}
		System.out.println(Game1.getStatus());		
	}	
	
	
	/**
	 * @param input from the player e. g. "b1"
	 * @return true if the input is valid, and false if the input is invalid
	 */
	static boolean checkValidityOfInput(String input, Game game, Board b, boolean color) {
		List<String> validLetters = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
		List<String> validNumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
		SpecialRules castling = new SpecialRules();
		Promotion promo = new Promotion();
		
		if (input.equals("0-0-0")){
			if (castling.castlingLong(game, b, color)){
				System.out.println("Long castle!");
				//execute move
				return true;
			} else {
				System.out.println("Long-Castling not possible! Invalid move!");
				return false;
			}
			
		}
		
		if (input.equals("0-0")){
			if (castling.castlingShort(game, b, color)){
				System.out.println("Short castle!");
				//execute move
				
				return true;
			} else {
				System.out.println("Shot-Castling not possible! Invalid move!");
				return false;
			}
		}
		
		String s = input.substring(0, 1);
		if (!isUpper(s)){
			input = "P" + input;
		}
		
		if (input.contains("=")){
			if (input.length() != 5) {
				System.out.println("Invalid input for a promotion! See readme file for help.");
				return false;
			}
			if (promo.tryPromotion(input, game, b, color)){
				System.out.println("Promotion successful!");
				return true;
			} else {
				System.out.println("Promotion didn't work! Try other move!");
				return false;
			}
		}
		
		if (input.length() < 3) {
			System.out.println("Not valid input: Too short!");
			return false;
		}
		String endPosition = input.substring(input.length() - 2, input.length());
		//System.out.println(endPosition + "<- endposition");
		String figure = input.substring(0, 1);
		//System.out.println(figure + "<- Figure");
		int tempEndField[] = Converter.convert(endPosition);

		ArrayList<Field> possibleMovesStartPosition = b.findInput(figure, color);
		ArrayList<Field> tempCopy = new ArrayList<Field>();
		tempCopy.addAll(possibleMovesStartPosition);
		//System.out.println(possibleMovesStartPosition + "before removes");

		// search for possibleMoves

		for (int i = 0; i < possibleMovesStartPosition.size(); i++) {
			boolean[][] possibleFields = b
					.getBox(possibleMovesStartPosition.get(i).getX(), possibleMovesStartPosition.get(i).getY())
					.getPiece().getpossibleDestination(b);
			if (!possibleFields[tempEndField[0]][tempEndField[1]]) {
				tempCopy.remove(possibleMovesStartPosition.get(i));
			}
			;
		}
		possibleMovesStartPosition = tempCopy;
		//System.out.println(possibleMovesStartPosition + " after removes with 3 values");

		// take additional information if input.length is equal 4
		if (!input.contains("x") && input.length() == 4) {
			for (int i = 0; i < possibleMovesStartPosition.size(); i++) {
				if (possibleMovesStartPosition.get(i).getY() != (converted(input.charAt(1) + "q")[1])) {
					tempCopy.remove(i);
				}
			}
			possibleMovesStartPosition = tempCopy;
			//System.out.println(possibleMovesStartPosition + "after removes with 4 values");
		}

		// take additional information if input.length is equal 5
		if (!input.contains("x") && input.length() == 5) {
			for (int i = 0; i < possibleMovesStartPosition.size(); i++) {
				if ((possibleMovesStartPosition.get(i).getY() != (converted(input.charAt(1) + "q")[1]))
						|| (possibleMovesStartPosition.get(i).getX() != (converted("q" + input.charAt(2))[0]))) {
					tempCopy.remove(i);
				}
			}
			possibleMovesStartPosition = tempCopy;
			//System.out.println(possibleMovesStartPosition + "after removes with 5 values");
		}

		// take additional information if input.length is equal 5 and contains x
		if (input.contains("x") && input.length() == 5) {
			for (int i = 0; i < possibleMovesStartPosition.size(); i++) {
				if (possibleMovesStartPosition.get(i).getY() != (converted(input.charAt(1) + "q")[1])) {
					tempCopy.remove(i);
				}
			}
			possibleMovesStartPosition = tempCopy;
			//System.out.println(possibleMovesStartPosition + "after removes with 5 values (contains x)");
		}

		// take additional information if input.length is equal 6 and contains x
		if (input.contains("x") && input.length() == 6) {
			for (int i = 0; i < possibleMovesStartPosition.size(); i++) {
				if ((possibleMovesStartPosition.get(i).getY() != (converted(input.charAt(1) + "q")[1]))
						|| (possibleMovesStartPosition.get(i).getX() != (converted("q" + input.charAt(2))[0]))) {
					tempCopy.remove(i);
				}
			}
			possibleMovesStartPosition = tempCopy;
			//System.out.println(possibleMovesStartPosition + "after removes with 6 values (contains x");
		}

		if (possibleMovesStartPosition.size() == 0) {
			System.out.println("This move is invalid! Please try again!");
		} else if (possibleMovesStartPosition.size() == 1 && !input.contains("x")) {
			if (b.getBox(tempEndField[0], tempEndField[1]).getPiece() != null) {
				System.out.println("Occupied, if you wanna eat, insert a 'x'!");
				return false;
			} else if (b.getBox(tempEndField[0], tempEndField[1]).getPiece() == null
					&& possibleMovesStartPosition.get(0).getPiece() instanceof Pawn
					&& possibleMovesStartPosition.get(0).getPiece().getField().getY() != tempEndField[1]) {
				System.out.println("En passant, if you wanna eat, insert a 'x'!");
				return false;
			} else {

				System.out.println("This move is possible!");
				boolean isFirstM = possibleMovesStartPosition.get(0).getPiece().getIsFirstMoveDone();
				Piece MoveP = possibleMovesStartPosition.get(0).getPiece();
				MoveP.Move(b, possibleMovesStartPosition.get(0),
						b.getBox(tempEndField[0], tempEndField[1]));
				if(b.check(MoveP.isWhite())) {
					System.out.println("Your King is beeing checked, you cant move!");
					MoveP.Move(b, b.getBox(tempEndField[0], tempEndField[1]),possibleMovesStartPosition.get(0));
					MoveP.setIsFirstMoveDone(isFirstM);
					if (MoveP instanceof Pawn) {
						if (MoveP.getCount() < 3){
							MoveP.SetCount(-possibleMovesStartPosition.get(0).getPiece().getCount());
							MoveP.SetFirstMove(true);
						}
					}
					
					
					return false;
				}
				return true;
			}
		} else if (possibleMovesStartPosition.size() == 1 && input.contains("x")) {
			if (b.getBox(tempEndField[0], tempEndField[1]).getPiece() == null
					&& possibleMovesStartPosition.get(0).getPiece() instanceof Pawn
					&& possibleMovesStartPosition.get(0).getPiece().getField().getY() != tempEndField[1]) {
				System.out.println("This move is possible!");
				boolean isFirstM = possibleMovesStartPosition.get(0).getPiece().getIsFirstMoveDone();
				Piece Piecedead = b.getBox(tempEndField[0], tempEndField[1]).getPiece();
				Piece MoveP = possibleMovesStartPosition.get(0).getPiece();
				possibleMovesStartPosition.get(0).getPiece().Eat(b,
						b.getBox(tempEndField[0], tempEndField[1]));
				possibleMovesStartPosition.get(0).getPiece().Move(b, possibleMovesStartPosition.get(0),
						b.getBox(tempEndField[0], tempEndField[1]));
				
				if(b.check(MoveP.isWhite())) {
					System.out.println("Your King is beeing checked, you cant move!");
					MoveP.Move(b, b.getBox(tempEndField[0], tempEndField[1]),possibleMovesStartPosition.get(0));
					MoveP.setIsFirstMoveDone(isFirstM);
					
					if (MoveP.getCount() < 3) {
						MoveP.SetCount(-possibleMovesStartPosition.get(0).getPiece().getCount());
						MoveP.SetFirstMove(true);
					}
					
					Piecedead.setField(b.getBox(tempEndField[0], tempEndField[1]));
					b.getBox(tempEndField[0], tempEndField[1]).setPiece(Piecedead);
					Piecedead.setKilled(false);					
					return false;
				}
				
				
				
				
				return true;

			} else if (b.getBox(tempEndField[0], tempEndField[1]).getPiece() == null
					|| b.getBox(tempEndField[0], tempEndField[1]).getPiece().isWhite() == color) {
				System.out.println("Can't eat on that position! Please try again!");
				return false;
			}

			else {
				System.out.println("This move is possible!");
				boolean isFirstM = possibleMovesStartPosition.get(0).getPiece().getIsFirstMoveDone();
				Piece Piecedead = b.getBox(tempEndField[0], tempEndField[1]).getPiece();
				Piece MoveP = possibleMovesStartPosition.get(0).getPiece();
				/*possibleMovesStartPosition.get(0).getPiece().Eat(b,
						b.getBox(tempEndField[0], tempEndField[1]));*/
				possibleMovesStartPosition.get(0).getPiece().Move(b, possibleMovesStartPosition.get(0),
						b.getBox(tempEndField[0], tempEndField[1]));
				if(b.check(MoveP.isWhite())) {
					System.out.println("Your King is beeing checked, you cant move!");
					MoveP.Move(b, b.getBox(tempEndField[0], tempEndField[1]),possibleMovesStartPosition.get(0));
					MoveP.setIsFirstMoveDone(isFirstM);
					if (MoveP instanceof Pawn) {
						if (MoveP.getCount() < 3){
							MoveP.SetCount(-possibleMovesStartPosition.get(0).getPiece().getCount());
							MoveP.SetFirstMove(true);
						}
					}
					Piecedead.setField(b.getBox(tempEndField[0], tempEndField[1]));
					b.getBox(tempEndField[0], tempEndField[1]).setPiece(Piecedead);
					Piecedead.setKilled(false);					
					return false;
				}
				return true;
			}
		} else if (possibleMovesStartPosition.size() > 1) {
			if (input.length() == 3) {
				System.out.println("Mulitple possible start position: Be more precise!");
				return false;
			}
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
				y = i;
			}
			if (input.substring(1, 2).equals(numbers[i])) {
				x = i;
			}
		}
		result[0] = x;
		result[1] = y;
		return result;
	}
	
	private static boolean isUpper(String s)
	{
	    for(char c : s.toCharArray())
	    {
	        if(! Character.isUpperCase(c))
	            return false;
	    }

	    return true;
	    
	    //test commit changed author
	}
}
