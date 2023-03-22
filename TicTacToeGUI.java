import javax.swing.*;
import java.awt.*;

public class TicTacToeGUI {

    public JButton[][] makeButtonComponents(){
        JButton[][] buttons = new JButton[3][3];
        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[0].length; c++) {
                buttons[r][c] = new JButton();
                buttons[r][c].setPreferredSize(new Dimension(200, 200));
            }
        }
        return buttons;
    }

    public void addButtonsToPanel(JPanel panel, JButton[][] buttons){
        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[0].length; c++) {
                panel.add(buttons[r][c]);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600,600));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TicTacToeGUI gui = new TicTacToeGUI();
        frame.setLayout(new GridLayout(3,3));
        
        JButton[][] buttons = gui.makeButtonComponents();
        gui.addButtonsToPanel(panel, buttons);

        frame.pack();
        frame.setSize(700,700);
        frame.setVisible(true);
    }
}
