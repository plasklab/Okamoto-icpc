package ALDS1_2_B;

import java.util.Scanner;

public class Main {
	
	static Scanner scan;
	
	private static int[] array;
	private static int counter;
	
	private static void SelectionSort() {
		for(int i = 0; i < array.length - 1; i++) {
			int min = i;
			for(int j = i; j < array.length; j++) {
				if(array[j] < array[min]) min = j;
			}
			if(min != i) swap(i, min);
		}
	}
	
	private static void swap(int i, int j) {
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
		
		// Get the value of input array's length
		final int length = scan.nextInt();
		
		// Get the input array
		array = new int[length];
		for(int i = 0; i < length; i++) {
			array[i] = scan.nextInt();
		}
		
		// Carry out the selection sort
		SelectionSort();
		printArray();
		System.out.println(counter);
	}

}
