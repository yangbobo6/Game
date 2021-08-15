package game.dice;

public class Die {

	int numberOfFaces=6;
	int currentFace;
	
	public Die() {
		super();
		this.roll();
	}
	
	/**
	 * overloading the constructor
	 */
	public Die(int numberOfFaces) {
		super();
		this.numberOfFaces = numberOfFaces;
		this.roll();
	}


	public void roll() {
		this.currentFace = (int)(Math.random()*numberOfFaces) + 1;		
	}

	@Override
	public String toString() {
		return "[" + currentFace + "]";
	}

	public int getValue() {
		return this.currentFace;
	}
	
	
	
}
