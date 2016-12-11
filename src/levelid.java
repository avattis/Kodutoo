import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by annelyvattis on 12/5/16.
 */
public class levelid {
    private int[][] masks = new int[9][9];

    public int[][] getLevel() {
        return masks;
    }

    public levelid() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("sisesta nr.");
        int level = scanner.nextInt();
        if (level == 1) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    masks[i][j] = (int) (Math.random() * 1.7);
                    System.out.print(masks[i][j] + "\t");
                }
                System.out.println();
            }

        }else if (level == 2) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    masks[i][j] = (int) (Math.random() * 1.9);
                    System.out.print(masks[i][j] + "\t");
                }
                System.out.println();
            }
        }
        else if (level == 3) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    masks[i][j] = (int) (Math.random() * 2.7);
                   System.out.print(masks[i][j] + "\t");
                }
                System.out.println();
            }

        }else if(level == 4){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    masks[i][j] = (int) (Math.random() * 2.9);
                    System.out.print(masks[i][j] + "\t");
                }
                System.out.println();
            }

        }
    }
}







