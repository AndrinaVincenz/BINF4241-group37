package assignment5_task1_test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import assignment5_task1.Board;
import assignment5_task1.Game;
import assignment5_task1.Ladder;
import assignment5_task1.Player;
import assignment5_task1.Snake;
import assignment5_task1.Square;

public class SquareTest {
	
	/**
	 * Tests if the occupation works correctly in case you land on a occupied field by a ladder or snake
	 */
	@Test public void testMoveAndLand_Occupied(){
		System.out.println("testCheckForSpecialSquares Occupied:");
		//Test Setup
		Board board = new Board(20);
		ArrayList<String> playernames = new ArrayList<String>(Arrays.asList("Lisa", "Marco"));
		Game game = new Game(playernames, board);		
		game.startGame();
		
		//Find a ladder
		int move = 2;
		while (!(board.getSquares().get(move) instanceof Snake)){
			move++;
		}
		Snake tempSnake = (Snake)board.getSquares().get(move);

		if (board.getSquares().get(tempSnake.getEndPosition()) instanceof Square){
		board.getSquares().get(tempSnake.getEndPosition()-1).enter(new Player("Louis"));
		board.printBoard();
		//At the start, player1 should be on field 1
		assertTrue("Should be on field 1 because field was occupied", game.getPlayersLinkedList().get(0).position() == 1);
		
		//Player 1 moves on Square that is occupied by Louis
		board.getSquares().get(0).moveAndLand(tempSnake.getPosition(), game.getPlayersLinkedList().get(0));		
		board.getSquares().get(0).moveAndLand(tempSnake.getEndPosition()-1, game.getPlayersLinkedList().get(0));		
		
		//Player 1 still should be on field 1, because the Field was occupied
		assertTrue("Field should be occupied by Louis", board.getSquares().get(tempSnake.getEndPosition()-1).isOccupied() == true);
		assertTrue("Should be on field 1 because field was occupied", game.getPlayersLinkedList().get(0).position() == 1);
		}		
	}

	/**
	 * Tests if a ladder is returned when it should and if the right position is returned
	 */
	@Test public void testCheckForSpecialSquaresLadder(){
		System.out.println("testCheckForSpecialSquares:");
		//Test Setup
		Board board = new Board(20);
		ArrayList<String> playernames = new ArrayList<String>(Arrays.asList("Lisa", "Marco", "Jessi"));
		Game game = new Game(playernames, board);		
		game.startGame();
		
		//Find a ladder
		int move = 2;
		while (!(board.getSquares().get(move) instanceof Ladder)){
			move++;
		}
		Ladder tempLadder = (Ladder)board.getSquares().get(move);
		
		//tests if the right ladder is returned!
		Square testLadder = board.getSquares().get(0).checkForSpecialSquares(move+1);

		assertTrue("Is not a ladder", testLadder.getPosition() == tempLadder.getEndPosition());
	}
	
	/**
	 * Tests if a snake is returned when it should, and if the right position is returned
	 */
	@Test public void testCheckForSpecialSquaresSnake(){
		System.out.println("testCheckForSpecialSquares Snake:");
		//Test Setup
		Board board = new Board(20);
		ArrayList<String> playernames = new ArrayList<String>(Arrays.asList("Lisa", "Marco", "Jessi"));
		Game game = new Game(playernames, board);		
		game.startGame();
		
		//Find a ladder
		int move = 2;
		while (!(board.getSquares().get(move) instanceof Snake)){
			move++;
		}
		Snake tempSnake = (Snake)board.getSquares().get(move);
		
		//tests if the right ladder is returned!
		Square testSnake = board.getSquares().get(0).checkForSpecialSquares(move+1);

		assertTrue("Is not a ladder", testSnake.getPosition() == tempSnake.getEndPosition());
		
	}
	
	
	
}
