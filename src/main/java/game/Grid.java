package game;

public class Grid {

    private boolean[][] cells; 
    private int size;

    public Grid(int size) {
        this.size = size;
        this.cells = new boolean[size][size]; 
    }
    public int getSize() {
        return this.size;
    }
    public void updateCell(int row, int col, boolean isAlive) {
        this.cells[row][col] = isAlive;
    }
    public boolean getCellState(int row, int col) {
        return this.cells[row][col];
    }
    public boolean getNextCellState(int row, int col) {
        int numberOfLivingNeighbours = this.getNumberOfLivingNeighbours(row, col);
        if(this.getCellState(row, col) && (numberOfLivingNeighbours == 2 || numberOfLivingNeighbours == 3)) {
            return true;
        }else if(!this.getCellState(row, col) && numberOfLivingNeighbours == 3) {
            return true;
        }else {
            return false;
        }
    }
    public int getNumberOfLivingNeighbours(int row, int col) {
        int numberOfLivingNeighbours = 0;
        int fromRow = Math.max(0, row - 1);
        int fromCol = Math.max(0, col - 1);
        int toRow = Math.min(this.getSize() - 1, row + 1);
        int toCol = Math.min(this.getSize() - 1, col + 1);
        for(int neighbourRow = fromRow; neighbourRow <= toRow; neighbourRow++){
            for(int neighbourCol = fromCol; neighbourCol <= toCol; neighbourCol++){
                boolean isCurrent = neighbourRow == row && neighbourCol == col;
                if(!isCurrent && getCellState(neighbourRow, neighbourCol)) {
                    numberOfLivingNeighbours++; 
                }
            }
        }
        return numberOfLivingNeighbours;
    }
}