package life.universe;

import java.util.Arrays;

public class Universe {
    private Cell[][] universe;
    private final UniverseGenerator generator;
    private int numGeneration;

    public Universe(int universeSize) {
        this.generator = new UniverseGenerator(universeSize);
        this.universe = generator.createUniverse();
        this.numGeneration = 1;
    }

    public void evolve() {
        universe = generator.evolveUniverse(universe);
        numGeneration++;
    }

    public long aliveCount() {
        return Arrays.stream(universe)
            .map(Arrays::stream)
            .flatMap(row -> row.filter(Cell::isAlive))
            .count();
    }

    public int getNumGeneration() {
        return numGeneration;
    }

    public Cell[][] getUniverse() {
        return universe;
    }
}
