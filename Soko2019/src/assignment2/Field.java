package assignment2;

public class Field {
	    private Piece piece; 
	    private int x; 
	    private int y; 
	  
	    public Field(int x, int y, Piece piece) { 
	        this.setPiece(piece); 
	        this.setX(x); 
	        this.setY(y); 
	        if(piece != null) {
	        piece.setField(this);
	        }	  
	        } 
	  
	    public Piece getPiece() 
	    { 
	        return this.piece; 
	    } 
	  
	    public void setPiece(Piece p) 
	    { 
	        this.piece = p; 
	        
	    } 
	  
	    public int getX() 
	    { 
	        return this.x; 
	    } 
	  
	    public void setX(int x) 
	    { 
	        this.x = x; 
	    } 
	  
	    public int getY() 
	    { 
	        return this.y; 
	    } 
	  
	    public void setY(int y) 
	    { 
	        this.y = y; 
	    } 
	    
	} 

