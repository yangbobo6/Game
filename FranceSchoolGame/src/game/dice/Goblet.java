package game.dice;

import java.util.ArrayList;
import java.util.List;

public class Goblet {

	private static final int NUMBER_OF_DICE = 5;	
	List<Die> dice = new ArrayList<Die>(NUMBER_OF_DICE);
	
	
	public Goblet() {
		super();
		// generate the list of dice
		for (int i = 0; i < NUMBER_OF_DICE; i++) {
			//create a die
			Die die = new Die();
			//add it to the list dice
			dice.add(die);
		}
	}

	public void shake() {
		for (Die die : dice) {
			die.roll();
		}
	}
	
	public int sum() {
		int sum=0;		
		/*for with counter
		for (int i = 0; i < dice.size(); i++) {
			sum += dice.get(i).getValue();
		}*/
		
		//foreach
		for (Die die : dice) {
			sum+=die.getValue();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		return "(" + dice + ")";
	}
	
	
	
	
	
}
