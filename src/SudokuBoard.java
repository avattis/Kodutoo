import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


public class SudokuBoard extends Application {
    GridPane box;
    Button end;
    public int[][] arr;
    public int[][] masks;
    int size = 27;

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
        for (int i = 0; i < 9; i++) {
            box.getColumnConstraints().add(new ColumnConstraints(size)); //veeru laius
            for (int j = 0; j < 1; j++) {
                box.getRowConstraints().add(new RowConstraints(size)); //rea kõrgus
            }
        }

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
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
        //sudokulaua jooned
        int yks = 5;
        int kaks = 3*size+5;
        int kolm = 6*size+5;
        int neli = 9*size+5;
        Line line = new Line(yks, yks, yks, neli);
        line.setStyle("-fx-stroke: black;-fx-stroke-width: 3;");
        Line line1 = new Line(kaks, yks, kaks, neli);
        line1.setStyle("-fx-stroke: black;-fx-stroke-width: 3;");
        Line line2 = new Line(kolm, yks, kolm, neli);
        line2.setStyle("-fx-stroke: black;-fx-stroke-width: 3;");
        Line line3 = new Line(neli, yks, neli, neli);
        line3.setStyle("-fx-stroke: black;-fx-stroke-width: 3;");
        Line line4 = new Line(yks, yks, neli, yks);
        line4.setStyle("-fx-stroke: black;-fx-stroke-width: 3;");
        Line line5 = new Line(yks, kaks, neli, kaks);
        line5.setStyle("-fx-stroke: black;-fx-stroke-width: 3;");
        Line line6 = new Line(yks, kolm, neli, kolm);
        line6.setStyle("-fx-stroke: black;-fx-stroke-width: 3;");
        Line line7 = new Line(yks, neli, neli, neli);
        line7.setStyle("-fx-stroke: black;-fx-stroke-width: 3;");



        anchor.getChildren().addAll(box, end, line,line1,line2,line3,line4,line5,line6,line7);
        anchor.setLeftAnchor(box, 5.0);
        anchor.setTopAnchor(box, 5.0);
        anchor.setBottomAnchor(end, 20.0);
        anchor.setRightAnchor(end, 20.0);

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


