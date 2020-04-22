package ALDS1_1_B;

import java.util.Scanner;

public class Main {
	static Scanner scan;
	
	public static int GCD(int a, int b) {
		if(a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int cd = a % b; // common divisor
		
		while(cd != 0) {
			a = b;
			b = cd;
			cd = a % b;
		}
		
		return b;
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		// Get two input numbers.
		final int x = scan.nextInt();
		final int y = scan.nextInt();
		
		// Output the greatest common divisor of x and y
		System.out.println(GCD(x, y));
	}
}
