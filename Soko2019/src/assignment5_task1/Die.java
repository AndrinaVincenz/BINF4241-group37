package assignment5_task1;
import java.util.Random;

public class Die {

	public int roll(){
		Random rn = new Random();
		return rn.nextInt(6) + 1;
	}
}
