package ALDS1_1_D;

import java.util.Scanner;

public class Main {
	
	static Scanner scan;
	
	public static void main(String[] main) {
		scan = new Scanner(System.in);
		
		// Get the input number of array's elements.
		final int n = scan.nextInt();
		
		// Get the input array.
		int list[] = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = scan.nextInt();
		}
		
		// Calculate the max profit.
		int max = list[1] - list[0];
		int key = list[0];
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				if(key < list[i]) break;
				if(max < list[j] - list[i]) {
					max = list[j] - list[i];
					key = list[i];
				}
			}
		}

		// Output the result.
		System.out.println(max);
	}
}
