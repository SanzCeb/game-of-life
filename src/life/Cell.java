package life;

public class Cell {
    private final boolean alive;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public String getRepresentation() {
        return alive ? "O" : " ";
    }

    public boolean isAlive() {
        return alive;
    }

}
