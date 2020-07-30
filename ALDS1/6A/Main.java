import java.util.Scanner;

class Main {

    static Scanner sc;
    static final int k = 10001;
    static int n = 0;
    static int[] counter = new int[k+1];
    static int[] input, output;

    static public void main(String[] args) {
        sc = new Scanner(System.in);

        n = sc.nextInt();
        input = new int[n+1];
        output = new int[n+1];
        for(int i = 0; i < n; i++) {
            input[i+1] = sc.nextInt();
            counter[input[i+1]]++;
        }

        CountingSort();
        StringBuilder builder = new StringBuilder();
		for (int i = 1; i < n; i++) {
			builder.append(output[i] + " ");
        }
		System.out.println(builder.append(output[n]));
    }

    static public void CountingSort() {
        for(int i = 1; i <= k; i++) {
            counter[i] += counter[i-1];
        }

        for(int j = 1; j <= n; j++) {
            output[counter[input[j]]] = input[j];
            counter[input[j]]--;
        }
    }
}
