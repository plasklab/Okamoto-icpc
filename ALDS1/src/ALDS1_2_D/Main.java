import java.util.Scanner;

class Main {

    static Scanner scan;

    private static int count = 0;

    public static void main(String[] args){
	scan = new Scanner(System.in);

	// get length
	int length = scan.nextInt();

	// init m
	int m = 0;
	for (int i = length; i > 0; i = (i-1)/3) {
	    m++;
	}
	int[] G = new int[m];
	G[0] = 1;
	for (int i = 1; i < m; i++) {
	    G[i] = G[i-1]*3 + 1;
	}

	// get input array
	int[] input = new int[length];
	for (int i = 0; i < length; i++) {
	    input[i] = scan.nextInt();
	}

	// ShellSort
	for(int i = m-1; i >= 0; i--) {
	    input = insertionSort(input, length, G[i]);
	}

	//Print
	System.out.printf("%d\n", m);
	for(int i = m-1; i > 0; i--) {
	    System.out.printf("%d ", G[i]);
	}
	System.out.printf("%d\n%d\n", G[0], count);
	for (int i = 0; i < length; i++) {
	    System.out.printf("%d\n", input[i]);
	}
    }

    private static int[] insertionSort(int[] input, int length, int gap) {
	int v, j = 0;
	for (int i = gap; i < length; i++) {
	    v = input[i];
	    j = i - gap;
	    for ( ; j >= 0 && input[j] > v;) {
		input[j + gap] = input[j];
		j -= gap;
		count++;
	    }
	    input[j + gap] = v;
	}
	return input;
    }
}
