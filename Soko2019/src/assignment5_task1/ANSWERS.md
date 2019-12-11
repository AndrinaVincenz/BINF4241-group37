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
