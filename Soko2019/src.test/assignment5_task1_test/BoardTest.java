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
	 * It is tested whether @Param testLadderList creates
	 * 
	 */
	@Test public void testCreateLadderList(){
		//Test setup
		Board board = new Board(20);		

		ArrayList<Square> testLadderList = board.createLadderList(0.2);

		//tests the List in general
		assertTrue("Number of Ladders to high", testLadderList.size() < board.getNumOfSquares());
		assertTrue("Number of Ladders to small", testLadderList.size() >= 0);
		assertTrue("Number of Ladders not approximately 20% Size:" + testLadderList.size()  + " Should be:"+ board.getNumOfSquares(), testLadderList.size() == (int)(board.getNumOfSquares()*0.2));
		
		//Tests for each ladder inside the list
		for (Square temp : testLadderList){
			assertTrue("Not a instance of ladder!", temp instanceof Ladder);
			assertTrue("Ladder doesn't go up!", ((Ladder)temp).getPosition() < ((Ladder)temp).getEndPosition());
		}
		
		//Test size in case input parameter more than 0.5 or less then 0
		ArrayList<Square> testLadderList2 = board.createLadderList(1000);		
		ArrayList<Square> testLadderList3 = board.createLadderList(-10);
		assertTrue("Size  of List should be 50 %", testLadderList2.size() == 10);
		assertTrue("Size  of List should be 0 %", testLadderList3.size() == 0);

	}
	
	@Test public void testCreateSnakeList(){
		Board board = new Board(20);
		int numOfSquare = board.getNumOfSquares();
		double percentage = 0.2; //according defined in the method
		
		int countSnakes = (int) (numOfSquare * percentage); 
		
		ArrayList<Square> testSnakeList = board.createSnakeList(0.2);
		
		assertTrue("Number of Snakes to high", testSnakeList.size() < board.getNumOfSquares());
		assertTrue("Number of Snakes to small", testSnakeList.size() >= 0);
		assertTrue("Number of Snakes not approximately " + percentage + "%", testSnakeList.size() == countSnakes);
		for (Square temp : testSnakeList){
			assertTrue("Not a instance of snake!", temp instanceof Snake);
			assertTrue("Snake doesn't go down!", ((Snake)temp).getPosition() > ((Snake)temp).getEndPosition());
		}
		
		//Test size in case input parameter more than 0.5 or less then 0
		ArrayList<Square> testSnakeList2 = board.createSnakeList(1000);		
		ArrayList<Square> testSnakeList3 = board.createSnakeList(-10);
		assertTrue("Size  of List should be 50 %", testSnakeList2.size() == 10);
		assertTrue("Size  of List should be 0 %", testSnakeList3.size() == 0);
		
	}
	
	/**
	 * 
	 */
	@Test public void testCreateBoard(){
		Board board = new Board(20);
		
		board.createBoard();
		
		assertTrue("First Square has to be must be of type 'FirstSquare'", board.getSquares().get(0).isFirstSquare());
		assertTrue("Last Square has to be must be of type 'LastSquare'", board.getSquares().get(board.getNumOfSquares()-1).isLastSquare());
		board.printBoard();
		//to be continued...
	}
	
	/**
	 * @param snakes
	 * @param ladders
	 */
	@Test public void testMergeLaddersAndSnakes(){
		Board board = new Board(20);

		ArrayList<Square> testSnakeList = board.createSnakeList(0.2);
		ArrayList<Square> testLadderList = board.createLadderList(0.2);

		ArrayList<Square> testList = board.mergeLaddersAndSnakes(testSnakeList, testLadderList);
		
		assertTrue("Must be smaller than NumberOfSquares", testList.size() < board.getNumOfSquares());
		assertTrue("Ladders and Snakes can't be on first Square!", testList.get(0).getPosition() != 1); //found bug because of this!
		assertTrue("Ladders and Snakes can't be on last Square!", testList.get(testList.size()-1).getPosition() != board.getNumOfSquares()); 
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
