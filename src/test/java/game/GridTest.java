package game;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class GridTest {
    private final int GRID_SIZE = 10;
    private Grid grid;

    @BeforeEach
    public void setUp() {
        this.grid = new Grid(GRID_SIZE);
    }

    @Test
    public void gridIsInitialized() {
        assertEquals(this.grid.getSize(), GRID_SIZE);
    }
    @Test
    public void updatesCellState() {
        this.grid.updateCell(5, 5, true);
        assertEquals(this.grid.getCellState(5, 5), true);
    }
    @Test
    public void deadCellWithThreeNeighboursShouldLive() {
        this.grid.updateCell(4, 4, true);
        this.grid.updateCell(4, 5, true);
        this.grid.updateCell(5, 5, true);
        assertEquals(this.grid.getNextCellState(5, 4), true);
    }
    @Test
    public void deadCellsWithFewNeighboursShouldBeDead() {
        this.grid.updateCell(4, 4, true);
        this.grid.updateCell(4, 5, true);
        assertEquals(this.grid.getNextCellState(5, 5), false);
        assertEquals(this.grid.getNextCellState(3, 3), false);
        assertEquals(this.grid.getNextCellState(7, 7), false);
    }
    @Test
    public void liveCellWithCorrectNeighbourShouldLive() {
        this.grid.updateCell(4, 3, true);
        this.grid.updateCell(4, 4, true);
        this.grid.updateCell(5, 4, true);
        this.grid.updateCell(4, 5, true);
        this.grid.updateCell(5, 5, true);

        // three neighbours
        assertEquals(this.grid.getNextCellState(5, 5), true);
        // two neighbours
        assertEquals(this.grid.getNextCellState(4, 3), true);
    }
    @Test
    public void overPopulatedLiveCellShouldBeDead() {
        this.grid.updateCell(4, 4, true);
        this.grid.updateCell(4, 5, true);
        this.grid.updateCell(5, 4, true);
        this.grid.updateCell(5, 5, true);
        this.grid.updateCell(6, 6, true);
        assertEquals(this.grid.getNextCellState(5, 5), false);
    }
}