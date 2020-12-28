package life.universe;

import life.Cell;

class NeighborsGenerator {

    static Cell[] getNeighbors(Cell[][] universe, int row, int column) {
        return new Cell[] {
                getNWCell(universe, row, column),
                getNorthCell(universe, row, column),
                getNECell(universe, row, column),
                getWestCell(universe, row, column),
                getEastCell(universe, row, column),
                getSWCell(universe, row, column),
                getSouthCell(universe, row, column),
                getSECell(universe, row, column)
        };
    }

    private static Cell getEastCell(Cell[][] universe, int row, int column) {
        int eastColumn;

        if (column == universe.length - 1) {
            eastColumn = 0;
        } else {
            eastColumn = column + 1;
        }

        return universe[row][eastColumn];
    }

    private static Cell getSWCell(Cell[][] universe, int row, int column) {
        int southRow;
        int westColumn = westColumn(universe.length, column);

        if (row == universe.length - 1) {
            southRow = 0;
        } else {
            southRow = row + 1;
        }

        return universe[southRow][westColumn];
    }

    private static Cell getSouthCell(Cell[][] universe, int row, int column) {
        int southRow;

        if (row == universe.length - 1) {
            southRow = 0;
        } else {
            southRow = row + 1;
        }

        return universe[southRow][column];
    }

    private static Cell getSECell(Cell[][] universe, int row, int column) {
        int southRow;
        int eastColumn;

        if (row == universe.length - 1) {
            southRow = 0;
        } else {
            southRow = row + 1;
        }

        if (column == universe.length - 1) {
            eastColumn = 0;
        } else {
            eastColumn = column + 1;
        }

        return universe[southRow][eastColumn];
    }

    private static Cell getWestCell(Cell[][] universe, int row, int column) {
        int westColumn = westColumn(universe.length, column);
        return universe[row][westColumn];
    }

    private static Cell getNorthCell(Cell[][] universe, int row, int column) {
        int northRow = northRow(universe.length, row);
        return universe[northRow][column];
    }

    private static Cell getNECell(Cell[][] universe, int row, int column) {
        int northRow = northRow(universe.length, row);
        int eastColumn;

        if (column == universe.length - 1) {
            eastColumn = 0;
        } else {
            eastColumn = column + 1;
        }

        return universe[northRow][eastColumn];
    }

    private static Cell getNWCell(Cell[][] universe, int row, int column) {
        int northRow = northRow(universe.length, row);
        int westColumn = westColumn(universe.length, column);

        return universe[northRow][westColumn];
    }

    private static int northRow(int universeSize, int row) {
        var northRow = row == 0 ? universeSize  : row;
        return northRow - 1;
    }

    private static int westColumn(int universeSize, int column) {
        return adjacentPosition(column == 0, universeSize , column);
    }

    private static int adjacentPosition(boolean border, int universeSize, int position) {
        return border ? universeSize - 1 : position;
    }
}
