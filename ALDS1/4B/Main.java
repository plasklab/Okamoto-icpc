import java.util.Scanner;

public class Main {

    static Scanner scan;
    static int count = 0;

    public static void main(String[] args) {
        scan = new Scanner(System.in);

         // get input
         final int slen = scan.nextInt();
         int[] s = new int[slen];
         for(int i = 0; i < slen; i++) {
             s[i] = scan.nextInt();
         }

         final int tlen = scan.nextInt();
         int[] t = new int[tlen];
         for(int i = 0; i < tlen; i++){
             t[i] = scan.nextInt();
         }

         // carry out binary search
         for(int i = 0; i < tlen; i++) {
             binarySearch(s, t[i]);
         }

         System.out.println(count);
    }

    public static void binarySearch(int[] s, int t){
        int hi = 0; int ti = s.length-1; //先頭のインデックス; 末尾のインデックス;
        int p;

        while(hi <= ti) {
            p = (hi + ti) / 2; //探索対象インデックス
            if(s[p] == t) {
                System.out.println("find : " + t);
                count++;
                break;
            } else if(s[p] < t) {
                hi = p + 1;
                continue;
            } else {
                ti = p - 1;
                continue;
            }
        }

        return;
    }
}
