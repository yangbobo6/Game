package game;

import java.util.Scanner;

public class MoreOrLess {	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mini = getMinimalValue(sc);
		int maxi = getMaximalValue(sc);
		playTheGame(sc, mini, maxi);
		sc.close();		
	}

	
	/**
	 * example 50-60 -> 10 different values
	 * Math.random() generates double [0, 1[
	 * (Math.random() * 10) generates double [0, 10[
	 * (int) (Math.random() * 10) generates integer [0, 10[
	 * ((int) (Math.random() * 10) + 50) is [50, 60[.
	 * @param sc : the unique scanner of the programm
	 * @param mini : the minimal value to guess
	 * @param maxi : the maximal value 
	 */
	private static void playTheGame(Scanner sc, int mini, int maxi) {
		int target = (int)(Math.random()*(maxi-mini)) + mini;
		boolean found = false;
		int count=0;
		while (!found) {
			System.out.println("give me a number between "+mini+" and "+maxi+" : ");
			int input = sc.nextInt();
			count++;
			found = (input==target);
			if (input<target) {
				System.out.println("greater");
			}
			else if (input>target) {
				System.out.println("lower");
			}
		}
		System.out.println("WIN ! => "+count);
	}

	private static int getMaximalValue(Scanner sc) {
		System.out.println(" please, enter the maxi : ");
		int input = sc.nextInt();
		return input;
	}

	private static int getMinimalValue(Scanner sc) {
		System.out.println(" please, enter the mini : ");
		int input = sc.nextInt();
		return input;
	}

}
