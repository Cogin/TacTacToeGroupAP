import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TicTacToeGUI {
    private JFrame frame;
    private JLabel Label;
    
    private TicTacToeBoard board;
    private String[] players;
    private JButton[][] buttons;
    private boolean player1Turn;

    private Color LightColor = Color.decode("#9896B4");
    
    private Color MidColor = Color.decode("#77C4D2");
    
    private Color DarkColor = Color.decode("#66ced6");

    private String XIcon = "✖";
    private String OIcon = "◯";

    final JOptionPane optionPane = new JOptionPane("Play Again?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);


    public TicTacToeGUI(TicTacToeBoard board) {
        players = new String[2];
        this.board = board;
        player1Turn = true;
    }

    public void MakeGUI() {
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel gamePanel = new JPanel();
        gamePanel.setSize(new Dimension(600,550));
        frame.add(gamePanel);

        gamePanel.setBackground(DarkColor);


        makeButtonComponents();

        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[0].length; c++) {
                gamePanel.add(buttons[r][c]);
            }
        }

        JPanel infoPanel = new JPanel();
        infoPanel.setSize(new Dimension(600, 200));
        frame.add(infoPanel, BorderLayout.SOUTH);
        infoPanel.setBackground(DarkColor);

        Label = new JLabel("X's turn", SwingConstants.CENTER);
        Label.setFont(new Font("Courier", Font.BOLD, 80));
        Label.setBackground(DarkColor);
        frame.add(Label, BorderLayout.SOUTH);

        frame.pack();
        frame.setSize(700,800);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void setIcons(String XIcon, String OIcon) {
        this.XIcon = XIcon;
        this.OIcon = OIcon;
    }

    public void buttonListener(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (button == buttons[r][c]) {
                    if (board.isValidMove(r, c)) {
                        if (player1Turn) {
                            button.setText(XIcon);
                            Label.setText("O's turn");
                            board.makeMove(r, c, 1);
                            player1Turn = false;
                        }
                        else {
                            button.setText(OIcon);
                            Label.setText("X's turn");
                            board.makeMove(r, c, 2);
                            player1Turn = true;
                        }
                    }
                }
            }
        }



        //checkl if game is over
        if (board.getGameStatus() != 0) {
            int result;
            if (board.getGameStatus() == 1) {
                result = JOptionPane.showConfirmDialog(null, "X wins! \n Play Again?", "Game Over", JOptionPane.YES_NO_OPTION);
            } else if (board.getGameStatus() == 2) {
                result = JOptionPane.showConfirmDialog(null, "O wins! \n Play Again?", "Game Over", JOptionPane.YES_NO_OPTION);
            } else {
                result = JOptionPane.showConfirmDialog(null, "Tie! \n Play Again?", "Game Over", JOptionPane.YES_NO_OPTION);
            }
            
            if (result == 0) {
                resetBoard();
            } else {
                frame.dispose();
            }
            
        }
    }

    public void resetBoard() {
        board = new TicTacToeBoard();
        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[0].length; c++) {
                buttons[r][c].setText(" ");
            }
        }
        player1Turn = true;
        Label.setText("X's turn");
    }

    public void exitGame() {
        frame.dispose();
    }

    public void makeButtonComponents(){
        buttons = new JButton[3][3];
        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[0].length; c++) {
                buttons[r][c] = new JButton();
                buttons[r][c].setPreferredSize(new Dimension(200, 200));
                buttons[r][c].setText(" ");
                buttons[r][c].setFont(new Font("Courier", Font.BOLD,75));
                buttons[r][c].setBackground(LightColor);
                buttons[r][c].setFocusable(false);
                buttons[r][c].setBorder(BorderFactory.createLineBorder(MidColor, 5));
                buttons[r][c].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        buttonListener(e);
                    }
                });
            }
        }
    }



    public void addButtonsToPanel(JPanel panel){
        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[0].length; c++) {
                panel.add(buttons[r][c]);
            }
        }
    }

    public static void main(String[] args) {
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeGUI gui = new TicTacToeGUI(board);
        
        gui.MakeGUI();
        //restart program
    }
}
