import java.util.Scanner;

class Main {
    static final int INF = Integer.MAX_VALUE;

    static Scanner sc;
    static int[] input;
    static int n;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        input = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        MergeSort(0, n);

        for(int i = 0; i < n-1; i++)
            System.out.print(input[i] + (i == n-1 ? "\n" : " "));
        System.out.println(input[n-1]);
        System.out.println(count);
    }

    static void MergeSort(int left, int right) {
        if(left+1 < right) {
            int mid = (left + right) / 2;
            MergeSort(left, mid);
            MergeSort(mid, right);
            Merge(left, mid, right);
        }
    }

    static void Merge(int left, int mid, int right) {
        int n1 = mid - left;
        int n2 = right - mid;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];

        for(int i = 0; i < n1; i++)
            L[i] = input[left + i];
        for(int i = 0; i < n2; i++)
            R[i] = input[mid + i];

        L[n1] = R[n2] = INF;

        int i = 0; int j = 0;
        for (int k = left; k < right; k++) {
            count++;
            if(L[i] <= R[j]) {
                input[k] = L[i];
                i++;
            } else {
                input[k] = R[j];
                j++;
            }
        }
    }

    static void printArray() {
    }
}
