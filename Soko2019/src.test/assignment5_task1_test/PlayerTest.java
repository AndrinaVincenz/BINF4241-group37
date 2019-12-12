package assignment5_task1_test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import assignment5_task1.Board;
import assignment5_task1.Game;
import assignment5_task1.Ladder;
import assignment5_task1.Snake;

public class PlayerTest {

	
	/**
	 * Tests if the players moves forward the right in case there is no ladder or snake
	 */
	@Test public void testMoveForwardNormalSquare(){
		System.out.println("MoveForwardNormalTest:");
		//Test Setup
		Board board = new Board(20);
		ArrayList<String> playernames = new ArrayList<String>(Arrays.asList("Lisa", "Marco", "Jessi"));
		Game game = new Game(playernames, board);		
		game.startGame();
		
		//Test prerequisites
		assertTrue("Lisa isn't on first Square", game.getPlayersLinkedList().get(0).getName().equals("Lisa"));
		assertTrue("Lisa is on field 1", game.getPlayersLinkedList().get(0).position() == 1);
		
		//Tests if the players move forward the right way
		int move = 3;
		while ((board.getSquares().get(move) instanceof Snake) || (board.getSquares().get(move) instanceof Ladder)){
			move++;
		}
		
		game.getPlayersLinkedList().get(0).moveForward(move, board);
		
		assertTrue("Not moved right amount:" + move + " ", board.getSquares().get(move).isOccupied() == true);
		assertFalse("Not moved right amount:" + move + " ", board.getSquares().get(move-1).isOccupied() == true);
		assertFalse("Not moved right amount:" + move + " ", board.getSquares().get(move+1).isOccupied() == true);
	}
	
	/**
	 * Tests if the players moves forward the right in case there is a ladder!
	 */
	@Test public void testMoveForwardLadder(){
		System.out.println("MoveForwardLadderTest:");
		//Test Setup
		Board board = new Board(20);
		ArrayList<String> playernames = new ArrayList<String>(Arrays.asList("Lisa", "Marco", "Jessi"));
		Game game = new Game(playernames, board);		
		game.startGame();
		
		//Test prerequisites
		assertTrue("Lisa isn't on first Square", game.getPlayersLinkedList().get(0).getName().equals("Lisa"));
		assertTrue("Lisa is on field 1", game.getPlayersLinkedList().get(0).position() == 1);
		
		//Tests if the players move forward the right way
		int move = 2;
		while (!(board.getSquares().get(move) instanceof Ladder)){
			move++;
		}
		Ladder tempLadder = (Ladder)board.getSquares().get(move);
		
		game.getPlayersLinkedList().get(0).moveForward(move, board);
		
		assertTrue("Not moved right amount:" + move + " ", board.getSquares().get(move).isOccupied() == false);
		assertTrue("Not moved right amount:" + move + " ", board.getSquares().get(tempLadder.getEndPosition()-1).isOccupied() == true);
		
	}
	
	/**
	 * Tests if the players moves forward the right in case there is a ladder!
	 */
	@Test public void testMoveForwardSnake(){
		System.out.println("MoveForwardLadderTest:");
		//Test Setup
		Board board = new Board(20);
		ArrayList<String> playernames = new ArrayList<String>(Arrays.asList("Lisa", "Marco", "Jessi"));
		Game game = new Game(playernames, board);		
		game.startGame();
		
		//Test prerequisites
		assertTrue("Lisa isn't on first Square", game.getPlayersLinkedList().get(0).getName().equals("Lisa"));
		assertTrue("Lisa is on field 1", game.getPlayersLinkedList().get(0).position() == 1);
		
		//Tests if the players move forward the right way
		int move = 2;
		while (!(board.getSquares().get(move) instanceof Snake)){
			move++;
		}
		Snake tempSnake = (Snake)board.getSquares().get(move);
		
		game.getPlayersLinkedList().get(0).moveForward(move, board);
		
		assertTrue("Not moved right amount:" + move + " ", board.getSquares().get(move).isOccupied() == false);
		assertTrue("Not moved right amount:" + move + " ", board.getSquares().get(tempSnake.getEndPosition()-1).isOccupied() == true);
		
	}
}
