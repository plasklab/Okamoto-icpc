package ALDS1_1_A;

import java.util.Scanner;

public class Main {
	
	static Scanner scan;
	
	public static int[] InsertionSort(int[] input, int length) {
		for(int i = 1; i <= length - 1; i++) {
			printArray(input, length);
			
			int key = input[i];
			int j = i - 1;
			
			while(j >= 0 && input[j] > key) {
				input[j + 1] = input[j];
				j--;
			}
			
			input[j + 1] = key;
		}
		
		return input;
	}
	
	public static void printArray(int[] array, int length) {
		for(int i = 0; i < length - 1; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println(array[length - 1]);
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		// Get a value of input array's length
		final int Length = scan.nextInt();
		
		// Get a input array
		int Array[] = new int[Length];

		for(int i = 0; i < Length; i++) {
			Array[i] = scan.nextInt();
		}
		
		Array = InsertionSort(Array, Length);
		printArray(Array, Length);
	}

}
