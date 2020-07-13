import java.util.Scanner;
import java.util.HashMap;

public class Main{

    static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);

        final int n = scan.nextInt();
        String command, str;

        HashMap<String, String> h = new HashMap<String, String>();

        for(int i = 0; i < n; i++) {
            command = scan.next();
            str = scan.next();

            switch(command) {
                case "insert":
                    h.put(str, "yes");
                    break;
                case "find":
                    if(h.containsKey(str)) System.out.println(h.get(str));
                    else System.out.println("no");
                    break;
            }
        }
    }
}
