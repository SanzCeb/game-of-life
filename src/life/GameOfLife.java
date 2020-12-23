package life;

import java.util.Scanner;

public class GameOfLife {
    public static void run () {
        var scanner = new Scanner(System.in);
        var universeSize = scanner.nextInt();
        var randomSeed = scanner.nextInt();
        Grid grid = new Grid(universeSize, randomSeed);
        grid.generateUniverse();
        printUniverse(grid);
    }

    private static void printUniverse(Grid grid) {
        System.out.println(grid.getUniverse());
    }
}
