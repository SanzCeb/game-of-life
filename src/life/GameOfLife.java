package life;

import life.universe.Universe;
import java.io.IOException;

public class GameOfLife {

    public static void run (int universeSize, int numGenerations) {
        Universe universe = new Universe(universeSize);
        int generationNumber = 1;
        while (numGenerations > 0) {
            printGenerationNumber(generationNumber);
            printAliveCount(universe);
            printUniverse(universe);
            sleepThread(600);
            clearConsole();
            universe.evolve();
            numGenerations--;
            generationNumber++;
        }

    }

    private static void printAliveCount(Universe universe) {
        System.out.printf("Alive: %d%n%n", universe.aliveCount());
    }

    private static void printGenerationNumber(int generationNumber) {
        System.out.printf("Generation: #%d%n", generationNumber);

    }

    private static void printUniverse(Universe universe) {
        System.out.println(universe.getUniverse());
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    private static void sleepThread(long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException ignored) {}
    }
}
