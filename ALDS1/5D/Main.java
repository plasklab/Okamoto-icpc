import java.util.Scanner;

class Main {

    static Scanner sc;
    static int[] input;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();

        input = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        long res = MergeSort(0, n);
        System.out.println(res);
    }

    static long MergeSort(int left, int right) {
        long v1, v2, v3;
        if(left+1 < right) {
            int mid = (left + right) / 2;
            v1 = MergeSort(left, mid);
            v2 = MergeSort(mid, right);
            v3 = Merge(left, mid, right);
            return v1+v2+v3;
        } else return 0;
    }

    static long Merge(int left, int mid, int right) {
        long count = 0;
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
            if(L[i] <= R[j]) {
                input[k] = L[i];
                i++;
            } else {
                input[k] = R[j];
                j++;
                count += n1 - i;
            }
        }
        return count;
    }
}
