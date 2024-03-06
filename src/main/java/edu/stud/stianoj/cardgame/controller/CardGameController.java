package edu.stud.stianoj.cardgame.controller;

import java.util.Collection;

import edu.stud.stianoj.cardgame.DeckOfCards;
import edu.stud.stianoj.cardgame.HandOfCards;
import edu.stud.stianoj.cardgame.PlayingCard;
import edu.stud.stianoj.cardgame.presentation.CardGameApplication;

public class CardGameController {
    
    private CardGameApplication cardGameApplication;
    private HandOfCards currentHand;
    private DeckOfCards deck;

    public CardGameController(CardGameApplication app) {
        this.cardGameApplication = app;
        this.deck = new DeckOfCards();
    }

    public void doDeal() {
        Collection<PlayingCard> cards = deck.dealHand(5);
        currentHand = new HandOfCards(cards);

        this.cardGameApplication.showHand(currentHand);
    }

    public void doCheck() {
        if (this.currentHand == null) {
            return;
        }

        this.cardGameApplication.showHandStats(this.currentHand);
    }
}
