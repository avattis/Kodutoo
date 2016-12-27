import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {



    public void start(Stage primaryStage) {
        algus();

    }


        public void algus() {
            Stage primaryStage = new Stage();

        primaryStage.setTitle("Sudoku");

        // VBox
        VBox vb = new VBox();
        vb.setPadding(new Insets(10, 50, 50, 50));
        vb.setSpacing(10);

        Label lbl = new Label("Vali raskusaste");
        lbl.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
        vb.getChildren().add(lbl);

        // Buttons
        Button btn1 = new Button("Väga kerge");
        btn1.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                lbl.setText("Accepted");
            }
        });

        Button btn2 = new Button("Kerge");
        btn2.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                lbl.setText("Accepted");

            }
        });

        Button btn3 = new Button("Keskmine");
        btn3.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                lbl.setText("Accepted");
            }
        });

        Button btn4 = new Button("Raske");
        btn4.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                lbl.setText("Accepted");
            }
        });

        btn1.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn3.setMaxWidth(Double.MAX_VALUE);
        btn4.setMaxWidth(Double.MAX_VALUE);

        vb.getChildren().addAll(btn1, btn2,btn3,btn4);

        // Adding VBox to the scene
        Scene scene = new Scene(vb);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}