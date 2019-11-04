package assignment3;

import java.util.ArrayList;

public class Promotion {
	
	public boolean tryPromotion(String input, Game game, Board b, boolean color){
		String endPosition = input.substring(1, 3);
		String figure = input.substring(0, 1);
		String finalFigure = input.substring(4, 5);
		int tempEndField[] = converted(endPosition);
		
		ArrayList<Field> possibleMovesStartPosition = b.findInput(figure, color);
		ArrayList<Field> tempCopy = new ArrayList<Field>();
		tempCopy.addAll(possibleMovesStartPosition);
		System.out.println(possibleMovesStartPosition + "before removes (Promotion)");

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
		System.out.println(tempCopy + "after removes (Promotion)");
		possibleMovesStartPosition = tempCopy;
		
		if (possibleMovesStartPosition.size() == 1){
			if (color == true){
				if (possibleMovesStartPosition.get(0).getX() != 1){
					System.out.println("You're on the wrong field!");
					return false;
				}
			} else {
				if (possibleMovesStartPosition.get(0).getX() != 6){
					System.out.println("You're on the wrong field! Fieldnumber:" + possibleMovesStartPosition.get(0).getX());
					return false;
				}
			}
			possibleMovesStartPosition.get(0).setPiece(null);
			b.getBox(tempEndField[0], tempEndField[1]).setPiece(createPiece(color, finalFigure));
			return true;
		} else {
			System.out.println("Promotion not possible!!!");
			return false;
		}
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
	
	private Piece createPiece(boolean color, String f){
	if (f.equals("R")){
		return new Rook(color);
	}
	if (f.equals("K")){
		return new Knight(color);
	}
	if (f.equals("B")){
		return new Bishop(color);
	}
	if (f.equals("Q")){
		return new Queen(color);
	}
	return new Pawn(color);
	}
}
