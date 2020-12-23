package life;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid {
    private final Cell[][] universe;
    private final int randomSeed;
    private final int numOfCells;
    public Grid(int universeSize, int randomSeed) {
        this.universe = new Cell[universeSize][universeSize];
        this.randomSeed = randomSeed;
        numOfCells = universeSize * universeSize;
    }

    public void generateUniverse() {
        var randomStates = generateCellsStates();
        var randomCells = generateRandomCells(randomStates);
        initUniverse(randomCells);
    }

    private void initUniverse(Iterator<Cell> randomCells) {
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe.length; j++) {
                universe[i][j] = randomCells.next();
            }
        }
    }

    private Iterator<Cell> generateRandomCells(IntStream randomStates) {
        return randomStates.mapToObj( state -> state == 1)
                .map(Cell::new)
                .iterator();
    }

    private IntStream generateCellsStates() {
        var randomObject = new Random(randomSeed);
        return IntStream.generate(randomObject::nextInt)
                .map(number -> number & 1)
                .limit(numOfCells);
    }

    public String getUniverse() {
        return Arrays.stream(universe)
                .map(cellsRow -> Arrays.stream(cellsRow).map(Cell::getRepresentation)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
