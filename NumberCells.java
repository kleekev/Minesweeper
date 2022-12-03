/**
 * Name: Kevin Lee
 * Pennkey: kleekev
 * Execution: Executed in Board.java and Minesweeper.java
 *
 * Description: Create a Numbercell which tells how many mines are nearby
**/
public class NumberCells {
    
    private Points p;
    private int numberOfMines;
    private boolean hasBeenClicked;
    
    /**
    * Constructor: This creates a new instance of a NumberCells object.
    */
    
    public NumberCells(Points p) {
        numberOfMines = 0;
        this.p = p;
        hasBeenClicked = false;
    }

    /**
     * Inputs: no input
     * Outputs: void
     * Description: Adds one mine
    */
    
    public void addOne() {
        numberOfMines++;
    }
    
    /**
     * Inputs: no input
     * Outputs: int
     * Description: Returns an int of the number of mines on that number cell
    */
    
    public int whatNumber() {
        return numberOfMines;
    }
    
    /**
     * Inputs: no input
     * Outputs: void
     * Description: Changes the status of the number cell if clicked to true
    */
    
    public void clicked() {
        hasBeenClicked = true;
    }
    
    /**
     * Inputs: no input
     * Outputs: void
     * Description: Change the status of the amount of mines to -1 if there is a
     * mine on the number cell
    */
    
    
    public void hasAMine() {
        numberOfMines = -1;
    }
    
    /**
     * Inputs: no input
     * Outputs: boolean
     * Description: Returns a boolean whether that numbercell has been clicked. If 
     * it has been clicked, return true otherwise return false
    */
    
    public boolean hasBeenClick() {
        return hasBeenClicked;
    }
    
    /**
     * Inputs: no input
     * Outputs: void
     * Description: Draws the number cell with the number of mines nearby the 
     * numbercell if it has not been clicked. If it has return void. If the number 
     * of mines is 0, draw only the background.
    */
    
    public void draw() {
        if (hasBeenClick() == false) {
            PennDraw.setPenColor(PennDraw.GREEN);
            PennDraw.filledSquare(p.getXValue(), p.getYValue(), 0.45);
            if (whatNumber() != 0) {
                PennDraw.setPenColor(PennDraw.BLACK);
                PennDraw.setFontSize(42);
                String number = String.valueOf(numberOfMines);
                PennDraw.text(p.getXValue(), p.getYValue(), number);               
            }
            clicked();
        } else {
            return;
        }
    }
    
    
}