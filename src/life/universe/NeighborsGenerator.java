package life.universe;

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
        int eastColumn = endBorder(universe.length, column);
        return universe[row][eastColumn];
    }

    private static Cell getSWCell(Cell[][] universe, int row, int column) {
        int southRow = endBorder(universe.length, row);
        int westColumn = beginBorder(universe.length, column);
        return universe[southRow][westColumn];
    }

    private static Cell getSouthCell(Cell[][] universe, int row, int column) {
        int southRow = endBorder(universe.length, row);
        return universe[southRow][column];
    }

    private static Cell getSECell(Cell[][] universe, int row, int column) {
        int southRow = endBorder(universe.length, row);
        int eastColumn = endBorder(universe.length, column);
        return universe[southRow][eastColumn];
    }

    private static Cell getWestCell(Cell[][] universe, int row, int column) {
        int westColumn = beginBorder(universe.length, column);
        return universe[row][westColumn];
    }

    private static Cell getNorthCell(Cell[][] universe, int row, int column) {
        int northRow = beginBorder(universe.length, row);
        return universe[northRow][column];
    }

    private static Cell getNECell(Cell[][] universe, int row, int column) {
        int northRow = beginBorder(universe.length, row);
        int eastColumn = endBorder(universe.length, column);

        return universe[northRow][eastColumn];
    }

    private static Cell getNWCell(Cell[][] universe, int row, int column) {
        int northRow = beginBorder(universe.length, row);
        int westColumn = beginBorder(universe.length, column);
        return universe[northRow][westColumn];
    }

    private static int beginBorder(int universeSize, int axis) {
        int beginBorder = axis == 0 ? universeSize : axis;
        return beginBorder - 1;
    }

    private static int endBorder(int universeSize, int axis) {
        return axis == universeSize - 1 ? 0 : axis + 1;
    }
}
