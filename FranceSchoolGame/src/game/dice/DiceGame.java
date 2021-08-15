package game.dice;

import java.util.Scanner;

public class DiceGame {

	//attributes
	Player player;
	Goblet goblet;

	public DiceGame(Player player) {
		super();
		this.player = player;
		this.goblet = new Goblet();
		//System.out.println(goblet);
	}

	public static void main(String[] args) {
		// TODO option : ask the player for a name 
		DiceGame theGame = new DiceGame(new Player("Steve"));
		theGame.playTheGame();
	}

	private void playTheGame() {
		Scanner sc = new Scanner(System.in);
		int previousSum = goblet.sum();
		while (!player.hasWin() && !player.hasLose()) {	
			String input = askForMoreOrLess(sc);
			goblet.shake();
			int currentSum = goblet.sum();
			if ( (currentSum<=previousSum && input.equals("-"))
					|| (currentSum>=previousSum && input.equals("+"))
					) {
				System.out.println("ok");
				player.earnPoints();
			}
			else {
				System.out.println("fail");
				player.losePoints();
			}
			previousSum=currentSum;
		}
		if (player.hasLose()) {
			System.out.println("LOSE !");
		}
		else {
			System.out.println("WIN !");
		}
		sc.close();
	}

	private String askForMoreOrLess(Scanner sc) {
		/* unused here
		 * String s = Integer.toString(15);
		 * int v=Integer.valueOf("45");
		 */
		boolean goodKey=false;
		String keyPressed=null;
		while (!goodKey) {
			System.out.println("you have "+player.getPoints()+" points ");
			System.out.print(goblet);
			System.out.println("More or Less ? +/-");
			keyPressed=sc.next();
			goodKey=(keyPressed.equals("+") || keyPressed.equals("-") );
		}
		return keyPressed;
	}


}
