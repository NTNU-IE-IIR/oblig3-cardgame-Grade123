package edu.stud.stianoj.cardgame.controller;

import java.util.Collection;

import edu.stud.stianoj.cardgame.DeckOfCards;
import edu.stud.stianoj.cardgame.HandOfCards;
import edu.stud.stianoj.cardgame.PlayingCard;
import edu.stud.stianoj.cardgame.presentation.CardGameApplication;

/**
 * Card game controller class
 * 
 * @author stianoj
 * @since 18/03/2024
 */
public class CardGameController {
    private CardGameApplication cardGameApplication;
    private HandOfCards currentHand;
    private DeckOfCards deck;

    /**
     * Constructor for CardGameController
     * 
     * @param app the card game application (the view of the MVC pattern)
     */
    public CardGameController(CardGameApplication app) {
        this.cardGameApplication = app;
        this.deck = new DeckOfCards();
    }

    /**
     * Deal a hand of cards and updates the view
     */
    public void doDeal() {
        Collection<PlayingCard> cards = deck.dealHand(5);
        currentHand = new HandOfCards(cards);

        this.cardGameApplication.showHand(currentHand);
    }

    /**
     * Checks the current hand and updates the view
     */
    public void doCheck() {
        if (this.currentHand == null) {
            return;
        }

        this.cardGameApplication.showHandStats(this.currentHand);
    }
}
