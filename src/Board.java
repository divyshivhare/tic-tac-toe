import java.util.Arrays;

public class Board {
    private static  char[][] grid;
    private static final int SIZE = 3;

    public Board() {
        grid = new char[SIZE][SIZE];
        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }
    }

    public static boolean isCellEmpty(int row, int col) {
        if(grid[row][col] == ' ')
            return true;
        return false;
    }

    public static char[][] getGrid() {
        return grid;
    }

    public void displayBoard() {
        int size = grid.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + grid[i][j]);
                if (j < size - 1) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("------------");
            }
        }
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || grid[row][col] != ' ') {
            return false;
        }
        grid[row][col] = symbol;
        return true;
    }

    public static boolean checkWin(char symbol) {
        int size = grid.length;

        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            boolean colWin = true;

            for (int j = 0; j < size; j++) {
                if (grid[i][j] != symbol) rowWin = false;
                if (grid[j][i] != symbol) colWin = false;
            }
            if (rowWin || colWin) {
                return true;
            }
        }
        boolean diagonal1Win = true;
        boolean diagonal2Win = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][i] != symbol) diagonal1Win = false;
            if (grid[i][size - 1 - i] != symbol) diagonal2Win = false;
        }
        return diagonal1Win || diagonal2Win;
    }

    public boolean isGameOver() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
