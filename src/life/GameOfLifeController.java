package life;

import life.universe.Universe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLifeController {
    private Universe universe;
    private final GameOfLife gui;
    private int refreshPeriod = 500;
    private Timer timer;

    public GameOfLifeController(Universe universe, GameOfLife gui) {
        this.universe = universe;
        this.gui = gui;
        this.gui.addTogglePlayListener(new TogglePlayListener());
        this.gui.addResetListener(new ResetListener());
        this.gui.addNextListener(new NextListener());
        this.gui.getGridHolder().setUniverse(universe);
        this.timer = new Timer(refreshPeriod, e -> {
            evolveUniverse();
            paintUniverse();
        });
        paintUniverse();
    }

    public void evolveUniverse() {
            this.universe.evolve();
    }

    public void paintUniverse() {
            refreshCounters();
            this.gui.getGridHolder().setUniverse(universe);
            this.gui.revalidate();
            this.gui.repaint();
    }

    public long getRefreshPeriod() {
        return refreshPeriod;
    }

    private class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (timer.isRunning()) {
                timer.stop();
            }
            gui.getPlayToggleButton().setSelected(false);
            universe = new Universe(universe.getUniverse().length);
            paintUniverse();
        }
    }

    private void refreshCounters() {
        gui.setGenerationCount(universe.getNumGeneration());
        gui.setAliveCount(universe.aliveCount());
    }


    private class  NextListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (!timer.isRunning()) {
                evolveUniverse();
                paintUniverse();
            }
        }
    }

    private class TogglePlayListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
                if (gui.getPlayToggleButton().isSelected()) {
                    timer.start();
                } else {
                    timer.stop();
                }
        }
    }
}
