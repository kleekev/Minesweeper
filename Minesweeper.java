/**
 * Name: Kevin Lee
 * Pennkey: kleekev
 * Execution: java Minesweeper
 *
 * Description: User can play the game minesweeper
**/

public class Minesweeper {
    
    /**
     * Inputs: Points[][]
     * Outputs: void
     * Description: This function is the Minesweeper game and plays out the game
    */
    
    public static void game(Points[][] pointsArray) {
        //draw the board
        Board minesweeper = new Board(pointsArray);
        minesweeper.drawLines();
        minesweeper.drawSquares();
        int x = 0;
        int y = 0;
        boolean firstClick = false;
        PennDraw.enableAnimation(10);
        while (firstClick == false) {
            x = (int) Math.floor(PennDraw.mouseX());
            y = (int) Math.floor(PennDraw.mouseY());
            firstClick = PennDraw.mousePressed();
            PennDraw.advance();
        }
        PennDraw.disableAnimation();
        // after the first click create the mines and remove nearby cells
        minesweeper.removeBox(x, y);
        minesweeper.tenMines(x, y);
        minesweeper.numberCells(x, y);
        NumberCells[][] numberCellArray = minesweeper.getNumberCells();
        Mines[][] mine = minesweeper.getMineArray();
        minesweeper.removeNearBy(x, y);
        
        // until the user gets a gameOver, keep playing the game
        boolean gameOver = false;
        String typeOfGameOver = "";
        PennDraw.enableAnimation(10);
        while (gameOver == false) {
            if (minesweeper.amountOfNumberCellsClicked() == 71) {
                typeOfGameOver = "Win";
                gameOver = true;
            } else {
                boolean click = false;
                while (click == false) {
                    x = (int) Math.floor(PennDraw.mouseX());
                    y = (int) Math.floor(PennDraw.mouseY());
                    click = PennDraw.mousePressed();
                    PennDraw.advance();
                }
            }
            if (numberCellArray[x][y].whatNumber() == -1) {
                mine[x][y].draw();
                typeOfGameOver = "Clicked Mine";
                gameOver = true;
            } else if (numberCellArray[x][y].whatNumber() == 0) {
                minesweeper.removeNearBy(x, y);
            } else {
                numberCellArray[x][y].draw();
            } 
        }
        // end game 
        PennDraw.disableAnimation();
        PennDraw.setFontSize(56);        
        if (typeOfGameOver.equals("Clicked Mine")) {
            for (int i = 0; i < mine.length; i++) {
                for (int j = 0; j < mine[i].length; j++) {
                    if (mine[i][j].occupied() == true) {
                        mine[i][j].draw();
                    }
                }
            }
            minesweeper.yellowRectangle();
            PennDraw.text(4.5, 4.5, "Game Over!");
        } else if (typeOfGameOver.equals("Win")) {
            minesweeper.yellowRectangle();
            PennDraw.text(4.5, 4.5, "You Win!");
        }
        // replay if user presses n
        boolean hasTyped = false;
        char ch = 0;
        while (hasTyped == false) {
            PennDraw.setFontSize(42);
            PennDraw.text(4.5, 3.5, "Press n to play again");
            if (PennDraw.hasNextKeyTyped()) {
                ch = PennDraw.nextKeyTyped();
            }
            if (ch == 'n') {
                hasTyped = true;
            }
        }
        if (ch == 'n') {
            PennDraw.clear();
            game(pointsArray);
        }
    }
    public static void main(String[] args) {
        // each index represents a cell
        Points[][] pointsArray = new Points[9][9];
        int row = 0;
        int column = 0;
        for (double i = 0.5; i < 9.0; i++) {
            for (double j = 0.5; j < 9.0; j++) {
                pointsArray[row][column] = new Points(i, j);
                column++;
            }
            row++;
            column = 0;
        }
        // main menu 
        PennDraw.enableAnimation(10);
        boolean menuClick = false;
        while (menuClick == false) {
            PennDraw.clear();
            PennDraw.setFontSize(72);
            PennDraw.text(0.5, 0.75, "Minesweeper");
            PennDraw.setFontSize(36);
            PennDraw.text(0.5, 0.5, "Click any where to start");
            if (PennDraw.mousePressed()) {
                menuClick = true;
            }
            PennDraw.advance();
        }
        PennDraw.disableAnimation();
        game(pointsArray);
    }
}