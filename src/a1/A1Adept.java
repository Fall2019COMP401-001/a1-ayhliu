package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int storeItemCount = scan.nextInt();

		// Declare the properties of items.
		String[] itemName = new String[storeItemCount];
		double[] itemPrice = new double[storeItemCount];
		
		// Assign values to the properties of each item.
		for (int i = 0; i < storeItemCount; i++) {
			itemName[i] = scan.next();
			itemPrice[i] = scan.nextDouble();
		}
		
		int custCount = scan.nextInt();
		
		// Declare the properties of customers.
		String[] fName = new String[custCount];
		String[] lName = new String[custCount];
		double[] totCost = new double[custCount];
		
		for (int i = 0; i < custCount; i++) {
			
			// Assign values to the properties of this customer.
			fName[i] = scan.next();
			lName[i] = scan.next();
			
			int custItemCount = scan.nextInt();
			
			// Declare the properties of the customer's shopping items.
			int[] custItemFreq = new int[custItemCount];
			String[] custItemName = new String[custItemCount];
			
			for (int j = 0; j < custItemCount; j++) {
				custItemFreq[j] = scan.nextInt();
				custItemName[j] = scan.next();
				
				// Find the item index in store with matching name.
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
	
	/* minIndex()
	 * Finds the index of the minimum value in the array of double.
	 * 
	 * Input: Array of double.
	 * Output: Index of the minimum value in the array of double.
	 * Note: If multiple indices have the minimum value, then the smallest index is returned.
	 * 
	 * Precondition: Array is not null.
	 */
	static int minIndex(double[] arr) {
		int minIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < arr[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	/* maxIndex()
	 * Finds the index of the maximum value in the array of double.
	 * 
	 * Input: Array of double.
	 * Output: Index of the maximum value in the array of double.
	 * Note: If multiple indices have the maximum value, then the smallest index is returned.
	 * 
	 * Precondition: Array is not null.
	 */
	static int maxIndex(double[] arr) {
		int maxIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	/* avg()
	 * Finds the average value of the array of double.
	 * 
	 * Input: Array of double.
	 * Output: Average value of the array of double.
	 * 
	 * Precondition: Array is not null.
	 */
	static double avg(double[] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum / arr.length;
	}
}
