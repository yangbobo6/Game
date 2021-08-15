package first.pack;

import java.util.Scanner;

public class First {

	public static void main(String[] args) {
		System.out.println("beginning of MAIN");
		firstDisplays();
		firstBooleans();
		firstInstruction();
		firstInstructions2(16);
		firstInstructions2(256);
		firstInstructions2(1060);
		read3Numbers();
		readNumbers();
		guessANumber(10,100);
		System.out.println("end of MAIN");
	}

	private static void guessANumber(int mini, int maxi) {
		int target = (int)(Math.random()*maxi);
		System.out.println(target);
	}

	private static void read3Numbers() {

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println(i+" : please, enter a number : ");
			int input = sc.nextInt();
			firstInstructions2(input);
		}
		sc.close();
	}

	private static void readNumbers() {

		Scanner sc = new Scanner(System.in);
		boolean finished=false;
		while(!finished) {
			System.out.println(" : please, enter a number, 0 to leave : ");
			int input = sc.nextInt();
			finished = (input==0);
			if (!finished) {
				firstInstructions2(input);
			}
		}
		sc.close();
	}



	private static void firstInstructions2(int n) {
		if (n<256) {
			System.out.println(n+" is less than 256");
		}
		else {
			System.out.println(n+" is greater (or equal) than 256");
		}
	}

	private static void firstInstruction() {
		/*
		if (10<20) {
			System.out.println("10 is less than 20");
		}
		else {
			System.out.println("10 is NOT less than 20 !!!");
		}
		 */

		int n=45;
		if (n<256) {
			System.out.println(n+" is less than 256");
		}
		else {
			System.out.println(n+" is greater (or equal) than 256");
		}

		double decimal=Math.pow(2, 8);
		if (decimal<256) {
			System.out.println(decimal+" is less than 256");
		}
		else {
			System.out.println(decimal+" is greater (or equal) than 256");
		}


	}

	private static void firstBooleans() {
		boolean finished = false;
		System.out.println(finished);
		boolean ok = true;

		System.out.println("and "+(finished&&ok));
		System.out.println("or "+(finished||ok));
		System.out.println("not "+!finished+!ok);
	}



	private static void firstDisplays() {
		System.out.println("Hello World");
		//comment a line String ""
		/*
		 * block of comments
		 */
		int number = 0 ;
		System.out.println("first value of number = "+number);
		number = 15;
		System.out.println("second value of number = "+number);
		number = number + 10;
		System.out.println("3rd value of number = "+number);
		number += 10;
		System.out.println("4th value of number = "+number);
		System.out.println(" value of number++ = "+ (number++));
		System.out.println(" value of ++number = "+ (++number));
	}

}
