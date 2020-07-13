import java.util.Scanner;

class Main {

    static intStack stack;
    static Scanner scan;
    
    public static void main(String[] args) {
	// get from Std in
	scan  = new Scanner(System.in);
        String input = scan.nextLine();

	// scan: input string
	scan = new Scanner(input);

	// create: stack
	intStack s = new intStack(100);

	// start: calc.
	String c; // token
	int a, b; // number: use in calc
	for(int i = 0; scan.hasNext(); i += 2) {
	    c = scan.next();
	    switch (c) {
	    case "+":
		a = s.pop();
		b = s.pop();
	        s.push(b + a);
		break;
	    case "-":
		a = s.pop();
		b = s.pop();
		s.push(b - a);
		break;
	    case "*":
		a = s.pop();
		b = s.pop();
		s.push(b * a);
		break;
	    default:
		int n = Integer.parseInt(c);
		s.push(n);
	    }
	}
	System.out.println(s.pop());
	
    }
}

class intStack {
    private static int length;
    private static int[] Stack;
    private static int current;

    public intStack(int length) {
	this.length = length;
	this.Stack = new int[length];
	this.current = 0;
    }

    public void push(int data) {
	this.Stack[current] = data;
	current++;
    }

    public int pop() {
	if (current == 0) return 0;
	current--;
	return this.Stack[current];
    }
}
