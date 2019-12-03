package assignment5_task1_test;

import static org.junit.Assert.*;

import org.junit.Test;

import assignment5_task1.Die;

public class DieTest {

	/**
	 * Tests if the roll() function returns numbers between 1 and 6
	 */
	@Test public void testRoll(){
		Die die = new Die();
		
		for (int i=0; i < 100; i++){
		int rolledNumber = die.roll();
		assertTrue("Würfel hat nicht zwischen 1 und 6 gerollt!", (rolledNumber >= 1) && (rolledNumber <= 6));
		}
	}
}
