import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.stud.stianoj.cardgame.DeckOfCards;

/**
 * Test class for DeckOfCards
 * 
 * positive test cases:
 * - test that you can construct a deck of cards with 52 cards
 * - test that you can get n random cards from the deck
 */
public class DeckOfCardsTest {
    @Test
    public void testDeckOfCards() {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(52, deck.getNumberOfCards());
    }


    @Test
    public void testDealHand() {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(5, deck.dealHand(5).size());
    }
}
