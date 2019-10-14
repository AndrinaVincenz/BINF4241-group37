package assignment2;

	public abstract class Piece { 
		String name = "";
		private boolean killed = false; 
		private boolean white = false; 
		protected Field currentfield;

		public Piece(boolean white) 
		{ 
			this.setWhite(white); 
		
		} 

		public boolean isWhite() 
		{ 
			return this.white == true; 
		} 

		public void setWhite(boolean white) 
		{ 
			this.white = white; 
		} 

		public boolean isKilled() 
		{ 
			return this.killed == true; 
		} 

		public void setKilled(boolean killed) 
		{ 
			this.killed = killed; 
		} 
		public void setField(Field field) {
			this.currentfield = field;
		}
		
		public Field getField() {
			return this.currentfield;
		}

	     
	    
		 
		public abstract boolean canMove(Board board, 
									Field start, Field end);

		   public String getName() {
		    	return this.name;
		    }

		public boolean[][] getpossibleDestination(Board b) {
			// TODO Auto-generated method stub
			return null;
		}

		 
	} 


