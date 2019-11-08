--- Part 1 ---
We decided to use the singleton and the adapter pattern

the applied the singleton pattern on the board class. At the moment you can only play one game at the same time
and so it only needs one board object.If we want to create more games at the same time, this pattern would be a problem.
But at the moment we find it useful, than we had the problem in the implementation that we created a second board with
new figures and then we swapped the figures accidentally between the different boards. With the singleton
pattern applied on the board, we avoid that problem. And you can only create on board object

Then we used the adapter pattern to handle the conversion between our numeration for the fields,
and the algebraic notation. At the moment it is only one conversion but it makes our project reusable, so it 
easier to implement an other notation, and it has no affects on the board and pieces classes and structure.
You have only to handle your input, do an other adaption and use the classes as they are.

You can see the diagrams as separate png files.

--- Part 2 ---

For this part the game class from assignment 2 was used. Main class is interpreted as Game Class. The Sequenze Diagramm is saved as Assignment 3 Part 2

--- Part 3 ---

For Part 3, we decided to implement the adapter pattern.
Besides the Initialization of the new Pieces in the "board.java" file, 
we were able to implement the Superqueen and 
Archbishop WITHOUT ANY CHANGES IN THE EXISTING CODE!!! :) :) :)

As a consequence of your implementation in Assignment 2, not the "move" function itself had to be changed,
insted the "boolean[][] getPossibleFields*(board b)" needed to be adjusted.

Currently when you're playing the game, the Superqueens and Archbishops are 
initialized as a standart. As a consequence, the notation stays the same as it was before,
however now the additional fields on the board can be accessed as defined in the task.

