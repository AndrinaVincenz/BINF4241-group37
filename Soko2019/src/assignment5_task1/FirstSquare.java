package assignment5_task1;
import java.util.ArrayList;


public class FirstSquare extends Square {
	
	private ArrayList<Player> p = new ArrayList<Player>();
	
	public FirstSquare(int position, Board b) {
		super(position,b);	
	}



	@Override
	public void enter(Player player){
		p.add(player);
		player.setSquare(board.firstSquare());
	}

	@Override
	public void leave(Player player) {
		p.remove(player);
	}
	@Override
	public boolean isFirstSquare() {
		return true;
	}
	
}
