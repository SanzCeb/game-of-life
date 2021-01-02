package life;

import life.universe.Universe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLifeController {
    private Universe universe;
    private final GameOfLife gui;
    private boolean play;
    private long refreshPeriod = 500L;

    public GameOfLifeController(Universe universe, GameOfLife gui) {
        this.universe = universe;
        this.gui = gui;
        this.gui.addTogglePlayListener(e -> play = !play);
        this.gui.addResetListener(new ResetListener());
        this.gui.addNextListener(new NextListener());
        this.gui.getGridHolder().setUniverse(universe);

        play = true;
        paintUniverse();
        play = false;
    }

    public void evolveUniverse() {
        if (play) {
            this.universe.evolve();
        }
    }

    public void paintUniverse() {
        if (play) {
            refreshCounters();
            this.gui.getGridHolder().setUniverse(universe);
            this.gui.revalidate();
            this.gui.repaint();
        }
    }

    public long getRefreshPeriod() {
        return refreshPeriod;
    }

    private class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            universe = new Universe(universe.getUniverse().length);
            play = true;
            paintUniverse();
            play = false;

        }
    }

    private void refreshCounters() {
        gui.setGenerationCount(universe.getNumGeneration());
        gui.setAliveCount(universe.aliveCount());
    }


    private class  NextListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (!play) {
                play = true;
                universe.evolve();
                paintUniverse();
                play = false;
            }
        }
    }
}
