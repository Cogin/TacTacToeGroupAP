import java.util.Scanner;


public class TicTacToeConsole {
    private TicTacToeBoard board;
    private static String[] players;
    private int player1;
    private int player2;
    private String move;


    public TicTacToeConsole(TicTacToeBoard board, String turn) {
        this.board = board;
        this.player1 = 1;
        this.player2 = 2;
        this.move = turn;
        players = new String[2];
    }


    public int getPlayer1() {
        return player1;
    }


    public int getPlayer2() {
        return player2;
    }


    public static String[] getPlayers() {
        return players;
    }


    public String getMove() {


        return move;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Enter player one:");
        players[0] = input.nextLine();
        System.out.println("Enter player two:");
        players[1] = input.nextLine();
        while () {
           
        }
    }
}
