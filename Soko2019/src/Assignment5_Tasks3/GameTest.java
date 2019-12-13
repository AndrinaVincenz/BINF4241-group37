import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author Andrina Vincenz
 *
 */
public class GameTest {
	Game game = new Game();
	ArrayList<Players> players = new ArrayList<Player>;
	g.InitializePlayers(players);
	game.start();
	Deck deck = new Deck();
	/**
	 * Test if only between 2-10 can play and if they have 7 cards after Game start
	 */
	@Test public void teststart() {
		assertNotNull(players);
		// test for all players
		assertEquals(7, players.get(0).getNrCards());
		assertTrue("Number of Players is between 2-10", 2<= players.size() >= 10);
	}
	/**
	 * Test if currentplayer is selected at start
	 */
	@Test public void testCurrentPlayer() {
		assertEquals(game.GetCurrentPlayer().players.get(0));
	}
	/**
	 * Test if the right players are selected as winners
	 */
	@Test public void testWinner() {
		ArrayList<Players> winners = new ArrayList<Player>;
		for (Player p: players) {
			if(p.getNrCards() == 1) {
				winners.add(p);
			}
		}
		assertEquals(game.getWinner(),winners);
	}
	/**
	 * Test if player is skipped
	 */
	@Test public void testskipPlayer() {
		int currentplayercount = game.getCurrentPlayer().getIndex();
		game.skip();
		assertEquals(game.getCurrentPlayer(),players.get(currentplayercount + 2));
	}
	/**
	 * Test if ArrayList Players is reversed
	 */
	@Test public void testreversePlayer() {
		ArrayList<Players> ReversePlayers = new ArrayList<Player>;
		int count = players.size()-1;
		for (Player p: players) {
			ReversePlayers.set(count, p);
			count = count - 1;
		}
		game.reversePlayer();
		assertArrayEquals(ReversePlayers,Players);
	}
	/**
	 * Test if deck is actually shuffled
	 */
	@Test public void testshuffle() {
		Deck decktoshuffle = deck.getCards();
		decktoshuffle.shuffle();
		assertNotSame(decktoshuffle.get(0), deck.get(0));
	
	}
	/**
	 * Test if 2 cards are compatible, once by color and rank, aswell as one which can always be played
	 */
	@Test public void testcompadibleWith() {
		Card c1 = new Card(RANK.ONE, COLOR.RED);
		Card c2 = new Card(RANK.ONE, COLOR.BLUE);
		Card c3 = new Card(RANK.NINE, COLOR.RED);
		Card c4 = new WILDDRAWCARD();
		Card c5 = new Card(RANK.EIGHT, COLOR.GREEN);
		assertTrue(c1.compatibleWith(c2));
		assertTrue(c1.compatibleWith(c3));
		assertTrue(c1.compatibleWith(c4));
		assertFalse(c1.compatibleWith(c5));
		
	}
}
