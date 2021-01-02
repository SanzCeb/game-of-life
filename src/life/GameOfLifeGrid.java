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
        int size = Math.min(cellHeight, cellWidth);
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe.length; j++) {
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(j * size, i * size,  size, size);
                g.setColor(universe[i][j].isAlive() ? Color.BLACK : Color.WHITE);
                g.fillRect(j * size, i * size,  size, size);
            }
        }
    }

    public void setUniverse (Universe universe) {
        this.universe = universe.getUniverse();
    }
}
