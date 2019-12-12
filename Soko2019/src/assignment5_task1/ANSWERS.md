Assignment 5

Task 1

First of all, we had to refactor the output regarding the requirements in Assignment 1. 

1.
After that, the first obvious bug was, that the players didn't get deleted from the specific Square after a roll. We fixed that by changed the leave() function at Square just by adding the "this" keyword to player --> this.player

2. BoardTest.java

Bad practice at createLadderList and createSnakeList
When testing createLadderList and createSnakeList we have found a bad practice in generating the Lists, we generated lists with randomly Snakes/Ladders and set the size of the list to approximately 20% of the size of the hole board. We added now, that the percentage can be set through an input parameter. 
Additionally the percentage has to be between 0 to 50%, if below it would be taken 0, if higher it takes 50%.

Found bug at mergeLaddersAndSnakes:
We removed a additional if-statement a possibly existing Ladder on field 1. It makes no sense to have a ladder on field 1.

3. GameTest.java

The testIsOver() function helped us to find a bug in the printing of the board. Firstly, we forgot to print the Players name if he was on the last "winning" filed.

4. PlayerTest.java

To test the function moveForward we had to create a new "getter", the "getPlayersLinkedList()" in the Game class, otherwhise the testing wouldn't have been possible.

5. SquareTest.java

After refactoring the output at the beginning we realised, that isOccupied doesn't work as it should: 
In case you hit a ladder or snake, and that ladder or snakes lead you to a field that is occupied, it didn't work. Therefore we had to create a new function checkForSpecialSquares() in the Square class. There we checked also after coming from a ladder or snake, if the field is occupied. We tested these functions with testMoveAndLandOccupied() as well as  testCheckForSpecialSquaresSnake() and testCheckForSpecialSquaresLadder().



