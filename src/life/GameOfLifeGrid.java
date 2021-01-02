package life;

import life.universe.Cell;
import life.universe.Universe;

import javax.swing.*;
import java.awt.*;

public class GameOfLifeGrid extends JPanel {
    private Cell[][] universe;
    public GameOfLifeGrid() {
        this.setLayout(new GridBagLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellHeight = getSize().height / universe.length;
        int cellWidth = getSize().width / universe.length;

        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe.length; j++) {
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(j * cellWidth, i * cellHeight,  cellWidth, cellHeight);
                g.setColor(universe[i][j].isAlive() ? Color.BLACK : Color.WHITE);
                g.fillRect(j * cellWidth, i * cellHeight,  cellWidth, cellHeight);
            }
        }
    }

    public void setUniverse (Universe universe) {
        this.universe = universe.getUniverse();
    }
}
