package life;

import life.universe.Universe;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {

    private final JLabel numGenerationLabel;
    private final JLabel aliveCountLabel;
    private final JPanel gridHolder;
    private JPanel[][] cellsGrid;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        this.numGenerationLabel = new JLabel("Generation #0");
        this.aliveCountLabel = new JLabel("0");
        numGenerationLabel.setName("GenerationLabel");
        aliveCountLabel.setName("AliveLabel");


        this.gridHolder = new JPanel();
        gridHolder.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(numGenerationLabel);
        add(aliveCountLabel);
        add(gridHolder);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);
    }

    private void initCellsGrid(int universeSize) {
        cellsGrid = new JPanel[universeSize][universeSize];
        gridHolder.setLayout(new GridLayout(universeSize, universeSize, 0, 0));
        for (int i = 0; i < universeSize; i++) {
            for (int j = 0; j < universeSize; j++) {
                cellsGrid[i][j] = new JPanel();
                cellsGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                gridHolder.add(cellsGrid[i][j]);
            }
        }
    }

    public void setGenerationCount(int numGeneration) {
        this.numGenerationLabel.setText(String.format("Generation #%d", numGeneration));
    }

    public void setAliveCount(long aliveCount) {
        this.aliveCountLabel.setText(String.format("Alive: %d", aliveCount));
    }

    public JPanel getSquare(int i, int j) {
        return cellsGrid[i][j];
    }

    public static void main (String[] args) {
        var universeSize = 20;
        Universe universe = new Universe(universeSize);
        GameOfLife gui = new GameOfLife();
        gui.initCellsGrid(universeSize);
        var controller = new GameOfLifeController(universe, gui);
        while (true) {
            controller.paintUniverse();
            controller.evolveUniverse();
            sleepThread(500);
        }
    }

    private static void sleepThread(long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException ignored) {}
    }
}
