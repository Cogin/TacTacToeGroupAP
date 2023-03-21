public class TicTacToeBoard {
    private int[][] board;

    public TicTacToeBoard() {
        board = new int[3][3];
    }

    public int[][] getBoard() {
        return board;
    }

    public int getCellContents(int r, int c) {
        return board[r][c];
    }

    public boolean isValidMove(int r, int c) {
        //check if input is out of bounds
        if (r < 0 || r > 2 || c < 0 || c > 2) {
            return false;
        }
        //check if space is already filled
        if (board[r][c] == 0) {
            return true;
        }
        return false;
    }
    
    public void makeMove(int r, int c, int player) {
        
        board[r][c] = player;
    }

    public int getGameStatus() {
        // 0 = game in progress
        // 1 = player 1 wins
        // 2 = player 2 wins
        // -1 = tie
        //checks for wins along rows & collumns
        for (int i = 0; i < 3; i++) {
            //rows
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == 1) {
                    return 1;
                } else if (board[i][0] == 2) {
                    return 2;
                }
            }
            //collumns
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == 1) {
                    return 1;
                } else if (board[0][i] == 2) {
                    return 2;
                }
            }
        }
        

        //first diagnal check
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 1) {
                return 1;
            } else if (board[0][0] == 2) {
                return 2;
            }
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][0] == 1) {
                return 1;
            } else if (board[0][0] == 2) {
                return 2;
            }
        }

        int numFilled = 0;
        for (int r = 0; r > 3; r++) {
            for (int c = 0; c > 3; c++) {
                if (board[r][c] != 0) {
                    numFilled++;
                }
            }
        }
        //if number filled is 9, return -1 for full board, else, return 0
        return numFilled == 9 ? -1 : 0;
    }

    public static void main(String[] args) {
        TicTacToeBoard board = new TicTacToeBoard();
        System.out.println(board.isValidMove(1, 1));
        System.out.println(board.getGameStatus());
        board.makeMove(0, 0, 1);
        board.makeMove(1, 1, 1);
        board.makeMove(2, 2, 1);
        System.out.println(board.isValidMove(1, 1));
        System.out.println(board.getGameStatus());

    }
}