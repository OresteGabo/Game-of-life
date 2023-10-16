import java.util.Random;

class Grid {
    int rows;
    int cols;
    Cell[][] data;

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell[][] getData() {
        return data;
    }

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new Cell[rows][cols];
        restart();
    }

    public void restart() {
        data =new Cell[rows][cols];
        Random random=new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = new Cell(new Position(i,j));

                if (i <= (rows / 2) + 1 && i >= (rows / 2) - 1) {
                    if (j <= (cols / 2) + 1 && j >= (cols / 2) - 1) {
                        int rdm = random.nextInt(2);
                        if (rdm == 1) {
                            cell.setAlive(true);
                        }
                    }
                }
                data[i][j] = cell;
            }
        }
        setRandomLife();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell=getCellAt(new Position(i,j));
                setCellssurroundingAliveCount(cell);
            }
        }
    }
    public int getNumberAroundAliveCells(int row, int col) {
        int aliveCount = 0;

        Position cellPosition = new Position(row, col);

        // Define the relative positions of cells around the given cell
        Position[] neighbors = {
                cellPosition.getNorth(),
                cellPosition.getSouth(),
                cellPosition.getEast(),
                cellPosition.getWest(),
                cellPosition.getNorthWest(),
                cellPosition.getNorthEast(),
                cellPosition.getSouthEast(),
                cellPosition.getSouthWest()
        };

        for (Position neighbor : neighbors) {
            if (isValidCell(neighbor.getRow(), neighbor.getCol()) && data[neighbor.getRow()][neighbor.getCol()].isAlive()) {
                aliveCount++;
            }
        }
        data[rows][cols].setSurroundingAliveCount(aliveCount);
        return aliveCount;
    }

    private void setCellssurroundingAliveCount(Cell cell) {
        int counter = 0;
        Position north = cell.getPosition().getNorth();
        Position south = cell.getPosition().getSouth();
        Position east = cell.getPosition().getEast();
        Position west = cell.getPosition().getWest();
        Position northWest = cell.getPosition().getNorthWest();
        Position northEast = cell.getPosition().getNorthEast();
        Position southEast = cell.getPosition().getSouthEast();
        Position southWest = cell.getPosition().getSouthWest();

        // Check each of the surrounding positions and count the alive cells
        if (getCellAt(north) != null && getCellAt(north).isAlive()) counter++;
        if (getCellAt(south) != null && getCellAt(south).isAlive()) counter++;
        if (getCellAt(east) != null && getCellAt(east).isAlive()) counter++;
        if (getCellAt(west) != null && getCellAt(west).isAlive()) counter++;
        if (getCellAt(northWest) != null && getCellAt(northWest).isAlive()) counter++;
        if (getCellAt(northEast) != null && getCellAt(northEast).isAlive()) counter++;
        if (getCellAt(southEast) != null && getCellAt(southEast).isAlive()) counter++;
        if (getCellAt(southWest) != null && getCellAt(southWest).isAlive()) counter++;

        cell.setSurroundingAliveCount(counter);
    }

    private void setRandomLife(){
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell=getCellAt(new Position(i,j));
                if (i <= (rows / 2) + 1 && i >= (rows / 2) - 1) {
                    if (j <= (cols / 2) + 1 && j >= (cols / 2) - 1) {
                        int rdm = random.nextInt(2);
                        if (rdm == 1) {
                            cell.setAlive(true);
                        }
                    }
                }
            }
        }
    }
    public Cell getCellAt(Position position) {
        int row = position.getRow();
        int col = position.getCol();

        if (isValidCell(row, col)) {
            return data[row][col];
        } else {
            return null; // Cell not found at the given position
        }
    }


    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

}
