import java.util.Scanner;

class Main {

    static Scanner sc;
    static int[] input;

    static public void main(String[] args) {
        sc = new Scanner(System.in);

        int n = sc.nextInt();
        input = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        int index = partition(0, n-1);
        StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n-1; i++) {
            if(i == index)
                builder.append("[" + input[i] + "] ");
            else
                builder.append(input[i] + " ");
        }
		System.out.println(builder.append(input[n-1]));
    }

    static int partition(int p, int r) {
        int x = input[r];
        int i = p-1;
        for(int j = p; j < r; j++) {
            if(input[j] <= x) {
                i++;
                swap(i, j);
            }
        }
        swap(i+1, r);
        return i+1;
    }

    static void swap(int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
