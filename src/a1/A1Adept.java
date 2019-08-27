package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// Store the total count of items in store.
		int storeItemCount = scan.nextInt();
		
		// Create an array to store item names.
		// Create an array to store item prices.
		String[] itemName = new String[storeItemCount];
		double[] itemPrice = new double[storeItemCount];
		
		for (int i = 0; i < storeItemCount; i++) {
			itemName[i] = scan.next();
			itemPrice[i] = scan.nextDouble();
		}
		
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
			int custItemCount = scan.nextInt();

			// Create an array to store item purchase quantities.
			// Create an array to store item names.
			int[] custItemFreq = new int[custItemCount];
			String[] custItemName = new String[custItemCount];
			
			for (int j = 0; j < custItemCount; j++) {
				custItemFreq[j] = scan.nextInt();
				custItemName[j] = scan.next();
				
				// Find the index of item from store.
				int itemIndex = java.util.Arrays.asList(itemName).indexOf(custItemName[j]);
				
				totCost[i] += custItemFreq[j] * itemPrice[itemIndex];
			}
		}
		
		scan.close();
		
		int minIndex = minIndex(totCost);
		int maxIndex = maxIndex(totCost);
		
		System.out.printf("Biggest: " + fName[maxIndex] + " " + lName[maxIndex] + " (%.2f)\n", totCost[maxIndex]);
		System.out.printf("Smallest: " + fName[minIndex] + " " + lName[minIndex] + " (%.2f)\n", totCost[minIndex]);
		System.out.printf("Average: %.2f\n", avg(totCost));
	}
	
	/* minIndex
	 * Finds and returns the index of the minimum value in an array of doubles.
	 * 
	 * Input: Array of doubles arr.
	 * 
	 * Output: Index of the minimum value found within the array.
	 * If multiple indices have this value, then the smallest index is returned.
	 * 
	 * Precondition: Array is not null.
	 */
	
	static int minIndex(double[] arr) {
		int minIndex = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] < arr[minIndex])
				minIndex = i;
		return minIndex;
	}
	
	/* maxIndex
	 * Finds and returns the index of the maximum value in an array of doubles.
	 * 
	 * Input: Array of doubles arr.
	 * 
	 * Output: Index of the maximum value found within the array.
	 * If multiple indices have this value, then the smallest index is returned.
	 * 
	 * Precondition: Array is not null.
	 */
	
	static int maxIndex(double[] arr) {
		int maxIndex = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > arr[maxIndex])
				maxIndex = i;
		return maxIndex;
	}
	
	/* avg()
	 * Finds and returns the average value in an array of doubles.
	 * 
	 * Input: Array of double.
	 * Output: Average value of the array of double.
	 * 
	 * Precondition: Array is not null.
	 */
	
	static double avg(double[] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		return sum / arr.length;
	}
}
