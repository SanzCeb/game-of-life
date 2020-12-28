package life.universe;

import life.Cell;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Universe {
    private Cell[][] universe;
    private final UniverseGenerator generator;

    public Universe(int universeSize) {
        this.generator = new UniverseGenerator(universeSize);
        this.universe = generator.createUniverse();
    }

    public void evolve() {
        universe = generator.evolveUniverse(universe);
    }

    public String getUniverse() {
        return Arrays.stream(universe)
                .map(cellsRow -> Arrays.stream(cellsRow)
                        .map(Cell::getRepresentation)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public long aliveCount() {
        return Arrays.stream(universe)
            .map(Arrays::stream)
            .flatMap(row -> row.filter(Cell::isAlive))
            .count();
    }

}
