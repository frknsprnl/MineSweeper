import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int row,col;

        System.out.print("Satir sayisi: ");
        row = input.nextInt();

        System.out.print("Sutun sayisi: ");
        col = input.nextInt();

        MineSweeper mine = new MineSweeper(row, col);
        mine.run();
    }
}
