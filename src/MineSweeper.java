import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class MineSweeper {
    int row;
    int col;
    String[][] fieldVisible;
    String[][] fieldHidden;

    MineSweeper(int row, int col) {
        this.row = row;
        this.col = col;
        this.fieldVisible = new String[this.row][this.col];
        this.fieldHidden = new String[this.row][this.col];
    }

    void run() {
        System.out.println("=== MineSweeper by frknsprnl ===");
        System.out.println("      Welcome to the game!    ");
        drawBoard();
        printHidden();
        selectCell();
    }

    void drawBoard() {
        for (int i = 0; i < this.fieldVisible.length; i++) {
            Arrays.fill(this.fieldVisible[i], "-");
        }

        for (int i = 0; i < this.fieldVisible.length; i++) {
            for (int j = 0; j < this.fieldVisible[i].length; j++) {
                System.out.print(this.fieldVisible[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = 0; i < this.fieldVisible.length; i++) {
            for (int j = 0; j < this.fieldVisible[i].length; j++) {
                fieldHidden[i][j] = fieldVisible[i][j];
            }
        }
        plantMine();
    }


    void plantMine() {
        Random rnd = new Random();
        int mineCount = (this.row * this.col) / 4;
        int i, j;
        while (mineCount > 0) {
            i = rnd.nextInt(this.row);
            j = rnd.nextInt(this.col);
            if (this.fieldHidden[i][j].equals("*")){
                continue;
            }
            this.fieldHidden[i][j] = "*";
            mineCount--;
        }
        System.out.println();
    }

    void printHidden() {
        for (int i = 0; i < this.fieldHidden.length; i++) {
            for (int j = 0; j < this.fieldHidden[i].length; j++) {
                System.out.print(this.fieldHidden[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    void printVisible() {
        for (int i = 0; i < this.fieldVisible.length; i++) {
            for (int j = 0; j < this.fieldVisible[i].length; j++) {
                System.out.print(this.fieldVisible[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void selectCell() {
        Scanner input = new Scanner(System.in);
        int selectedRow, selectedCol;

        while (true) {

            System.out.print("Satir: ");
            selectedRow = input.nextInt();

            System.out.print("Sutun: ");
            selectedCol = input.nextInt();

            if (selectedRow < 0 || selectedRow > this.row - 1 || selectedCol < 0 || selectedCol > this.col - 1) {
                System.out.println("Girdiginiz degerler tarlada bulunmuyor :)");
                continue;
            }
            if (isMine(selectedRow, selectedCol)) {
                this.fieldVisible[selectedRow][selectedCol] = String.valueOf(findNeighbour(selectedRow, selectedCol));
                printVisible();
            } else {
                System.out.println("BOOM! Kaybettin.");
                printHidden();
                break;
            }
            if (checkWin()) {
                System.out.println("Kazandiniz! Tebrikler!");
                break;
            }
        }
    }

    boolean isMine(int selectedRow, int selectedCol) {
        if (this.fieldHidden[selectedRow][selectedCol].equals("*")) {
            return false;
        } else if (this.fieldHidden[selectedRow][selectedCol].equals("-")) {
            return true;
        }
        return true;
    }

    int findNeighbour(int a, int b) {
        int nearMine = 0;
        if (a != this.row - 1) {
            if (this.fieldHidden[a + 1][b].equals("*")) {
                nearMine++;
            }
            if (b != this.col - 1) {
                if (this.fieldHidden[a + 1][b + 1].equals("*")) {
                    nearMine++;
                }
            }
            if (b != 0) {
                if (this.fieldHidden[a + 1][b - 1].equals("*")) {
                    nearMine++;
                }
            }
        }

        if (a != 0) {
            if (this.fieldHidden[a - 1][b].equals("*")) {
                nearMine++;
            }
            if (b != this.col - 1) {
                if (this.fieldHidden[a - 1][b + 1].equals("*")) {
                    nearMine++;
                }
            }
            if (b != 0) {
                if (this.fieldHidden[a - 1][b - 1].equals("*")) {
                    nearMine++;
                }
            }
        }

        if (b != 0) {

            if (this.fieldHidden[a][b - 1].equals("*")) {
                nearMine++;
            }

        }
        if (b != this.col - 1) {
            if (this.fieldHidden[a][b + 1].equals("*")) {
                nearMine++;
            }
        }

        return nearMine;
    }

    boolean checkWin() {
        int counterHidden = 0;
        int counterVisible = 0;
        for (int i = 0; i < this.fieldHidden.length; i++) {
            for (int j = 0; j < this.fieldHidden.length; j++) {
                if (this.fieldHidden[i][j].equals("*")) {
                    counterHidden++;
                }
            }
        }
        for (int i = 0; i < this.fieldVisible.length; i++) {
            for (int j = 0; j < this.fieldVisible.length; j++) {
                if (this.fieldVisible[i][j].equals("-")) {
                    counterVisible++;
                }
            }
        }
        return counterHidden == counterVisible;
    }
}


