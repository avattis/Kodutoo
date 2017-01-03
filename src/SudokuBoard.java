import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;



public class SudokuBoard extends Application {
    public String tase;
    public static GridPane box;
    Button end;
    public int[][] arr;
    public int[][] masks;
    Stage algaken= new Stage();

    int size = 40;

    public void start(Stage primaryStage) throws Exception {
        algus();

        Genereernumbrid genNr = new Genereernumbrid(); // toob Genereerinumbritest l
        arr = genNr.getNumbrid();

    }// end start

    private void algus() {
        algaken= new Stage();
        algaken.setTitle("Sudoku");


        // VBox
        VBox vb = new VBox();
        vb.setPadding(new Insets(10, 50, 50, 50));
        vb.setSpacing(10);

        Label lbl = new Label("Vali raskusaste");
        lbl.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));

        // Buttons
        Button btn1 = new Button("Väga kerge");
        btn1.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tase = "1";
                System.out.println(tase);
                seadistalevel();
            }
        });

        Button btn2 = new Button("Kerge");
        btn2.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tase = "2";
                System.out.println(tase);
                seadistalevel();
            }
        });

        Button btn3 = new Button("Keskmine");
        btn3.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tase = "3";
                System.out.println(tase);
                seadistalevel();
            }
        });

        Button btn4 = new Button("Raske");
        btn4.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tase = "4";
                System.out.println(tase);
                seadistalevel();
            }
        });

        Button btn5 = new Button("Testimiseks");
        btn5.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tase = "5";
                System.out.println(tase);
                seadistalevel();
            }
        });

        btn1.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn3.setMaxWidth(Double.MAX_VALUE);
        btn4.setMaxWidth(Double.MAX_VALUE);
        btn5.setMaxWidth(Double.MAX_VALUE);

        vb.getChildren().addAll(lbl, btn1, btn2,btn3,btn4, btn5);

        // Adding VBox to the scene
        Scene scene = new Scene(vb);
        algaken.setScene(scene);
        algaken.show();

    }



    public void seadistalevel() {

        levelid genLev = new levelid(tase); // toob Levelist ja saadab levelisse taseme info
        masks = genLev.getLevel();

        Stage stage = new Stage(); //loob uue akna
        AnchorPane anchor = new AnchorPane();

        box = new GridPane();
        for (int i = 0; i < 9; i++) {
            box.getColumnConstraints().add(new ColumnConstraints(size)); //veeru laius
            for (int j = 0; j < 1; j++) {
                box.getRowConstraints().add(new RowConstraints(size)); //rea kõrgus
            }
        }

        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                if (masks[row][column] == 0) { //null paneb numbri
                    Label label = new Label(Integer.toString(arr[row][column]));
                    label.setTranslateX(10.0);
                    label.setStyle("-fx-font-size: 19px;"
                            + "-fx-font-style: italic;"
                            + "-fx-alignment: center;"
                            + "-fx-font-weight: bold;"
                            + "-fx-text-fill: green;");
                    GridPane.setConstraints(label, row, column);
                    box.getChildren().add(label);
                } else {

                    TextField textField = new TextField("");
                    textField.addEventFilter(KeyEvent.KEY_TYPED, numFilter()); //sisestada tohib ainult numbrid 1-st 9-ni
                    textField.setStyle("-fx-font-weight: bold;"
                            +"-fx-font-size: 19px;"
                            + "-fx-alignment: center;");
                    GridPane.setConstraints(textField, row, column);
                    box.getChildren().add(textField);
                }//end else
            }//end for
        }// end for

        box.setGridLinesVisible(true); //laual tulevad nähtavale kõik jooned

        end = new Button("Lõpeta mäng");
        end.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
        end.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {


                ArrayList<String> kasutajalt = new ArrayList<>(); //siia kirjutame �les kasutaja maatriksi
                for (Node node : box.getChildren()) { //skaneerime k�ik laua lahtrid
                    if (node instanceof TextField) {
                        kasutajalt.add(((TextField) node).getText().trim());

                    } else if (node instanceof Label) {
                        kasutajalt.add(((Label) node).getText().trim());
                    }
                }
                System.out.println(kasutajalt); //vihjed konsooli
                int loendur = 0;

                for (String item : kasutajalt) {
                    if (!item.isEmpty()) {
                        loendur++;
                        System.out.println("Mitu korda?");
                    } else {
                        StackPane vaheteade = new StackPane();
                        Label teade = new Label("Kõik väljad pole täidetud");
                        vaheteade.getChildren().add(teade);
                        Stage vaheStage = new Stage();
                        vaheStage.setScene(new Scene(vaheteade, 200, 100));
                        vaheStage.show();

                        teade.setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                vaheStage.close();
                            }
                        });
                        break;

                    }
                }
                if(loendur == 81){
                    List<Integer> kasutajaltInt = new ArrayList<Integer>(); // teen Stringist Integer'i
                    for (Object str : kasutajalt) {
                            kasutajaltInt.add(Integer.parseInt((String) str));
                    }
                    Integer kasutajaArray[] = kasutajaltInt.toArray(new Integer[kasutajaltInt.size()]);

		/*Displaying Array elements*/
		            for (Integer k : kasutajaArray) {
                            System.out.println(k);
                    }
                    Integer tulemused[][] = new Integer[9][9];
                    int count = 0;
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            tulemused[i][j] = kasutajaArray[count];
                            if (count == kasutajaArray.length) break;
                                System.out.print(tulemused[i][j] + "\t");
                                count++;
                        }
                        System.out.println("\t");
                    }
                    new Kontroll(tulemused);
                }
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

        stage.setScene(new Scene(anchor, 500,400));
        stage.show();
        algaken.close();

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


