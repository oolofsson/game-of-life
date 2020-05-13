package game;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class GameOfLifeTest {

    private Grid grid;

    @BeforeEach
    public void setUp() {
        this.grid = new Grid(GameOfLife.GRID_SIZE);
        grid.updateCell(0, 0, true);
        grid.updateCell(1, 1, true);
        grid.updateCell(2, 1, true);
        grid.updateCell(2, 2, true);
        grid.updateCell(4, 4, true);
        grid.updateCell(5, 4, true);
        grid.updateCell(6, 4, true);
    }

    @Test
    public void getNextGridShouldReturnCorrectGrid() {
        Grid nextGrid = GameOfLife.getNextGrid(this.grid);

        assertEquals(nextGrid.getCellState(0, 0), false);
        assertEquals(nextGrid.getCellState(1, 1), true);
        assertEquals(nextGrid.getCellState(1, 2), true);
        assertEquals(nextGrid.getCellState(2, 1), true);
        assertEquals(nextGrid.getCellState(2, 2), true);
        assertEquals(nextGrid.getCellState(4, 4), false);
        assertEquals(nextGrid.getCellState(6, 4), false);
        assertEquals(nextGrid.getCellState(5, 3), true);
        assertEquals(nextGrid.getCellState(5, 4), true);
        assertEquals(nextGrid.getCellState(5, 5), true);

    }
}