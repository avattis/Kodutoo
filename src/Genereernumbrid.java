
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;


/**
 * Created by annelyvattis on 10/27/16.
 */
public class Genereernumbrid {
    private int[][] arr = new int[][]
                    {{5, 3, 4, 6, 7, 8, 9, 1, 2},
                    {6, 7, 2, 1, 9, 5, 3, 4, 8},
                    {1, 9, 8, 3, 4, 2, 5, 6, 7},
                    {8, 5, 9, 7, 6, 1, 4, 2, 3},
                    {4, 2, 6, 8, 5, 3, 7, 9, 1},
                    {7, 1, 3, 9, 2, 4, 8, 5, 6},
                    {9, 6, 1, 5, 3, 7, 2, 8, 4},
                    {2, 8, 7, 4, 1, 9, 6, 3, 5},
                    {3, 4, 5, 2, 8, 6, 1, 7, 9}};

    public int[][] getNumbrid() {
        return arr;
    }

    public Genereernumbrid() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("\t");
        }

        //esimese kolme rea omavaheline vahetus, randomiga leian rea, mida tuua esimeseks
        int rowswap = (int) (Math.random() * 3);
        System.out.println(rowswap);
        for (int i = 0; i < arr[rowswap].length; i++) {
            // store the value of highest row
            int temp = arr[rowswap][i];
            // swap the value of highest row with first row
            arr[rowswap][i] = arr[0][i];
            // set the value of first row that is stored in temp
            arr[0][i] = temp;
        }
        // järgmise kolme rea vahetus
        int rowswap2 = (int) (Math.random() * 3);
        System.out.println(rowswap2);
        for (int i = 0; i < arr[3 + rowswap2].length; i++) {
            int temp = arr[3 + rowswap2][i];
            arr[3+rowswap2][i] = arr[3][i];
            arr[3][i] = temp;
        }
        // viimase kolme reavahetus
        int rowswap3 = (int) (Math.random() * 3);
        System.out.println(rowswap3);
        for (int i = 0; i < arr[6 + rowswap3].length; i++) {
            int temp = arr[6 + rowswap3][i];
            arr[6+rowswap3][i] = arr[6][i];
            arr[6][i] = temp;
        }
        //esimese kolme veeru omavaheline vahetus, randomiga leian rea, mida tuua esimeseks
        int cellSwap = (int) (Math.random() * 3);
        System.out.println(rowswap);
        for (int j = 0; j < arr[cellSwap].length; j++) {
            // store the value of highest cell
            int temp = arr[j][cellSwap];
            // swap the value of highest cell with first cell
            arr[j][cellSwap] = arr[j][0];
            // set the value of first cell that is stored in temp
            arr[j][0] = temp;
        }
        // järgmise kolme veeru vahetus
        int cellswap2 = (int) (Math.random() * 3);
        System.out.println(cellswap2);
        for (int j = 0; j < arr[3 + cellswap2].length; j++) {
            int temp = arr[j][3+cellswap2];
            arr[j][3+cellswap2] = arr[j][3];
            arr[j][3] = temp;
        }
        // viimase kolme veeru vahetus
        int cellSwap3 = (int) (Math.random() * 3);
        System.out.println(cellSwap3);
        for (int j = 0; j < arr[6 + cellSwap3].length; j++) {
            int temp = arr[j][6 + cellSwap3];
            arr[j][6 + cellSwap3] = arr[j][6];
            arr[j][6] = temp;
        }

        System.out.println("After swapping");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }
}


