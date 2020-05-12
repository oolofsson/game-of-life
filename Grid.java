public class Grid {

    private boolean[][] cells; 

    public Grid(int size) {
        this.cells = new boolean[size][size]; 
    }
    private void updateCellState(int row, int col) {
        int numberOfLiveNeighbours = this.getNumberOfLiveNeighbours(row, col);
    }
    private int getNumberOfLiveNeighbours(int row, int col) {
        int numberOfLiveNeighbours = 0;
        for(int neighBourRow = row - 1; neighBourRow <= row + 1; neighBourRow++){
            for(int neighBourCol = col - 1; neighBourCol <= col + 1; neighBourCol++){

            }
        }
    }
}