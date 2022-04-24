import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int row = 0,col = 0;

        while (true){
            System.out.print("Satir sayisi: ");
            row = input.nextInt();

            System.out.print("Sutun sayisi: ");
            col = input.nextInt();

            if (row <= 0 || col <= 0){
                System.out.println("Satir ve sutun degerleri 0'dan buyuk olmalidir.");
            } else {
                break;
            }

        }

        MineSweeper mine = new MineSweeper(row, col);
        mine.run();
    }
}
