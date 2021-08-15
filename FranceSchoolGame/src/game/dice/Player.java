package game.dice;

public class Player {
	
	//attributes (=fields)
	String name;
	int points=10;
	
	//constructor
	public Player(String name) {
		super();
		this.name = name;
	}
	
	public void earnPoints() {
		this.points++;
	}
	
	public void losePoints() {
		this.points--;
	}
	
	public boolean hasWin() {
		return (points>=15);
	}

	public boolean hasLose() {
		return (points<=0);
	}

	public int getPoints() {
		return points;
	}

}
