package life;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        var scanner = new Scanner(System.in);
        var universeSize = scanner.nextInt();
        var numGenerations = 10;
        GameOfLife.run(universeSize, numGenerations);
    }
}
