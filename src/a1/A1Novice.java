package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int custCount = scan.nextInt();
		
		// Declare the properties of customers.
		String[] fName = new String[custCount];
		String[] lName = new String[custCount];
		double[] totCost = new double[custCount];
		
		for (int i = 0; i < custCount; i++) {
			
			// Assign values to the properties of this customer.
			fName[i] = scan.next();
			lName[i] = scan.next();
			
			int itemCount = scan.nextInt();
			
			// Declare the properties of items.
			int[] itemFreq = new int[itemCount];
			String[] itemName = new String[itemCount];
			double[] itemPrice = new double[itemCount];
			
			for (int j = 0; j < itemCount; j++) {
				
				// Assign values to the properties of this item.
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
