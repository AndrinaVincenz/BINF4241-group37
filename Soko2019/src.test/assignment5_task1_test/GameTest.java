package assignment5_task1_test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

import assignment5_task1.Board;
import assignment5_task1.FirstSquare;
import assignment5_task1.Game;
import assignment5_task1.Ladder;
import assignment5_task1.Player;

/**
 * @author Raphael Koch
 *
 */
public class GameTest {
	
	/**
	 * Tests if every Player is on field 1 after executing the the startGame() method
	 */
	@Test public void testStartGame(){
		//Test Setup
		Board board = new Board(20);
		ArrayList<String> playernames = new ArrayList<String>(Arrays.asList("Lisa", "Marco", "Jessi"));
		Game game = new Game(playernames, board);
		
		//Test prerequisites
		assertTrue("FirstSquare isn't emtpy!", ((FirstSquare)board.getSquares().get(0)).getPlayers().isEmpty());
		
		//execute the function to test
		game.startGame();
		
		//Tests
		assertFalse("FirstSquare must not be empty!", ((FirstSquare)board.getSquares().get(0)).getPlayers().isEmpty());
		assertTrue("There need to be 3 players in the FirstSquare! (Lisa, Marco, Jessi)", ((FirstSquare)board.getSquares().get(0)).getPlayers().size() == 3);
	}

	/**
	 * Tests the case when the first roll is 1 and Square on position 2 is either a normal Square or a Ladder
	 */
	@Test public void testMovePlayer(){
		//Test Setup
		Board board = new Board(20);
		ArrayList<String> playernames = new ArrayList<String>(Arrays.asList("Lisa", "Marco", "Jessi"));
		Game game = new Game(playernames, board);
		game.startGame();

		//Check prerequisites
		assertTrue("Player 1 isn't at Field 1 at starttime!", 1 == game.getCurrentPlayer().position());
		//execute the function to test
		game.movePlayer(1);
		assertFalse("After the first move the player should be on the start field!", board.getSquares().get(0).getPosition() == game.getCurrentPlayer().position());
		if (!(board.getSquares().get(1) instanceof Ladder)){
		assertTrue("After movement of 1 the Player should be on Square on 2 (in case no ladder!)", 2 == game.getCurrentPlayer().position());
		} else {
			assertTrue("Player is on field that leaded from the ladder of square 2", ((Ladder)(board.getSquares().get(1))).getEndPosition() == game.getCurrentPlayer().position());
		}
	}
	
	
	/**
	 * Test whether the isOver function returns true if the Last Square is occupied by a Player
	 */
	@Test public void testIsOver(){
		//Test Setup
		Board board = new Board(20);
		ArrayList<String> playernames = new ArrayList<String>(Arrays.asList("Lisa", "Marco", "Jessi"));
		Game game = new Game(playernames, board);
		game.startGame();
		
		//Prerequisites
		assertFalse("LastSquare should have no player Inside!", board.getLastSquare().isOccupied());
		assertFalse("Game should not be finished!", game.isOver());
		
		//Do Testing
		board.getLastSquare().enter(new Player("Thomas"));
		assertTrue("In LastSquare should be a Player!", board.getLastSquare().isOccupied());
		assertTrue("Game should be finished!", game.isOver());
	}
	
	
	
}
