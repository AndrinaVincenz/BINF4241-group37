package assignment2;

public class Game {
    private Player[] players = new Player[2];
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    //private List<Move> movesPlayed;
    public void initialize(Player p1, Player p2)
    {
        players[0] = p1;
        players[1] = p2;


        if (p1.isWhiteSide()) {
            this.currentTurn = p1;
        }
        else {
            this.currentTurn = p2;
        }

        //movesPlayed.clear();
    }
}
