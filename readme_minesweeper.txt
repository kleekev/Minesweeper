Name: Kevin Lee
PennKey: kleekev

In order to run my game, just run Minesweeper.java

Additional features is just adding a title page in the beginning of the game.

Points.java stores the x and y coordinate of the cell so drawing is easier.

Mines.java is to create a Mines object so that it can check if that cell has a mine 
or not.

NumberCells.java stores the number of mines nearby for that specific cell and whether
that specific cell has also been clicked or not

Board.java is where the majority of the code is in order to make minesweeper work.
It takes in all of the previous classes and puts them together to create methods 
such as, assigning mines, counting the amount of number cells that has been clicked, 
removing the nearby cells if it does not have a mine nearby, etc.

Minesweeper.java is where the game is executed. I make the game as a function so that
it can be replayed. It is how I register the clicks of the user and make them play
the game.