package edu.stud.stianoj.cardgame.presentation;

import java.util.Collection;

import edu.stud.stianoj.cardgame.HandOfCards;
import edu.stud.stianoj.cardgame.PlayingCard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class HandStatsDisplay {
    private GridPane gridPane;

    private InfoRow sumContainer;
    private InfoRow cardsOfHeartContianer;
    private InfoRow flushContainer;
    private InfoRow queenOfSpadeContainer;

    public HandStatsDisplay() {
        super();

        this.gridPane = new GridPane();

        this.gridPane.setHgap(20);
        this.gridPane.setVgap(20);
        this.gridPane.setAlignment(Pos.CENTER);
        this.gridPane.setPadding(new Insets(20));

        sumContainer = new InfoRow("Sum of cards", "");
        this.gridPane.add(sumContainer, 0, 0);

        cardsOfHeartContianer = new InfoRow("Cards of heart", "");
        this.gridPane.add(cardsOfHeartContianer, 1, 0);

        flushContainer = new InfoRow("Is Flush", "");
        this.gridPane.add(flushContainer, 0, 1);

        queenOfSpadeContainer = new InfoRow("Has Queen of Spade", "");
        this.gridPane.add(queenOfSpadeContainer, 1, 1);
    }

    public GridPane getNode() {
        return this.gridPane;
    }

    public void displayHandStats(HandOfCards hand) {
        int sum = hand.getSum();
        sumContainer.setValue(Integer.toString(sum));

        Collection<PlayingCard> cardsOfHeart = hand.getSuit('H');
        String heartCards = cardsOfHeart.stream().map(PlayingCard::getAsString).reduce("", (a, b) -> a + " " + b);
        cardsOfHeartContianer.setValue(heartCards);

        boolean isFlush = hand.isFlush();
        flushContainer.setValue(Boolean.toString(isFlush));

        boolean hasQueenOfSpade = hand.containsCard('S', 12);
        queenOfSpadeContainer.setValue(Boolean.toString(hasQueenOfSpade));
    }

    private class InfoRow extends HBox{
        
        private TextField valueLabel;

        public InfoRow(String title, String value) {
            super();

            Label titleLabel = new Label(title);
            valueLabel = new TextField(value);
            this.setSpacing(20);
            getChildren().addAll(titleLabel, valueLabel);
        }

        /**
         * Set the value of the row
         * @param value to be set in the row
         */
        public void setValue(String value) {
            valueLabel.setText(value);
        }

    }
}
