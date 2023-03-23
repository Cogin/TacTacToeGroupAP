import java.util.Scanner;


public class TicTacToeConsole {
    private TicTacToeBoard board;
    private String[] players;
    private int[] playerMove;

    public TicTacToeConsole(TicTacToeBoard board,int turn) {
        this.board = board;
        this.players = new String[2];
        this.playerMove = new int[2];
    }

    public String[] getPlayers() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter player one:");
        players[0] = input.nextLine();
        System.out.println("Enter player two:");
        players[1] = input.nextLine();
        return players;
    }

    public void Player1(int x, int y, int turn) {
        if (board.isValidMove(x, y)) {
            board.makeMove(x, y, 1);
        }
        else {
            System.out.println("Invalid move!");
            getPlayerMoves(turn);
            Player1(playerMove[0], playerMove[1], turn);
            printBoard();
        }
    }

    public void Player2(int x, int y, int turn) {
        if (board.isValidMove(x, y)) {
                board.makeMove(x, y, 2);
        }
        else {
            System.out.println("Invalid move!");
            getPlayerMoves(turn);
            printBoard();
            Player2(playerMove[0], playerMove[1], turn);
        }
    }

    public int[] getPlayerMoves(int turn) {
        Scanner input = new Scanner(System.in);
        int player = 0;
        if (turn == 2) {
            player = 1;
        }
        System.out.println("Enter a row for " + players[player] + ":");
        playerMove[0] = input.nextInt();
        System.out.println("Enter a column for " + players[player] + ":");
        playerMove[1] = input.nextInt();
        return playerMove;
    }

    public void printBoard() {
        System.out.println("\t 0 \t\t 1 \t\t 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " \t");
            for (int j = 0; j < 3; j++) {
                if (board.getBoard()[i][j] == 0) {
                    System.out.print(" * \t");
                }
                else if (board.getBoard()[i][j] == 1) {
                    System.out.print(" X \t");
                }
                else if (board.getBoard()[i][j] == 2) {
                    System.out.print(" O \t");
                }
                if (j < 2) {
                    System.out.print("| \t");
                }
            }
            System.out.println();
        }
    }

    public void play() {
        int turn = 1;
        while (board.getGameStatus() == 0) {
            printBoard();
            if (board.getGameStatus() == 0) {
                getPlayerMoves(turn);
                Player1(playerMove[0], playerMove[1], turn);
                turn = 2;
            }
            printBoard();
            if (board.getGameStatus() == 0) {
                getPlayerMoves(turn);
                Player2(playerMove[0], playerMove[1], turn);
                turn = 1;
            }
        }
    }

    public static void main(String[] args) {
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeConsole game = new TicTacToeConsole(board,1);
        game.getPlayers();
        game.play();
    }
}
