import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by annelyvattis on 12/6/16.
 */
public class Kontroll {
    static Label loppText = new Label();

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
                rowok++;
                rowSum = 0;  // missed this line...
            } else {
                System.out.println("Midagi on valesti");
                loppText = new Label("Kas ikka on?");
                rowSum = 0;
            }
        }
        for (row = 0; row < 9; row++) {
            for (col = 0; col < 9; col++) {
                colSum = colSum + tulemused[row][col];
            }
            System.out.println("Sum of column " + colSum);
            if (colSum == 45) {
                colok++;
                colSum = 0;  // missed this line...
            } else {
                colSum = 0;
                loppText = new Label("Kas ikka on?");
                System.out.println("Midagi on valesti");
            }
        }
        if(rowok == 9 && colok == 9){
            loppText = new Label("Mäng on läbi");
            System.out.println("Mäng läbi");
        }

        StackPane loppAken = new StackPane();
        loppAken.getChildren().add(loppText);

        Stage loppStage = new Stage();
        loppStage.setScene(new Scene(loppAken, 200, 100));
        loppStage.show();
    }
    
}
