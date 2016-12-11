/**
 * Created by annelyvattis on 12/6/16.
 */
public class Kontroll {

    public Kontroll(int[][] arr) {

        int row = 0;
        int col;
        int rowSum = 0;
        int colSum = 0;
        int rowok = 0;
        int colok =0;

        for (col = 0; col < 9; col++) {
            for (row = 0; row < 9; row++) {
                rowSum = rowSum + arr[row][col];
            }
            System.out.println("Sum of row " + rowSum);
            if (rowSum == 45) {
                rowok++;
                rowSum = 0;  // missed this line...
            } else {
                System.out.println("Midagi on valesti");
                rowSum = 0;
            }
        }
        for (row = 0; row < 9; row++) {
            for (col = 0; col < 9; col++) {
                colSum = colSum + arr[row][col];
            }
            System.out.println("Sum of column " + colSum);
            if (colSum == 45) {
                colok++;
                colSum = 0;  // missed this line...
            } else {
                colSum = 0;
                System.out.println("Midagi on valesti");
            }
        }
        if(rowok == 9 && colok == 9){
            System.out.println("Mäng läbi");
        }


    }
}
