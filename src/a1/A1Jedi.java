package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// Store the total count of items in store.
		int storeItemCount = scan.nextInt();
		
		// Create an array to store item names.
		// Create an array to store item prices.
		// Create an array to store the total count of customers that purchase the item.
		// Create an array to store the total count of purchase of the item.
		String[] itemName = new String[storeItemCount];
		double[] itemPrice = new double[storeItemCount];
		int[] itemCustFreq = new int[storeItemCount];
		int[] itemBuyFreq = new int[storeItemCount];
		
		for (int i = 0; i < storeItemCount; i++) {
			itemName[i] = scan.next();
			itemPrice[i] = scan.nextDouble();
		}
		
		// Store the total count of customers.
		int custCount = scan.nextInt();
		
		// Create an array to store first names.
		// Create an array to store last names.
		String[] fName = new String[custCount];
		String[] lName = new String[custCount];
		
		for (int i = 0; i < custCount; i++) {
			
			fName[i] = scan.next();
			lName[i] = scan.next();
			
			// Store the total count of items to purchase.
			int custItemCount = scan.nextInt();
			
			int[] custItemFreq = new int[custItemCount];
			String[] custItemName = new String[custItemCount];

			// Store the purchase items with truth values.
			boolean[] custItemBuy = new boolean[storeItemCount];
			
			for (int j = 0; j < custItemCount; j++) {
				custItemFreq[j] = scan.nextInt();
				custItemName[j] = scan.next();
				
				// Find the index of this item from store.
				int itemIndex = java.util.Arrays.asList(itemName).indexOf(custItemName[j]);
				
				custItemBuy[itemIndex] = true;
				itemBuyFreq[itemIndex] += custItemFreq[j];
			}
			
			// Increment the total count of customers that purchase this item,
			// if this item is in the purchase.
			for (int j = 0; j < storeItemCount; j++) {
				if (custItemBuy[j]) {
					itemCustFreq[j]++;
				}
			}
		}
		
		scan.close();
		
		for (int i = 0; i < storeItemCount; i++) {
			
			// Use unique grammar if there is no purchase of this item.
			if (itemCustFreq[i] == 0) {
				System.out.println("No customers bought " + itemName[i]);
			} else {
				System.out.println(itemCustFreq[i] + " customers bought " + itemBuyFreq[i] + " " + itemName[i]);
			}
		}
	}
}
