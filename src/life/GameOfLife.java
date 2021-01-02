package life;

import life.universe.Universe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameOfLife extends JFrame {

    private final JLabel numGenerationLabel;
    private final JLabel aliveCountLabel;
    private final GameOfLifeGrid gridHolder;
    private final JToggleButton playToggleButton;
    private final JButton resetButton;
    private final JButton nextGenButton;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(900, 680));
        setResizable(false);
        this.numGenerationLabel = new JLabel("Generation #0", JLabel.LEFT);
        this.aliveCountLabel = new JLabel("Alive: 0", JLabel.LEFT);
        numGenerationLabel.setName("GenerationLabel");
        aliveCountLabel.setName("AliveLabel");
        this.playToggleButton = new JToggleButton();
        this.playToggleButton.setName("PlayToggleButton");
        this.playToggleButton.setText("Play/Pause");
        this.resetButton = new JButton("Reset");
        this.resetButton.setName("ResetButton");
        this.gridHolder = new GameOfLifeGrid();
        this.nextGenButton = new JButton("Next");
        var pane = getContentPane();

        pane.setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        pane.add(nextGenButton, constraints);

        constraints.gridx = 1;
        pane.add(playToggleButton, constraints);

        constraints.gridx = 2;
        pane.add(resetButton, constraints);

        constraints.gridwidth = 6;
        constraints.gridheight = 6;
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.ipadx = 40;
        constraints.insets = new Insets(10, 10, 10,  0);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.FIRST_LINE_END;
        pane.add(gridHolder, constraints);


        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.ipadx = 0;
        constraints.insets = new Insets(5, 5, 5, 0);
        constraints.anchor = GridBagConstraints.LINE_START;
        pane.add(numGenerationLabel, constraints);

        constraints.gridy = 2;
        constraints.insets = new Insets(0, 5, 0, 0);
        pane.add(aliveCountLabel, constraints);
        setVisible(true);
   }

    public void setGenerationCount(int numGeneration) {
        this.numGenerationLabel.setText(String.format("Generation #%d", numGeneration));
    }

    public void setAliveCount(long aliveCount) {
        this.aliveCountLabel.setText(String.format("Alive: %d", aliveCount));
    }

    public void addTogglePlayListener (ActionListener actionListener) {
        this.playToggleButton.addActionListener(actionListener);
    }

    public GameOfLifeGrid getGridHolder() {
        return gridHolder;
    }

    public void addResetListener(ActionListener actionListener){
        this.resetButton.addActionListener(actionListener);
    }


    private static void createAndShowGUI() {
        var universeSize = 150;
        Universe universe = new Universe(universeSize);
        GameOfLife gui = new GameOfLife();
        new GameOfLifeController(universe, gui);
    }

    public void addNextListener(ActionListener nextListener) {
        this.nextGenButton.addActionListener(nextListener);
    }
    public JToggleButton getPlayToggleButton() {
        return playToggleButton;
    }
    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater(GameOfLife::createAndShowGUI);
    }

}
