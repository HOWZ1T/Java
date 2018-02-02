// Change calculator, provides coins in Australian denominations:
// $2, $1, 50c, 20c, 10c, 5c
// Change rounded to the nearest 5 cents

import java.util.Scanner;
import java.text.DecimalFormat;

public class changegiven {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// User input for item cost & money given
		System.out.print("Enter cost of the item: ");
		double itemCost = scan.nextDouble();
		
		System.out.print("\nEnter amount of money given: ");
		double moneyGiven = scan.nextDouble();

		while (moneyGiven < itemCost) {
			System.out.printf("You still owe %.2f", (itemCost-moneyGiven));
			System.out.println("\n");
			System.out.print("Enter amount of money given: ");
			moneyGiven = scan.nextDouble();
		}
		
		// Calculate dollars and cents for change
		DecimalFormat df = new DecimalFormat ();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		
		int dollars = (int) (moneyGiven - itemCost);
		double cents = (((moneyGiven - itemCost) - dollars) * 100);
		int flatcents = (int) Math.rint(cents);
		
		System.out.println("\nTotal change: " + dollars + " dollars and " + flatcents + " cents");

		// Return change in coins
		int twos = (dollars / 2);
		dollars = (dollars - twos * 2);
		System.out.println("Two dollar coins: " + twos);
		
		int ones = (dollars);
		dollars = (dollars - ones);
		System.out.println("One dollar coins: " + ones);
		
		int fifties = (flatcents / 50);
		flatcents = (flatcents - fifties * 50);
		System.out.println("Fifty cent coins: " + fifties);

		int twenties = (flatcents / 20);
		flatcents = (flatcents - twenties * 20);
		System.out.println("Twenty cent coins: " + twenties);

		int tens = (flatcents / 10);
		flatcents = (flatcents - tens * 10);
		System.out.println("Ten cent coins: " + tens);

		int fives = (flatcents / 5);
		flatcents = (flatcents - fives * 5);
		
		// Round to nearest 5c, in customers favor if 3 or more cents remaining
		if (flatcents >= 3) {
			fives = fives + 1;
		}
		System.out.println("Five cent coins: " + fives);
	}
}
