package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// storeItemCount is the count of item types in store.
		int storeItemCount = scan.nextInt();

		String[] itemName = new String[storeItemCount];
		double[] itemPrice = new double[storeItemCount];
		
		// itemCustFreq is the frequency of customers that purchase an item.
		int[] itemCustFreq = new int[storeItemCount];
		// itemBuyFreq is the frequency of purchase of an item.
		int[] itemBuyFreq = new int[storeItemCount];
		
		for (int i = 0; i < storeItemCount; i++) {
			itemName[i] = scan.next();
			itemPrice[i] = scan.nextDouble();
			itemCustFreq[i] = 0;
		}
		
		int custCount = scan.nextInt();
		
		// Declare the properties of customers.
		String[] fName = new String[custCount];
		String[] lName = new String[custCount];
		
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
				
				// Find the index of this item in store.
				int itemIndex = java.util.Arrays.asList(itemName).indexOf(custItemName[j]);

				itemCustFreq[itemIndex]++;
				itemBuyFreq[itemIndex] += custItemFreq[j];
			}
		}
		
		scan.close();
		
		for (int i = 0; i < storeItemCount; i++) {
			
			// Use unique grammar if none of the item is bought.
			if (itemCustFreq[i] == 0) {
				System.out.println("No customers bought " + itemName[i]);
			} else {
				System.out.println(itemCustFreq[i] + " customers bought " + itemBuyFreq[i] + " " + itemName[i]);
			}
		}
	}
}
