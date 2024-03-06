package edu.stud.stianoj.cardgame.presentation;

import edu.stud.stianoj.cardgame.HandOfCards;
import edu.stud.stianoj.cardgame.controller.CardGameController;
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
    HandStatsDisplay handStatsDisplay;
    CardGameController cardGameController;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        cardGameController = new CardGameController(this);

        handDisplay = new HandDisplay();
        handStatsDisplay = new HandStatsDisplay();

        Button dealButton = new Button("Deal");
        dealButton.setPrefSize(100, 100);

        Button checkButton = new Button("Check");
        checkButton.setPrefSize(100, 100);

        dealButton.setOnAction(e -> this.cardGameController.doDeal());
        checkButton.setOnAction(e -> this.cardGameController.doCheck());

        VBox buttonsContainer = new VBox();
        buttonsContainer.getChildren().addAll(dealButton, checkButton);
        buttonsContainer.setAlignment(Pos.CENTER);
        buttonsContainer.setPadding(new Insets(20));
        buttonsContainer.setSpacing(20);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(handDisplay.getNode());
        borderPane.setBottom(handStatsDisplay.getNode());
        borderPane.setRight(buttonsContainer);

        Scene scene = new Scene(borderPane, 1000, 800);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Card Game");
        primaryStage.show();
    }

    public void showHand(HandOfCards hand) {
        handDisplay.displayHand(hand);
    }

    public void showHandStats(HandOfCards hand) {
        handStatsDisplay.displayHandStats(hand);
    }

    public static void appMain(String[] args) {
        launch(args);
    }
}
