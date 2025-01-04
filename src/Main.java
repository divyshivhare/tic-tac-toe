import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Select game mode:");
            System.out.println("1. For two players");
            System.out.println("2. For AI mode");
            System.out.println("3. Exit");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    TicTacToeGame game = new TicTacToeGame();
                    game.startGame();
                    break;
                case 2:
                    System.out.println("AI mode is under development.");
                    TicTacToeGame aiGame = new TicTacToeGame(1);
                    aiGame.startGame();
                    break;
                case 3:
                    System.out.println("Exiting the game. ");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }
}
