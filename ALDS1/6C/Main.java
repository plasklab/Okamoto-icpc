import java.util.Scanner;

class Main{
    static final int INF = Integer.MAX_VALUE;

    static Scanner sc;
    static int[] in_int;
    static String[] in_str;
    static int[] out_int;
    static String[] out_str;

    static public void main(String[] args) {
        sc = new Scanner(System.in);

        int n = sc.nextInt();
        in_int = new int[n];
        in_str = new String[n];
        out_int = new int[n];
        out_str = new String[n];
        for(int i = 0; i < n; i++) {
            String buf_str = sc.next();
            in_str[i] = buf_str;
            out_str[i] = buf_str;
            int buf_int = sc.nextInt();
            in_int[i] = buf_int;
            out_int[i] = buf_int;
        }
        quickSort(0, n-1);
        MergeSort(0, n);
        StringBuilder quick = new StringBuilder();
		for (int i = 0; i < n; i++) {
			quick.append(out_str[i] + " " + out_int[i] + "\n");
        }
        StringBuilder merge = new StringBuilder();
		for (int i = 0; i < n; i++) {
			merge.append(in_str[i] + " " + in_int[i] + "\n");
        }
        String str_q = new String(quick);
        String str_m = new String(merge);
        if(str_q.equals(str_m))
            System.out.println("Stable");
        else
            System.out.println("Not stable");

        System.out.print(str_q);
    }

    static void quickSort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            quickSort(p, q-1);
            quickSort(q+1, r);
        }
    }
    static int partition(int p, int r) {
        int x = out_int[r];
        int i = p-1;
        for(int j = p; j < r; j++) {
            if(out_int[j] <= x) {
                i++;
                swap(i, j);
            }
        }
        swap(i+1, r);
        return i+1;
    }
    static void swap(int i, int j) {
        int tmp_int = out_int[i];
        out_int[i] = out_int[j];
        out_int[j] = tmp_int;
        String tmp_str = out_str[i];
        out_str[i] = out_str[j];
        out_str[j] = tmp_str;
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
        int[] L_int = new int[n1+1];
        String[] L_str = new String[n1+1];
        int[] R_int = new int[n2+1];
        String[] R_str = new String[n2+1];

        for(int i = 0; i < n1; i++){
            L_int[i] = in_int[left + i];
            L_str[i] = in_str[left + i];
        }
        for(int i = 0; i < n2; i++){
            R_int[i] = in_int[mid + i];
            R_str[i] = in_str[mid + i];
        }

        L_int[n1] = R_int[n2] = INF;

        int i = 0; int j = 0;
        for (int k = left; k < right; k++) {
            if(L_int[i] <= R_int[j]) {
                in_int[k] = L_int[i];
                in_str[k] = L_str[i];
                i++;
            } else {
                in_int[k] = R_int[j];
                in_str[k] = R_str[j];
                j++;
            }
        }
    }
}
