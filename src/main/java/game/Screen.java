package game;

public class Screen {

    private static final Screen instance = new Screen();
    public Screen() {

    }
    public static Screen getInstance() {
        return instance;
    }
    private void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    public void printGrid(Grid grid) {
        this.clearScreen();
        for (int row = 0; row < grid.getSize(); row++) { 
            for (int col = 0; col < grid.getSize(); col++) { 
                boolean isAlive = grid.getCellState(row, col);
                String output = isAlive ? "*": "-";
                System.out.print(output);
            } 
            System.out.println();
        }
    }
}