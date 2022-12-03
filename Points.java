/**
 * Name: Kevin Lee
 * Pennkey: kleekev
 * Execution: executed in all java files
 *
 * Description: Stores the x and y value of each cell of Minesweeper
**/

public class Points {
    
    private double x;     // x position
    private double y;     // y position
    
    /**
    * Constructor: This creates a new instance of a Points object.
    */
    
    public Points(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Inputs: no input
     * Outputs: double
     * Description: Returns a double of the x position
    */
    
    public double getXValue() {
        return x;
    }
    
    /**
     * Inputs: no input
     * Outputs: double
     * Description: Returns a double of the y position
    */
    
    public double getYValue() {
        return y;
    }
}
