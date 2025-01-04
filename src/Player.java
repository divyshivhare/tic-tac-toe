import java.util.Scanner;

public class Player {
    private final String name;
    private final char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int[] getMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row and column (0, 1, or 2): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }
}
