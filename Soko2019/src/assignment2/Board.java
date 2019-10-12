package assignment2;

	public class Board { 
		Field[][] boxes; 

		public Board() 
		{ 
			this.resetBoard(); 
		} 

		public Field getBox(int x, int y) throws Exception 
		{ 
			if (x < 0 || x > 7 || y < 0 || y > 7) { 
				throw new Exception("Index out of bound"); 
			} 

			return boxes[x][y]; 
		} 

		public void resetBoard() 
		{ 
			// initialize white pieces 
			boxes[0][1] = new Field(0, 1, new Knight(true)); 
			boxes[0][1] = new Field(0, 6, new Knight(true)); 
			//... 

			// initialize black pieces 
			boxes[7][1] = new Field(7, 1, new Knight(false)); 
			boxes[7][1] = new Field(7, 6, new Knight(false)); 
			//... 

			// initialize remaining boxes without any piece 
			for (int i = 2; i < 6; i++) { 
				for (int j = 0; j < 8; j++) { 
					boxes[i][j] = new Field(i, j, null); 
				} 
			} 
		} 
	} 
