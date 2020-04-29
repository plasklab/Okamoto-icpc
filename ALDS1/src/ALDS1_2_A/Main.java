package ALDS1_2_A;

import java.util.Scanner;

public class Main {
	
	static Scanner scan;
	
	private static int counter = 0;
	private static int[] array;
	
	public static int[] BubbleSort() {
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = array.length - 1; j >= i + 1; j--) {
				if(array[j] < array[j-1]) {
					swap(j, j-1);
				}
			}
		}
		
		return array;
	}
	
	public static void swap(int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
		
		counter++;
	}
	
	public static void printArray() {
		for(int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(array[array.length - 1]);
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		// Get a value of the input array's length
		final int length = scan.nextInt();
		
		// Get a input array
		array = new int[length];
		for(int i = 0; i < length; i++) {
			array[i] = scan.nextInt();
		}
		
		// Carry out the bubble sort
		BubbleSort();
		printArray();
		System.out.println(counter);
	}

}
