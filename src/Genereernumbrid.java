/* Etteantud Sudoku numbrid, mida segatakse. Segamine toimub nii veerus kui reas, kolmeste plokkidena.
Millise kolmest rea/veeru tõstab esimeseks võtab iga grupi puhul erineva või siis ei muuda üldse.
 */
public class Genereernumbrid {
    private int[][] Sudokunumbrid = new int[][]
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
        return Sudokunumbrid;
    }

    public Genereernumbrid() {
        System.out.println("Enne segamist");
       for (int i = 0; i < Sudokunumbrid.length; i++) {
            for (int j = 0; j < Sudokunumbrid[i].length; j++) {
                System.out.print(Sudokunumbrid[i][j] + "\t");
            }
            System.out.println("\t");
        }

        //esimese kolme rea omavaheline vahetus, randomiga leian rea, mida tuua esimeseks
        int rowswap = (int) (Math.random() * 3);
        System.out.println(rowswap);
        for (int i = 0; i < Sudokunumbrid[rowswap].length; i++) {
            int temp = Sudokunumbrid[rowswap][i];   // salvestab mällu kõrgeima leitud rea
            Sudokunumbrid[rowswap][i] = Sudokunumbrid[0][i];    // tõstab esimese rea eelnevalt leitud rea kohale
            Sudokunumbrid[0][i] = temp;             // mällu salvestatud rea tõstab esimesele reale
        }
        // järgmise kolme rea vahetus
        int rowswap2 = (int) (Math.random() * 3);
        System.out.println(rowswap2);
        for (int i = 0; i < Sudokunumbrid[3 + rowswap2].length; i++) {
            int temp = Sudokunumbrid[3 + rowswap2][i];
            Sudokunumbrid[3+rowswap2][i] = Sudokunumbrid[3][i];
            Sudokunumbrid[3][i] = temp;
        }
        // viimase kolme reavahetus
        int rowswap3 = (int) (Math.random() * 3);
        System.out.println(rowswap3);
        for (int i = 0; i < Sudokunumbrid[6 + rowswap3].length; i++) {
            int temp = Sudokunumbrid[6 + rowswap3][i];
            Sudokunumbrid[6+rowswap3][i] = Sudokunumbrid[6][i];
            Sudokunumbrid[6][i] = temp;
        }
        //esimese kolme veeru omavaheline vahetus, randomiga leian rea, mida tuua esimeseks
        int cellSwap = (int) (Math.random() * 3);
        System.out.println(cellSwap);
        for (int j = 0; j < Sudokunumbrid[cellSwap].length; j++) {
            int temp = Sudokunumbrid[j][cellSwap];
            Sudokunumbrid[j][cellSwap] = Sudokunumbrid[j][0];
            Sudokunumbrid[j][0] = temp;
        }
        // järgmise kolme veeru vahetus
        int cellswap2 = (int) (Math.random() * 3);
        System.out.println(cellswap2);
        for (int j = 0; j < Sudokunumbrid[3 + cellswap2].length; j++) {
            int temp = Sudokunumbrid[j][3+cellswap2];
            Sudokunumbrid[j][3+cellswap2] = Sudokunumbrid[j][3];
            Sudokunumbrid[j][3] = temp;
        }
        // viimase kolme veeru vahetus
        int cellSwap3 = (int) (Math.random() * 3);
        System.out.println(cellSwap3);
        for (int j = 0; j < Sudokunumbrid[6 + cellSwap3].length; j++) {
            int temp = Sudokunumbrid[j][6 + cellSwap3];
            Sudokunumbrid[j][6 + cellSwap3] = Sudokunumbrid[j][6];
            Sudokunumbrid[j][6] = temp;
        }

        System.out.println("Pärast segamist");
        for (int i = 0; i < Sudokunumbrid.length; i++) {
            for (int j = 0; j < Sudokunumbrid[i].length; j++) {
                System.out.print(Sudokunumbrid[i][j] + "\t");
            }
            System.out.println();
        }

    }
}


