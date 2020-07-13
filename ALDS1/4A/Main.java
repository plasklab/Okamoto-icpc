import java.util.Scanner;

class Main{

    static Scanner scan;

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

         // Linear scan
         int count = 0;
         for(int i = 0; i < tlen; i++) {
             for(int j = 0; j < slen; j++) {
                 if(t[i] == s[j]) {
                     count++;
                     break;
                 }
             }
         }

         System.out.println(count);
    }
}
