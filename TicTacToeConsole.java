import java.util.Scanner;


public class TicTacToeConsole {
    private static TicTacToeBoard board;

    public TicTacToeConsole(TicTacToeBoard board, String turn) {
        this.board = board;
    }

    public static void main(String[] args) {
        TicTacToeBoard board = new TicTacToeBoard();
        String[] players = new String[2];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter player one:");
        players[0] = input.nextLine();
        System.out.println("Enter player two:");
        players[1] = input.nextLine();
        int turn = 1;
        System.out.println("Welcome to Tic Tac Toe!");
        while (board.getGameStatus() == 0) {
            if (turn == 1) {
                System.out.println("Enter a row for " + players[0] + ":");
                int row = input.nextInt();
                System.out.println("Enter a column for " + players[0] + ":");
                int col = input.nextInt();
                if (board.isValidMove(row, col)) {
                    board.makeMove(row, col, 1);
                    turn = 0;
                }
                else {
                    System.out.println("Invalid move!");
                }
            }
            else {
                System.out.println("Enter a row for " + players[1] + ":");
                int row = input.nextInt();
                System.out.println("Enter a column for " + players[1] + ":");
                int col = input.nextInt();
                if (board.isValidMove(row, col)) {
                    board.makeMove(row, col, 2);
                    turn = 1;
                }
                else {
                    System.out.println("Invalid move!");
                }
            }
        }       
    }
}
