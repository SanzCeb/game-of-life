package life;

import life.universe.Universe;

import java.awt.*;

public class GameOfLifeController {
    private final Universe universe;
    private final GameOfLife gui;

    public GameOfLifeController(Universe universe, GameOfLife gui) {
        this.universe = universe;
        this.gui = gui;
    }

    public void evolveUniverse() {
        this.universe.evolve();
    }

    public void paintUniverse() {
        gui.setGenerationCount(universe.getNumGeneration());
        gui.setAliveCount(universe.aliveCount());
        paintGrid(universe);
    }

    private void paintGrid(Universe universe) {
        var cells = universe.getUniverse();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                var newColor = cells[i][j].isAlive() ? Color.BLACK : Color.WHITE;
                gui.getSquare(i, j).setBackground(newColor);
            }
        }
    }

}
