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
	 * It is tested whether every created Square is a ladder and if the size is appropriate
	 * 
	 */
	@Test public void testCreateLadderList1(){
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
	}
	
	/**
	 * @Param percentage decides how many ladders are created
	 * Test size in case input parameter more than 0.5 or less then 0
	 */
	@Test public void testCreateLadderList2(){
		//Test setup
		Board board = new Board(20);		
		
		//Test size in case input parameter more than 0.5 or less then 0
		ArrayList<Square> testLadderList2 = board.createLadderList(1000);		
		ArrayList<Square> testLadderList3 = board.createLadderList(-10);
		assertTrue("Size  of List should be 50 %", testLadderList2.size() == 10);
		assertTrue("Size  of List should be 0 %", testLadderList3.size() == 0);
	}
	
	/**
	 * It is tested whether every created Square is a snake and if the size is appropriate
	 */
	@Test public void testCreateSnakeList(){
		//Test setup
		Board board = new Board(20);
		ArrayList<Square> testSnakeList = board.createSnakeList(0.2);
		
		//Test cases
		assertTrue("Number of snakes to high", testSnakeList.size() < board.getNumOfSquares());
		assertTrue("Number of snakes to small", testSnakeList.size() >= 0);
		assertTrue("Number of snakes not approximately 20% Size:" + testSnakeList.size()  + " Should be:"+ board.getNumOfSquares(), testSnakeList.size() == (int)(board.getNumOfSquares()*0.2));
		for (Square temp : testSnakeList){
			assertTrue("Not a instance of snake!", temp instanceof Snake);
			assertTrue("Snake doesn't go down!", ((Snake)temp).getPosition() > ((Snake)temp).getEndPosition());
		}
	}
	
	/**
	 * @Param percentage decides how many snakes are created
	 * Test size in case input parameter more than 0.5 or less then 0
	 */
	@Test public void testCreateSnakeList2(){
		//Test setup
		Board board = new Board(20);		
		
		//Test size in case input parameter more than 0.5 or less then 0
		ArrayList<Square> testSnakeList2 = board.createSnakeList(1000);		
		ArrayList<Square> testSnakeList3 = board.createSnakeList(-10);
		assertTrue("Size  of List should be 50 %", testSnakeList2.size() == 10);
		assertTrue("Size  of List should be 0 %", testSnakeList3.size() == 0);
	}
	
	/**
	 * Tests in case a board with size 20 is initialized, whether first- and lastSquare is set and the amount of Squares is right.
	 */
	@Test public void testCreateBoard(){
		//Test setup
		Board board = new Board(20);
		board.createBoard(0.2, 0.2);
		
		assertTrue("First Square has to be must be of type 'FirstSquare'", board.getSquares().get(0).isFirstSquare());
		assertTrue("Last Square has to be must be of type 'LastSquare'", board.getSquares().get(board.getNumOfSquares()-1).isLastSquare());
		assertTrue("Board should have size of 20", board.getSquares().size() == 20);
		
		//Tests if the summarized amount of Ladders, Snakes and normal Squares is correct
		int amountSnakes = 0;
		int amountLadders = 0;
		int normalSquare = 0;
		for (Square temp : board.getSquares()){
			if (temp instanceof Ladder){
				amountLadders++;
			}
			if (temp instanceof Snake){
				amountLadders++;
			}
			if (!(temp instanceof Ladder) && !(temp instanceof Snake)){
				normalSquare++;
			}
		}
		assertTrue("Total size must be 20 but is " + (amountSnakes + amountLadders + normalSquare), (amountSnakes + amountLadders + normalSquare) == 20);
		
	}
	
	/**
	 * Checks if the first or last Square are snakes or ladders, which wouldn't be allowed!
	 */
	@Test public void testMergeLaddersAndSnakes(){
		//Setup
		Board board = new Board(20);

		ArrayList<Square> testSnakeList = board.createSnakeList(0.2);
		ArrayList<Square> testLadderList = board.createLadderList(0.2);
		ArrayList<Square> testList = board.mergeLaddersAndSnakes(testSnakeList, testLadderList);
		
		//Test cases
		assertTrue("Must be smaller than at least Sizes of Snakes and Ladders summarized", testList.size() <= (testSnakeList.size() + testLadderList.size()));
		assertTrue("Ladders and Snakes can't be on first Square!", testList.get(0).getPosition() != 1); //found bug because of this!
		assertTrue("Ladders and Snakes can't be on last Square!", testList.get(testList.size()-1).getPosition() != board.getNumOfSquares()); 
	}
	
	
	/**
	 * Tests whether a allowed random number is created according the board size.
	 */
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
