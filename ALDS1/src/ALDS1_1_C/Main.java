package ALDS1_1_C;

import java.util.Scanner;

public class Main {
	
	static Scanner scan;
	
	public static boolean judgePN(int a) {
		if (a == 1) return false;
		
		int quotient = a;
		
		for(int i = 2; i < a; i++) {
			quotient = a / i;
			if(a % i == 0) return false;
			if(i > quotient) break;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		// Get the number of the input list
		final int n = scan.nextInt();
		
		// Get figures of the input list
		int list[] = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = scan.nextInt();
		}
		
		// Count the number of prime number
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(judgePN(list[i])) count++;
		}
		
		// Output
		System.out.println(count);
	}
}
