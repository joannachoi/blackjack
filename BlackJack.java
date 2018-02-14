// Description: This program will simulate a single card being dealt to
//		an initial BlackJack hand and keep track of the number of
//		times that single card results in a "bust".

import java.util.*;

public class BlackJack {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random();

		description();
		String runSimulationAgain;
		do {
			int startingHand = startingHand(keyboard);
			int dealsSimulated = dealsSimulated(keyboard);
			int repeatedDeals = repeatDeals(startingHand, dealsSimulated, r);
			System.out.println();
			printResults(startingHand, dealsSimulated, repeatedDeals, r);
			System.out.println();
			System.out.println();
			System.out.print("Do you want to run the simulation again? (Y|N) ");
			runSimulationAgain = keyboard.next().toLowerCase();
		} while (runSimulationAgain.charAt(0) == 'y');
	}

	public static void description() {
		System.out
				.println("This program will simulate a single card being dealt to");
		System.out
				.println("an initial BlackJack hand and keep track of the number of");
		System.out
				.println("the number of times that single card results in a \"bust\".");
		System.out.println();
	}

	public static int startingHand(Scanner keyboard) {
		int startingHandValue;
		do {
			System.out.print("What is the value of your starting hand: ");
			startingHandValue = keyboard.nextInt();
			if (startingHandValue > 20 || startingHandValue < 2) {
				System.out
						.println("You must enter a value in the range 2-20. Please try again.");
				System.out.print("What is the value of your starting hand: ");
				startingHandValue = keyboard.nextInt();
			}
		} while (startingHandValue > 20 || startingHandValue < 2);
		return startingHandValue;
	}

	public static int dealsSimulated(Scanner keyboard) {
		int dealsSimulatedValue;
		do {
			System.out.print("How many deals do you want to simulate: ");
			dealsSimulatedValue = keyboard.nextInt();
			if (dealsSimulatedValue <= 0) {
				System.out
						.println("You must enter a positive value. Please try again.");
				System.out.print("How many deals do you want to simulate: ");
				dealsSimulatedValue = keyboard.nextInt();
			}
		} while (dealsSimulatedValue <= 0);
		return dealsSimulatedValue;
	}

	public static int generateCard(Random r) {
		int card = r.nextInt(13) + 1;
		if (card > 10) {
			card = 10;
		}
		return card;
	}

	public static int repeatDeals(int startingHandValue,
			int dealsSimulatedValue, Random r) {
		int numBusts = 0;
		for (int i = 0; i < dealsSimulatedValue; i++) {
			if (startingHandValue + generateCard(r) > 21) {
				numBusts++;
			}
		}
		return numBusts;
	}

	public static void printResults(int startingHandValue,
			int dealsSimulatedValue, int numBusts, Random r) {
		double percent = ((double) numBusts / dealsSimulatedValue);
		int round = (int) Math.round(percent * 100.0);
		double percentRoundResult = round;

		System.out.println("For a starting hand of " + startingHandValue
				+ ", the next card dealt resulted ");
		System.out.println("in a bust " + numBusts + " out of "
				+ dealsSimulatedValue + " times, or " + percentRoundResult
				+ "% of the time.");
	}

}
