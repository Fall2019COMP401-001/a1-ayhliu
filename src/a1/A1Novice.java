package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// Store the total count of customers.
		int custCount = scan.nextInt();
		
		// Create an array to store first names.
		// Create an array to store last names.
		// Create an array to store customers' total costs of purchase.
		String[] fName = new String[custCount];
		String[] lName = new String[custCount];
		double[] totCost = new double[custCount];
		
		for (int i = 0; i < custCount; i++) {
			
			fName[i] = scan.next();
			lName[i] = scan.next();

			// Store the total count of items to purchase.
			int itemCount = scan.nextInt();

			// Create an array to store item purchase quantities.
			// Create an array to store item names.
			// Create an array to store item prices.
			int[] itemFreq = new int[itemCount];
			String[] itemName = new String[itemCount];
			double[] itemPrice = new double[itemCount];
			
			for (int j = 0; j < itemCount; j++) {
				
				itemFreq[j] = scan.nextInt();
				itemName[j] = scan.next();
				itemPrice[j] = scan.nextDouble();
				
				// Add item cost to customers's total cost.
				totCost[i] += itemFreq[j] * itemPrice[j];
			}
		}
		
		scan.close();
		
		// Output to the correct format.
		for (int i = 0; i < custCount; i++) {
			System.out.printf(fName[i].substring(0,1) + ". " + lName[i] + ": %.2f\n", totCost[i]);
		}
	}
}
