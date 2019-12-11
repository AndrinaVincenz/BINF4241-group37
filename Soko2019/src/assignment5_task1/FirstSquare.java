package assignment5_task1;
import java.util.ArrayList;


public class FirstSquare extends Square {
	
	private ArrayList<Player> p = new ArrayList<Player>();
	
	public FirstSquare(int position, Board b) {
		super(position,b);	
	}
	
	public ArrayList<Player> getPlayers(){
		return p;
	}

	@Override
	public void enter(Player player){
		p.add(player);
		player.setSquare(board.getFirstSquare());
	}

	@Override
	public void leave(Player player) {
		p.remove(player);
	}
	@Override
	public boolean isFirstSquare() {
		return true;
	}
	
	@Override
	public Player getPlayer(){
		System.out.println("This function is not supported for the first Square!");
		return null;
	}
	
}
