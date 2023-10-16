import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private JFrame frame;
    private JPanel gridPanel;
    private Grid grid;
    private JButton playButton;
    private JButton restartButton;

    public Main(Grid grid) {
        this.grid = grid;

        vue();
        Handler handler = new Handler();
        playButton.addActionListener(handler);
        restartButton.addActionListener(handler);
    }
    public void refresh() {
        for (int r = 0; r < grid.getRows(); r++) {
            for (int c = 0; c < grid.getCols(); c++) {
                getButtonAt(r,c).setBackground(grid.data[r][c].isAlive()? Color.BLACK: Color.WHITE);
                getButtonAt(r,c).setText(""+grid.data[r][c].getSurroundingAliveCount());
            }
        }
    }
    public JButton getButtonAt(int row, int col) {
        int index = row * grid.getCols() + col;
        if (index >= 0 && index < gridPanel.getComponentCount()) {
            return (JButton) gridPanel.getComponent(index);
        } else {
            System.out.printf("Button row:%d col:%d doenst exist",row,col);
            return null; // Button not found
        }
    }


    public void restart() {
        grid.restart();
        for (int r = 0; r < grid.getRows(); r++) {
            for (int c = 0; c < grid.getCols(); c++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(45, 45));
                button.setEnabled(false);
                gridPanel.add(button);
                grid.data[r][c].setSurroundingAliveCount(getNumberAroundAliveCells(r,c));
            }
        }

        refresh();
    }
    public int getNumberAroundAliveCells(int row, int col) {
        int aliveCount = 0;

        int numRows = grid.getRows();
        int numCols = grid.getCols();



        return aliveCount;
    }

    private void vue() {
        frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gridPanel = new JPanel(new GridLayout(grid.getRows(), grid.getCols()));

        restart();
        refresh();

        JScrollPane scrollPane = new JScrollPane(gridPanel);

        JPanel controlPanel = new JPanel();
        playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.BOLD, 20));
        controlPanel.add(playButton);

        restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Arial", Font.BOLD, 20));

        controlPanel.add(restartButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Grid grid = new Grid(20, 40);
        Main main = new Main(grid);
    }

    private class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == playButton) {
                System.out.println("Play button clicked");
                refresh();
            } else if (e.getSource() == restartButton) {
                System.out.println("Restart button clicked");
                restart();
            }
        }
    }
}




