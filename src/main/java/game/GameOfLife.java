package game;
import java.util.concurrent.TimeUnit;

public class GameOfLife {
    public final static int GRID_SIZE = 10;
	public static void main(String[] args) {
       run(); 
    }
    public static void run(){
        Grid grid = new Grid(GRID_SIZE);
        seed(grid);
        Screen screen = Screen.getInstance();
        while(true) {
            try {
                screen.printGrid(grid);
                grid = getNextGrid(grid);
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                System.err.print(e);
            }
        }
    }
    public static void seed(Grid grid) {
        grid.updateCell(0, 0, true);
        grid.updateCell(0, 2, true);
        grid.updateCell(0, 1, true);
        grid.updateCell(3, 1, true);
        grid.updateCell(1, 1, true);
        grid.updateCell(2, 2, true);
        grid.updateCell(3, 3, true);
        grid.updateCell(4, 5, true);
        grid.updateCell(4, 3, true);
        grid.updateCell(7, 3, true);
        grid.updateCell(7, 4, true);
        grid.updateCell(7, 5, true);
    }
    public static Grid getNextGrid(Grid currentGrid) {
        Grid nextGrid = new Grid(GRID_SIZE);
        for (int row = 0; row < currentGrid.getSize(); row++) { 
            for (int col = 0; col < currentGrid.getSize(); col++) { 
                boolean nextCellState = currentGrid.getNextCellState(row, col);
                nextGrid.updateCell(row, col, nextCellState);
            } 
        }
        return nextGrid;
    }
}
