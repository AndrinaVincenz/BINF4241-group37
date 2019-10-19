package assignment2;

public class Game {
    private Player[] players = new Player[2];
    private Board board;
    private GameStatus status;
    //private List<Move> movesPlayed;
    public void initialize(Player p1, Player p2)
    {
        players[0] = p1;
        players[1] = p2;
        this.status = GameStatus.WHITE_TURN;
        //movesPlayed.clear();
    }
    
    public GameStatus getStatus(){
    	return this.status;
    }
    
    void setStatus(GameStatus gameStatus){
    	this.status = gameStatus;
    }
    
    /**
     * might be unused since we have a status to get the information directly
     * @return
     * @throws Exception
     */
    public Player getCurrentPlayer() throws Exception {
    	if (status == GameStatus.BLACK_TURN){
    		return players[1];
    	} else if (status == GameStatus.WHITE_TURN){
    		return players[0];
    	} else throw new Exception("No current player, is the game over?");
    }
}
