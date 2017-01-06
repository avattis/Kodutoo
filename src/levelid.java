/* Erinevatele levelitele võtab randomina numbreid, mida hiljem kasutab laualoomisel tühja kohana*/
import java.util.Scanner;

public class levelid {

    private int[][] Tyhjadkohad = new int[9][9];


    public int[][] getLevel() {
        return Tyhjadkohad;
    }


    public levelid(String tase) { //esilehelt võtab taseme väärtuse ja paneb scannerisse
        Scanner scanner = new Scanner(tase);
        int level = scanner.nextInt();
        if (level == 1) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    Tyhjadkohad[i][j] = (int) (Math.random() * 1.4);
                    System.out.print(Tyhjadkohad[i][j] + "\t");
                }
                System.out.println();
            }

        }else if (level == 2) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    Tyhjadkohad[i][j] = (int) (Math.random() * 1.7);
                    System.out.print(Tyhjadkohad[i][j] + "\t");
                }
                System.out.println();
            }
        }else if (level == 5) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    Tyhjadkohad[i][j] = (int) (Math.random() * 1.1);
                    System.out.print(Tyhjadkohad[i][j] + "\t");
                }
                System.out.println();
            }
        }
        else if (level == 3) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    Tyhjadkohad[i][j] = (int) (Math.random() * 2.2);
                   System.out.print(Tyhjadkohad[i][j] + "\t");
                }
                System.out.println();
            }

        }else if(level == 4){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    Tyhjadkohad[i][j] = (int) (Math.random() * 2.7);
                    System.out.print(Tyhjadkohad[i][j] + "\t");
                }
                System.out.println();
            }

        }
    }
}







