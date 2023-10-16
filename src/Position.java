public class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Position getNorth() {
        return new Position(row - 1, col);
    }

    public Position getSouth() {
        return new Position(row + 1, col);
    }

    public Position getEast() {
        return new Position(row, col + 1);
    }

    public Position getWest() {
        return new Position(row, col - 1);
    }

    public Position getNorthWest() {
        return new Position(row - 1, col - 1);
    }

    public Position getNorthEast() {
        return new Position(row - 1, col + 1);
    }

    public Position getSouthEast() {
        return new Position(row + 1, col + 1);
    }

    public Position getSouthWest() {
        return new Position(row + 1, col - 1);
    }
}
