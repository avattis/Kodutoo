import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


public class SudokuBoard extends Application {
    GridPane box;
    Button end;
    public int[][] arr;

    public int[][] masks;



    public void start(Stage primaryStage) throws Exception {
        Genereernumbrid genNr = new Genereernumbrid(); // toob Genereerinumbritest l
        arr = genNr.getNumbrid();

        levelid genLev = new levelid(); // toob Levelist
        masks = genLev.getLevel();

        new Kontroll(arr);
        seadistalevel();


    }// end start

    public void seadistalevel() {
        Stage stage = new Stage();
        AnchorPane anchor = new AnchorPane();

        box = new GridPane();
        for (int col = 0; col< 3; col++) {
            for (int colum = 0;colum < 3; colum++) {
                GridPane board = new GridPane();
                board.setStyle("-fx-background-color: black, -fx-control-inner-background; -fx-background-insets: 0, 2; -fx-padding: 4;");
                for (int column = 0; column < 3; column++) {
                    for (int row = 0 ; row < 3; row++) {
                        board.setStyle("-fx-background-color: black, -fx-control-inner-background; -fx-background-insets: 0, 2; -fx-padding: 2;");
                        GridPane.setConstraints(board, column, row);
                    }
                }
                GridPane.setConstraints(board, col, colum);
                box.getChildren().add(board);
            }
        }



        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
               // box.setStyle("-fx-background-color: black, -fx-control-inner-background; -fx-background-insets: 0, 2; -fx-padding: 2;");
                if (masks[row][column] == 0) { //null paneb numbri
                    Label label = new Label(Integer.toString(arr[row][column]));
                    label.setStyle("-fx-pref-width: 2em;");
                    label.setTranslateX(10.0);
                    label.setStyle("-fx-font-size: 12px;"
                            + "-fx-font-style: italic;"
                            + "-fx-alignment: center;"
                            + "-fx-font-weight: bold;"
                            + "-fx-font-family: Arial Black;"
                            + "-fx-text-fill: green;");
                    GridPane.setConstraints(label, row, column);
                    box.getChildren().add(label);
                } else {
                    TextField textField = new TextField("");
                    textField.addEventFilter(KeyEvent.KEY_TYPED, numFilter()); //sisestada tohib ainult numbrid 1-st 9-ni
                    textField.setStyle("-fx-pref-width: 2em;");
                    GridPane.setConstraints(textField, row, column);
                    box.getChildren().add(textField);
                }//end else
            }//end for
        }// end for

        box.setGridLinesVisible(true);

       // box = new GridPane();
        end = new Button("Lõpeta mäng");
        end.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
        end.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Label loppText = new Label("Kas ikka on?");
                StackPane loppAken = new StackPane();
                loppAken.getChildren().add(loppText);

                Stage loppStage = new Stage();
                loppStage.setScene(new Scene(loppAken, 200, 100));
                loppStage.show();
            }
        });


        anchor.getChildren().addAll(box, end);
        anchor.setBottomAnchor(end, 40.0);
        anchor.setRightAnchor(end, 40.0);

        stage.setScene(new Scene(anchor, 400,300));
        stage.show();

    }//end seadistalevel
    

    private static EventHandler<KeyEvent> numFilter() {
        //lahtrisse saab sisestada ainult numbrid 1-st 9-ni, kui kasutaja sisestab midagi muud, siis ei reageeri
        EventHandler<KeyEvent> aux = new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                if (!"123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        };
        return aux;
    }//end numFilter
    


}//end Sudokuboard


