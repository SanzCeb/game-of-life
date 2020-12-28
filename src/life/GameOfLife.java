package life;

import life.universe.Universe;

public class GameOfLife {
    public static void run (int universeSize, long randomSeed, int numGenerations) {
        Universe universe = new Universe(universeSize, randomSeed);

        while (numGenerations > 0) {
            universe.evolve();
            numGenerations--;
        }

        printUniverse(universe);

    }

    private static void printUniverse(Universe universe) {
        System.out.println(universe.getUniverse());
    }
}
