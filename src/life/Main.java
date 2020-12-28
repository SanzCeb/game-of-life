package life;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        var scanner = new Scanner(System.in);
        var universeSize = scanner.nextInt();
        var randomSeed = scanner.nextLong();
        var numGenerations = scanner.nextInt();
        GameOfLife.run(universeSize, randomSeed, numGenerations);
    }
}
