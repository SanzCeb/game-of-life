package life.universe;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Stream;

class UniverseGenerator {

    private final int numOfCells;
    private final int universeSize;
    private final Random randomizer;

    UniverseGenerator(int universeSize) {
        this.randomizer = new Random();
        this.universeSize = universeSize;
        this.numOfCells = universeSize * universeSize;

    }

    Cell[][] createUniverse() {
        var universe = new Cell[universeSize][universeSize];
        var randomCells = getRandomCells();
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe.length; j++) {
                universe[i][j] = randomCells.next();
            }
        }
        return universe;
    }

    private Iterator<Cell> getRandomCells() {
        return Stream.generate(randomizer::nextBoolean)
                .map(Cell::new)
                .limit(numOfCells)
                .iterator();
    }

    Cell[][] evolveUniverse(Cell[][] universe) {
        var newUniverse = new Cell[universeSize][universeSize];
        for (int i = 0; i < universeSize; i++) {
            for (int j = 0; j < universeSize; j++) {
                newUniverse[i][j] = evolveCell(universe, i, j);
            }
        }
        return newUniverse;
    }

    private Cell evolveCell(Cell[][] universe, int row, int column) {
        Cell [] neighbors = NeighborsGenerator.getNeighbors(universe, row, column);
        Cell cellToEvolve = universe[row][column];
        boolean isAlive;

        if (cellToEvolve.isAlive()){
            isAlive = !killCell(neighbors);
        } else {
            isAlive = rebirthCell(neighbors);
        }

        return new Cell(isAlive);
    }

    private boolean killCell(Cell[] neighbors) {
        var aliveNeighborsCount = Arrays.stream(neighbors)
                .filter(Cell::isAlive)
                .count();
        return diesOfBoredom(aliveNeighborsCount) ||
                diesOfOverPopulation(aliveNeighborsCount);
    }

    private boolean diesOfOverPopulation(long aliveNeighborsCount) {
        return aliveNeighborsCount > 3;
    }

    private boolean diesOfBoredom(long aliveNeighborsCount) {
        return aliveNeighborsCount < 2;
    }

    private boolean rebirthCell(Cell[] neighbors) {
        return Arrays.stream(neighbors)
                .filter(Cell::isAlive)
                .count() == 3;
    }

}
