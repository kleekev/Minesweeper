/**
 * Name: Kevin Lee
 * Pennkey: kleekev
 * Execution: executes in Minesweeper.java
 *
 * Description: This class has the methods that that allows Minesweeper to
 * work
**/
public class Board {
    
    private Mines[][] mineArray;
    private NumberCells[][] numberCells;
    private Points[][] pointArray;
    
    /**
    * Constructor: This creates a new instance of a board object.
    */
    
    public Board(Points[][] p) {
        PennDraw.setScale(0, 9);
        PennDraw.clear(PennDraw.GREEN);
        this.pointArray = p;
    }
    
    /**
     * Inputs: no input
     * Outputs: Mines[][] 
     * Description: Returns a 2D array of Mines
    */
    
    public Mines[][] getMineArray() {
        return mineArray;
    }
    
    /**
     * Inputs: no input
     * Outputs: NumberCells[][]
     * Description: Returns a 2D array of NumberCells
    */
    
    public NumberCells[][] getNumberCells() {
        return numberCells;
    }
    
    /**
     * Inputs: no input
     * Outputs: void
     * Description: Draws the lines
    */
    
    public void drawLines() {
        for (double i = 1; i < 9; i++) {
            PennDraw.line(i, 0, i, 9);
        }
        for (double i = 1; i < 9; i++) {
            PennDraw.line(0, i, 9, i);
        }
    }
    
    /**
     * Inputs: no input
     * Outputs: void
     * Description: Draws more lines to create a square grid
    */
    
    public void drawSquares() {
        PennDraw.setPenColor(PennDraw.GRAY);
        for (double i = 0; i < 9; i++) {
            for (double j = 0; j < 9; j++) {
                PennDraw.filledSquare(i + 0.5, j + 0.5, 0.45);
            }
        }

    }
    
    /**
     * Inputs: no input
     * Outputs: int
     * Description: Returns an int of the number of NumberCells that has been 
     * clicked
    */
    
    public int amountOfNumberCellsClicked() {
        int numberClicked = 0;
        for (int i = 0; i < numberCells.length; i++) {
            for (int j = 0; j < numberCells[i].length; j++) {
                if (numberCells[i][j].hasBeenClick() == true) {
                    numberClicked++;
                }
            }
        }
        return numberClicked;
    }
    
    /**
     * Inputs: two int
     * Outputs: void
     * Description: Randomly assign 10 cells with a mine
    */
    
    public void tenMines(int x, int y) {
        int amountOfMines = 0;
        Mines[][] mines = new Mines[9][9];
        for (int i = 0; i < mines.length; i++) {
            for (int j = 0; j < mines.length; j++) {
                double random = Math.random();
                Mines mineCell = new Mines(pointArray[i][j]);
                if (i > x - 2 &&  i < x + 2 && j > y - 2 && j < y + 2) {        
                    mines[i][j] = mineCell;
                } else if (random > 0.5 && random < 0.6 && amountOfMines < 10) {
                    mineCell.hasMine();
                    amountOfMines++;
                    mines[i][j] = mineCell;
                } else {
                    mines[i][j] = mineCell;
                }
            }
        }
        // if there is still less than 10 mines, randomly assign until there are 
        // 10 mines
        if (amountOfMines < 10) {
            while (amountOfMines != 10) {
                for (int i = 0; i < mines.length; i++) {
                    for (int j = 0; j < mines[i].length; j++) {
                        double random = Math.random();
                        if (i > x - 2 && i < x + 2 && j > y - 2 && j < y + 2) {
                            
                        } else if (random > 0.2 && random < 0.4 && amountOfMines < 10 && mines[i][j].occupied() == false) {
                            mines[i][j].hasMine();
                            amountOfMines++;
                        }
                    }
                }
            }
        }
        
        this.mineArray = mines;
    }
    
    /**
     * Inputs: two int
     * Outputs: void
     * Description: Assign each numberCells with the number of mines nearby there
     * numberCells
    */
    
    public void numberCells(int x, int y) {
        NumberCells[][] number = new NumberCells[9][9];
        for (int i = 0; i < mineArray.length; i++) {
            for (int j = 0; j < mineArray[i].length; j++) {
                NumberCells cell = new NumberCells(mineArray[i][j].getPoints());
                if (mineArray[i][j].occupied() == true) {
                    cell.hasAMine();
                } else {
                    for (int k = i - 1; k < i + 2; k++) {
                        for (int l = j - 1; l < j + 2; l++) {
                            if (k >= 0 && l >= 0 && k < 9 && l < 9) {
                                if (mineArray[k][l].occupied() == true) {
                                    cell.addOne();
                                }
                            }
                        }
                    }
                }
                if (i == x && j == y) {
                    
                }
                number[i][j] = cell;
            }
        }
        this.numberCells = number;
    }
    
    /**
     * Inputs: two int
     * Outputs: void
     * Description: Removes a single box 
    */
    
    public void removeBox(int x, int y) {
        PennDraw.setPenColor(PennDraw.GREEN);
        Points point = pointArray[x][y];
        PennDraw.filledSquare(point.getXValue(), point.getYValue(), 0.45);
    }
    
    /**
     * Inputs: two int
     * Outputs: void
     * Description: If the numberCell clicked is 0 then, it will remove all nearby 
     * numberCell that also has 0.
    */
    
    public void removeNearBy(int x, int y) {
        if (x < 0 || x > 8 || y < 0 || y > 8) {
            return;
        } else if (numberCells[x][y].whatNumber() == 0 && numberCells[x][y].hasBeenClick() == false) {
            numberCells[x][y].draw();
            removeNearBy(x - 1, y - 1);
            removeNearBy(x - 1, y);
            removeNearBy(x - 1, y + 1);
            removeNearBy(x, y - 1);
            removeNearBy(x, y + 1);
            removeNearBy(x + 1, y - 1);
            removeNearBy(x + 1, y);
            removeNearBy(x + 1 , y + 1);
        } else {
            numberCells[x][y].draw();
        }
    }
    
    /**
     * Inputs: no input
     * Outputs: void
     * Description: Draws a yellow rectangle
    */
        
    public void yellowRectangle() {
        PennDraw.setPenColor(PennDraw.YELLOW);
        PennDraw.filledRectangle(4.5, 4.1, 4, 1);
        PennDraw.setPenColor(PennDraw.BLACK);
    }
    
    
}