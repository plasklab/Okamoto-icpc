import java.util.Scanner;

class Main {

  static intStack stack = new intStack(20000);
  static Scanner scan;

  static public void main(String[] args){
    // get from std in
    scan = new Scanner(System.in);
    String input = scan.nextLine();

    // calc : total area
    int sum = 0;
    Tuple[] lines = new Tuple[10000];
    int n = 0;
    for(int i = 0; i < input.length(); i++) {
      switch(input.charAt(i)) {
        case '\\':
        stack.push(i);
        break;
        case '/':
        if (!stack.isEmpty()){
          int tmp = (Integer)stack.pop();
          sum += i - tmp;
          lines[n] = new Tuple(tmp, i);
          n++;
        }
        break;
        default:
        break;
      }
    }
    // print : total area
    System.out.println(sum);

    // calc : each floods area
    int[] area = new int[n];
    int count = 0;
    for(int i = 0; i < n; i++) {
      int min = lines[i].tail;
      int index = i;
      for(int j = i+1; j < n; j++) {
        if(min > lines[j].tail) {
          min = lines[j].tail;
          index = j;
        }
      }
      for(int j = i; j <= index; j++){
        area[count] += lines[j].head - lines[j].tail;
      }
      count++;
      i = index;
    }

    if(count > 0){
      System.out.printf("%d ", count);
      for(int i = 0; i < count-1; i++){
        System.out.printf("%d ", area[i]);
      }
      System.out.printf("%d\n", area[count-1]);
    } else {
      System.out.printf("%d\n", count);
    }
  }
}

class Tuple {
  public int tail;
  public int head;

  public Tuple(int t, int h){
    this.tail = t;
    this.head = h;
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

  public boolean isEmpty(){
    if (current == 0) return true;
    else return false;
  }
}
