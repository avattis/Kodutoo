/* Tulemuste massiivist hakkab kokku arvutama ridasid ja veerge. Iga rida/veerg annab kokku summaks 45.
 * Lubab raskematel levelitel erinevid lahendeid */

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Kontroll {
    static Label loppText = new Label();
    private Stage loppStage = new Stage();

    public Kontroll(Integer[][] tulemused) {

        int row;
        int col;
        int rowSum = 0;
        int colSum = 0;
        int rowok = 0;
        int colok =0;

        for (col = 0; col < 9; col++) {
            for (row = 0; row < 9; row++) {
                rowSum = rowSum + tulemused[row][col];
            }
            System.out.println("Sum of row " + rowSum);
            if (rowSum == 45) {
                rowok++;  // arvutab kokku tulemusega 45 lõppenud read
                rowSum = 0;  // tühjendab eelnevalt leitud numbrist
            } else {
                System.out.println("Midagi on valesti");
                loppText = new Label("Kas ikka on?"); //määrab labelisse teksti
                rowSum = 0; // tühjendab eelnevalt leitud numbrist
            }
        }
        for (row = 0; row < 9; row++) {
            for (col = 0; col < 9; col++) {
                colSum = colSum + tulemused[row][col];
            }
            System.out.println("Sum of column " + colSum);
            if (colSum == 45) {
                colok++; // arvutab kokku tulemusega 45 lõppenud veerud
                colSum = 0;  // tühjendab eelnevalt leitud numbrist
            } else {
                colSum = 0; // tühjendab eelnevalt leitud numbrist
                loppText = new Label("Midagi on valesti!");
                System.out.println("Midagi on valesti");
            }
        }
        if(rowok == 9 && colok == 9){ // kui reast ja veerust mõlemast sai kokku 9 õiget rida, annav teavituse, et mäng on läbi
            loppText = new Label("Mäng on läbi");
            System.out.println("Kõik on õige!");
        }




        StackPane loppAken = new StackPane();
        loppAken.getChildren().add(loppText);
        loppStage.setScene(new Scene(loppAken, 200, 100));
        loppStage.show();
        loppAken.setOnMouseClicked(new EventHandler<MouseEvent>(){ //väikse akna saab eest klikiga suvalisse kohta seal aknal
            @Override
            public void handle(MouseEvent event) {
                loppStage.close();
            }
        });

    }



}
