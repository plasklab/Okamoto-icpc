import java.util.Scanner;

class Main {

    static Scanner scan;
    static P[] p;
    static int head;
    static int tail;

    public static void main(String[] args) {
	int elaps = 0;
	
	// get from std in: n, q
	scan = new Scanner(System.in);
	final int n = scan.nextInt();
	final int q = scan.nextInt();

	// create a queue
	p = new P[100000];
	head = 0;
	tail = n;

	for (int i = 0; i < n; i++) {
	    String name = scan.next();
	    int t = scan.nextInt();
	    p[i] = new P(name, t);
	}

	while(head != tail) {
	    P u = dequeue();
	    int c = min(q, u.t);
	    u.t -= c;
	    elaps += c;
	    if(u.t > 0) enqueue(u);
	    else {
		System.out.printf("%s %d\n", u.name, elaps);
	    }
	}
    }

    static void enqueue(P x) {
	p[tail] = x;
	tail = (tail + 1) % p.length;
    }
    
    static P dequeue() {
	P x = p[head];
	head = (head + 1) % p.length;
	return x;
    }

    static int min(int a, int b) {
	if(a < b) {
	    return a;
	} else {
	    return b;
	}
    }
}

class P {
    public String name;
    public int t;

    public P(String name, int t) {
	this.name = name;
	this.t = t;
    }
}
