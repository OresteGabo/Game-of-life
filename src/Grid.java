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
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = new Cell(new Position(i,j));

                if (i <= (rows / 2) + 1 && i >= (rows / 2) - 1) {
                    if (j <= (cols / 2) + 1 && j >= (cols / 2) - 1) {
                        int rdm = random.nextInt(2);
                        if (rdm == 1) {
                            cell.setAlive(true);
                        }
                        System.out.println(rdm);
                    }
                }
                data[i][j] = cell;
            }
        }
    }


    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

}
