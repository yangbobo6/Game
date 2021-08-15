package game.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A player has a goblet containing 5 values of dice (integers).
The program throws the 5 dice of the goblet and calculate the sum of this goblet.
The program asks the player to guess if next time, the sum will be greater or smaller.
The player wins 1 point everytime he does a good guess and loose 1 point when he fails.
Player starts with 10 points. Finish the game when the player has no points or 15 points.
 * @author Allain
 *
 */
public class StaticGoblet {
	
	private static final int NUMBER_OF_DICE = 7;
	private static final int NUMBER_OF_FACES = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		playTheGame(sc);
		sc.close();		
	}

	private static void playTheGame(Scanner sc) {
		// create the 10 points of the player
		int points = 10;
		// create the first goblet (a list generated by function)
		List<Integer> goblet = generateNewGoblet();
		// calculate the sum (int value calculated by function)
		int previousSum = sum(goblet);
		// create the loop until the player has no points or 15 points
		while (points>0 && points<15) {	
		// ask for next sum
			String input = askForMoreOrLess(sc, points, goblet);
		//	-> create the next goblet, calculate the sum
			goblet = generateNewGoblet();
			int currentSum = sum(goblet);
		//	-> check the guess of the player and change points
			if ( (currentSum<=previousSum && input.equals("-"))
					|| (currentSum>=previousSum && input.equals("+"))
			) {
				System.out.println("ok");
				points++;
			}
			else {
				System.out.println("fail");
				points--;
			}
			previousSum=currentSum;
		}
		if (points==0) {
		System.out.println("LOSE !");
		}
		else {
			System.out.println("WIN !");
		}
	}

	private static String askForMoreOrLess(Scanner sc, int points, List<Integer> goblet) {
		System.out.println("you have "+points+" points ");
		System.out.print("(");
		for (Integer dice : goblet) {
			System.out.print(dice+" / ");
		}
		System.out.println(")");
		System.out.println("More or Less ? +/-");
		return sc.next();
	}

	private static int sum(List<Integer> goblet) {
		int sum=0;
		for (Integer die : goblet) {
			sum+=die;
		}
		return sum;
	}

	private static List<Integer> generateNewGoblet() {
		List<Integer> list = new ArrayList<Integer>(NUMBER_OF_DICE);
		for (int i = 0; i < NUMBER_OF_DICE; i++) {
			int dice = (int)(Math.random()*NUMBER_OF_FACES) + 1;
			list.add(dice);
		}
		return list;
	}

}
