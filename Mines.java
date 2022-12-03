/**
 * Name: Kevin Lee
 * Pennkey: kleekev
 * Execution: Executed in Board.java and Minesweeper.java
 *
 * Description: This class assign a point if it has a mine or not.
**/

public class Mines {
    
    private Points p;
    private boolean hasMine;

    /**
    * Constructor: This creates a new instance of a Mines object.
    */
    public Mines(Points p) {
        this.p = p;
        hasMine = false;
    }
    
    /**
     * Inputs: no input
     * Outputs: void
     * Description: Draws the picture of the mine
    */
    
    public void draw() {
        double x = p.getXValue();
        double y = p.getYValue();
        PennDraw.picture(x, y, "MinePicture.png", 35, 35);
    }
    
    /**
     * Inputs: no input
     * Outputs: void
     * Description: Changes the status of the object to have a mine
    */
    
    public void hasMine() {
        hasMine = true;
    }
    
    /**
     * Inputs: no input
     * Outputs: boolean
     * Description: Returns a boolean whether the object has a mine or not. If it
     * has a mine return true otherwise return false
    */
    
    public boolean occupied() {
        return hasMine;
    }
    
    /**
     * Inputs: no input
     * Outputs: Points
     * Description: Returns the Points of the mine object
    */
    
    public Points getPoints() {
        return p;
    }
   
}