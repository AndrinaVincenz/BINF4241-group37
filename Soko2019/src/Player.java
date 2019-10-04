public class Player {
	
	public Player(String name) {
		super();
		this.name = name;
	}

	private String name;
	
	String getName(){
		return name;
	}
	
	int moveForward() {
		return 0;
	}

	int position() {
		return 0;
	}
	
	boolean wins(){
		return false;
	};
}
