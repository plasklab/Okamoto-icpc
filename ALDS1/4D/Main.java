import java.util.Scanner;

public class Main {

    static Scanner scan;
    static int[] W;
    static final int n = 0;
    static final int k = 0;

    public static void main(String[] args) {
        scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int gross = 0;
        W = new int[n];

        for(int i = 0; i < n; i++) {
            W[i] = scan.nextInt();
            gross += W[i];
        }

        if(k == 1) {
            System.out.println(gross);
            return ;
        }
        int min = gross / k; // 積載重量平均値
        int max = gross; // 合計積載重量最大値
        int mid = (max + min) / 2;

        while(max - min > 1) {
            mid = (max + min)/2;
            if(carry(mid, k, n)) {
                max = mid;
                continue;
            } else break;
        }

        while(true) {
            if(carry(max, k, n)) {
                max--;
                continue;
            }
            else {
                max++;
                break;
            }
        }
        System.out.println(max);
    }

    static public boolean carry(int P, int k, int n) {
        if(P == 0) {
            return false;
        }
        int j = 0;
        for(int i = 0; i < k; i++) {
            int s = 0;
            while(s + W[j] <= P) {
                s += W[j];
                j++;
                if(j == n) return true;
            }
        }
        return false;
    }
}
