import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class MineSweeper {
    int row;
    int col;
    String[][] fieldVisible;
    String[][] fieldHidden;
    int selectRow = 0;
    int selectCol = 0;

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
        printHidden();
        selectField();
    }


    void plantMine() {
        Random rnd = new Random();
        int mineCount = (this.row * this.col) / 4;
        int i = 0, j = 0;
        while (mineCount >= 0) {
            i = rnd.nextInt(this.row);
            j = rnd.nextInt(this.col);
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

    void selectField() {
        Scanner input = new Scanner(System.in);

        while (true) {

            if (this.selectRow == 0 && this.selectCol == 0){
                System.out.print("Satir: ");
                this.selectRow = input.nextInt();
                System.out.print("Sutun: ");
                this.selectCol = input.nextInt();
            }

            if (!this.fieldHidden[this.selectRow][this.selectCol].equals("*")){
                System.out.print("Satir: ");
                this.selectRow = input.nextInt();
                System.out.print("Sutun: ");
                this.selectCol = input.nextInt();
            }

            else if (this.fieldHidden[this.selectRow][this.selectCol].equals("*")) {
                System.out.println("Game over!");
                break;

            }
        }
    }
}


