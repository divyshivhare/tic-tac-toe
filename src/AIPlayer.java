public class AIPlayer extends Player {
    public AIPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int[] getMove() {
        System.out.println(getName() + "'s turn (" + getSymbol() + ") [AI]");
        char[][] grid = Board.getGrid();
        char opponentSymbol = (getSymbol() == 'X') ? 'O' : 'X';
        // 1. Check for a winning move
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (Board.isCellEmpty(row, col)) {
                    grid[row][col] = getSymbol();
                    if (Board.checkWin(getSymbol())) {
                        grid[row][col] = ' ';
                        return new int[]{row, col};
                    }
                    grid[row][col] = ' ';
                }
            }
        }
        // 2. Block the opponent's winning move
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (Board.isCellEmpty(row, col)) {
                    grid[row][col] = opponentSymbol;
                    if (Board.checkWin(opponentSymbol)) {
                        grid[row][col] = ' ';
                        return new int[]{row, col};
                    }
                    grid[row][col] = ' ';
                }
            }
        }
        // 3. Pick the first available cell
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (Board.isCellEmpty(row, col)) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
