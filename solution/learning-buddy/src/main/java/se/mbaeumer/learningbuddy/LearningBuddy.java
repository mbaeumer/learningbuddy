package se.mbaeumer.learningbuddy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LearningBuddy extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

        // Top Pane
        Pane topPane = new Pane();
        topPane.setStyle("-fx-background-color: lightblue;");

        // Center Pane
        HBox centerPane = new HBox();
        centerPane.setStyle("-fx-background-color: lightgreen;");

        Pane leftPane = new Pane();
        leftPane.setStyle("-fx-background-color: lightyellow;");

        Pane rightPane = new Pane();
        rightPane.setStyle("-fx-background-color: black;");

        centerPane.getChildren().addAll(leftPane, rightPane);


        // Bottom Pane
        Pane bottomPane = new Pane();
        bottomPane.setStyle("-fx-background-color: lightcoral;");

        root.getChildren().addAll(topPane, centerPane, bottomPane);

        // Bind heights proportionally to total height
        root.heightProperty().addListener((obs, oldVal, newVal) -> {
            double h = newVal.doubleValue();
            topPane.setPrefHeight(h * 0.20);    // ~28%
            centerPane.setPrefHeight(h * 0.65); // ~48%
            bottomPane.setPrefHeight(h * 0.15); // ~24%
        });

        centerPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double w = newVal.doubleValue();
            leftPane.setPrefWidth(w * 0.20);   // 20%
            rightPane.setPrefWidth(w * 0.80);  // 80%
        });


        Scene scene = new Scene(root, 800, 600, Color.WHITE);
        stage.setScene(scene);
        stage.setTitle("Proportional Layout Demo");
        stage.show();
    }
}
