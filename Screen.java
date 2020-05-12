public class Screen {
    public Screen() {

    }
    private void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    public void printGrid(Grid grid) {
        this.clearScreen();
        for (int row = 0; row < grid.getSize(); row++) { 
            for (int col = 0; col < grid.getSize(); col++) { 
                String output = grid.isCellAlive(row, col) ? "*": "-";
                System.out.print(output);
            } 
            System.out.println();
        }
    }
}