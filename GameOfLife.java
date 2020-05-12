import java.util.concurrent.TimeUnit;

public class GameOfLife {
    final static int GRID_SIZE = 20;
	public static void main(String[] args) {
       run(); 
    }
    public static void run(){
        Grid grid = new Grid(GRID_SIZE);
        seed(grid);
        Screen screen = new Screen();
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
                boolean shouldLive = currentGrid.getNextCellState(row, col);
                nextGrid.updateCell(row, col, shouldLive);
            } 
        }
        return nextGrid;
    }
}
