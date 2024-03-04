package edu.stud.stianoj.cardgame.presentation;

import java.util.Collection;

import edu.stud.stianoj.cardgame.DeckOfCards;
import edu.stud.stianoj.cardgame.HandOfCards;
import edu.stud.stianoj.cardgame.PlayingCard;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardGameApplication extends Application{

    HandDisplay handDisplay;
    DeckOfCards deck;

    private void dealCards() {
        Collection<PlayingCard> cards = deck.dealHand(5);
        HandOfCards hand = new HandOfCards(cards);

        handDisplay.displayHand(hand);
    }

    private void checkHand() {

    }

    private void addRightButtons(BorderPane borderPane) {
        Button dealButton = new Button("Deal");
        dealButton.setPrefSize(100, 100);

        Button checkButton = new Button("Check");
        checkButton.setPrefSize(100, 100);

        dealButton.setOnAction(e -> dealCards());
        checkButton.setOnAction(e -> checkHand());

        VBox buttonsContainer = new VBox();
        buttonsContainer.getChildren().addAll(dealButton, checkButton);
        buttonsContainer.setAlignment(Pos.CENTER);
        buttonsContainer.setPadding(new Insets(20));
        buttonsContainer.setSpacing(20);

        borderPane.setRight(buttonsContainer);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        deck = new DeckOfCards();

        handDisplay = new HandDisplay();

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(handDisplay);
        addRightButtons(borderPane);

        Scene scene = new Scene(borderPane, 800, 800);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Card Game");
        primaryStage.show();
    }

    public static void appMain(String[] args) {
        launch(args);
    }
}
