public class TicTacToeGame {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public TicTacToeGame(int  type) {
        board = new Board();
        player1 = new Player("Player 1", 'X');
        player2 = new AIPlayer("AIPlayer", 'O');
        currentPlayer = player1;
    }

    public TicTacToeGame() {
        board = new Board();
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        currentPlayer = player1;
    }

    public void startGame() {
        while (!board.isGameOver()) {
            board.displayBoard();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
            int[] move = currentPlayer.getMove();
            if (board.makeMove(move[0], move[1], currentPlayer.getSymbol())) {
                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.displayBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    return;
                }
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        System.out.println("It's a draw!");
    }
}