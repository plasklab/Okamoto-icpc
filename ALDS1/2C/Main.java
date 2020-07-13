package ALDS1_2_C;

import java.util.Scanner;

public class Main {
	
	static Scanner scan;
	
	private static String[] arrayBubble;
	private static String[] arraySelect;
	private static int[] keyBubble;
	private static int[] keySelect;
	private static boolean stateBubble = true;
	private static boolean stateSelect = true;
	
	public static void BubbleSort(int[] key, int length) {
		for(int i = 0; i < length - 1; i++) {
			for(int j = length - 1; j >= i + 1; j--) {
				if(key[j] < key[j-1]) {
					swap(keyBubble, arrayBubble, j, j-1);
					if(key[j] == key[j-1]) stateBubble = false;
				}
			}
		}
	}
	
	private static void SelectionSort(int[] key, int length) {
		for(int i = 0; i < length - 1; i++) {
			int min = i;
			for(int j = i; j < length; j++) {
				if(key[j] < key[min]) min = j;
			}
			swap(keySelect, arraySelect, i, min);
			for(int j = 0; j < min; j++) {
				if(key[j] == key[min]) stateSelect = false;
			}
		}
	}
	
	public static void swap(int[] intArray, String[] stringArray, int i, int j) {
		int tmpi = intArray[i];
		String tmps = stringArray[i];
		intArray[i] = intArray[j];
		stringArray[i] = stringArray[j];
		intArray[j] = tmpi;
		stringArray[j] = tmps;
	}
	
	public static void printArray(String[] input) {
		for(int i = 0; i < input.length - 1; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println(input[input.length - 1]);
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		// Get the value of input arrya's length
		final int length = scan.nextInt();
		final String[] array = new String[length];
		
		for(int i = 0; i < length; i++) {
			array[i] = scan.next();
		}
		
		// Get the input array, and copy to array "key" without character
		arrayBubble = new String[length];
		arraySelect = new String[length];
		keyBubble = new int[length];
		keySelect = new int[length];
		
		for(int i = 0; i < length; i++) {
			arrayBubble[i] = array[i];
			arraySelect[i] = array[i];
			keyBubble[i] = arrayBubble[i].charAt(1) - 48;
			keySelect[i] = arraySelect[i].charAt(1) - 48;
		}
		
		// Output the array of elements
		BubbleSort(keyBubble, length);
		printArray(arrayBubble);
		if(stateBubble) System.out.println("Stable");
		else System.out.println("Not stable");
		SelectionSort(keySelect, length);
		printArray(arraySelect);
		if(stateSelect) System.out.println("Stable");
		else System.out.println("Not stable");
		
	}

}
