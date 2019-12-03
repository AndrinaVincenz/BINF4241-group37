package assignment5_task1_test;
import org.junit.Test;

import assignment5_task1.Board;
import assignment5_task1.Ladder;
import assignment5_task1.Snake;
import assignment5_task1.Square;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class BoardTest {
	
	
	
	/**
	 * 
	 */
	@Test public void testCreateLadderList(){
		Board board = new Board(20);
		int numOfSquare = board.getNumOfSquares();
		double percentage = 0.2; //according defined in the method
		
		int countLadder = (int) (numOfSquare * percentage); 

		ArrayList<Square> testLadderList = board.createLadderList();
		
		assertTrue("Number of Ladders to high", testLadderList.size() < board.getNumOfSquares());
		assertTrue("Number of Ladders to small", testLadderList.size() >= 0);
		assertTrue("Number of Ladders not approximately " + percentage + "%", testLadderList.size() == countLadder);
		for (Square temp : testLadderList){
			assertTrue("Not a instance of ladder!", temp instanceof Ladder);
			assertTrue("Ladder doesn't go up!", ((Ladder)temp).getPosition() < ((Ladder)temp).getEndPosition());
			assertFalse("Ladder can't be on First Square!", ((Ladder)temp).isFirstSquare());
			assertFalse("Ladder can't be on Last Square!", ((Ladder)temp).isLastSquare());
		}
	}
	
	@Test public void testCreateSnakeList(){
		Board board = new Board(20);
		int numOfSquare = board.getNumOfSquares();
		double percentage = 0.2; //according defined in the method
		
		int countSnakes = (int) (numOfSquare * percentage); 
		
		ArrayList<Square> testSnakeList = board.createSnakeList();
		
		assertTrue("Number of Snakes to high", testSnakeList.size() < board.getNumOfSquares());
		assertTrue("Number of Snakes to small", testSnakeList.size() >= 0);
		assertTrue("Number of Snakes not approximately " + percentage + "%", testSnakeList.size() == countSnakes);
		for (Square temp : testSnakeList){
			assertTrue("Not a instance of snake!", temp instanceof Snake);
			assertTrue("Snake doesn't go down!", ((Snake)temp).getPosition() > ((Snake)temp).getEndPosition());
			assertFalse("Snake can't be on First Square!", ((Snake)temp).isFirstSquare());
			assertFalse("Snake can't be on Last Square!", ((Snake)temp).isLastSquare());
		}
		
	}
	
	/**
	 * 
	 */
	@Test public void testCreateBoard(){
		Board board = new Board(20);
		
		board.createBoard();
		
		assertTrue("First Square has to be must be of type 'FirstSquare'", board.getSquares().get(0).isFirstSquare());
		assertTrue("Last Square has to be must be of type 'LastSquare'", board.getSquares().get(board.getNumOfSquares()-1).isLastSquare());
		//to be continued...
	}
	
	/**
	 * @param snakes
	 * @param ladders
	 */
	@Test public void testMergeLaddersAndSnakes(){
		Board board = new Board(20);

		ArrayList<Square> testSnakeList = board.createSnakeList();
		ArrayList<Square> testLadderList = board.createLadderList();

		ArrayList<Square> testList = board.mergeLaddersAndSnakes(testSnakeList, testLadderList);
		
		assertTrue("Must be smaller than NumberOfSquares", testList.size() < board.getNumOfSquares());
		//to be continued...
	}
	
	@Test public void testCreateRandomPosition(){
	
		Board board = new Board(20);
		for (int i = 0; i < 100; i++){
		int position = board.createRandomPosition();
		assertTrue("CreatedRandomPosition not in allowed Range!!!", position < board.getNumOfSquares() && position > 0);
		}
		
		Board board2 = new Board(1000);
		for (int i = 0; i < 100; i++){
		int position = board2.createRandomPosition();
		assertTrue("CreatedRandomPosition not in allowed Range!!!", position < board2.getNumOfSquares() && position > 0);
		}
	}
	

	
}
