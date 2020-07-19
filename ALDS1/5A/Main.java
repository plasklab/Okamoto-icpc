import java.util.Scanner;

class Main {

    static int n = 0;
    static int q = 0;
    static int[] A;
    static int[] w;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        A = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        q = sc.nextInt();
        w = new int[q];
        for(int i = 0; i < q; i++) {
            w[i] = sc.nextInt();
        }

        for(int i = 0; i < q; i++) {
            if(ExhaustiveSearch(A, w[i], n))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    public static int[] InsertionSort(int[] input, int length) {
		for(int i = 1; i <= length - 1; i++) {
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

    public static boolean ExhaustiveSearch(int[] A, int w, int q) {
        for(int i = 1; i < Math.pow(2, q+1); i++) {
            int tmp = 0;
            for(int j = 0; j < q; j++) {
                int buf = A[j] * ((i & (1 << j)) >> j);
                tmp += buf;
            }
            if(tmp == w) return true;
        }
        return false;
    }
}
