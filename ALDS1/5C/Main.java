import java.util.Scanner;

class Main {

    static Scanner sc;
    static final double th = Math.PI * 60.0 / 180.0;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        Point a = new Point(0, 0);
        Point b = new Point(100, 0);
        int n = sc.nextInt();

        System.out.printf("%.8f %.8f\n", a.x, a.y);
        koch(n, a, b);
        System.out.printf("%.8f %.8f\n", b.x, b.y);
    }

    static void koch(int n, Point a, Point b) {
        if(n == 0) return ;
        Point s = new Point((2.0 * a.x + b.x) / 3.0, (2.0 * a.y + b.y) / 3.0);
        Point t = new Point((2.0 * b.x + a.x) / 3.0, (2.0 * b.y + a.y) / 3.0);

        double ux = (t.x - s.x) * Math.cos(th) -
                            (t.y - s.y) * Math.sin(th) + s.x;
        double uy = (t.x - s.x) * Math.sin(th) +
                            (t.y - s.y) * Math.cos(th) + s.y;
        Point u = new Point(ux, uy);

        koch(n-1, a, s);
        System.out.printf("%.8f %.8f\n", s.x, s.y);
        koch(n-1, s, u);
        System.out.printf("%.8f %.8f\n", u.x, u.y);
        koch(n-1, u, t);
        System.out.printf("%.8f %.8f\n", t.x, t.y);
        koch(n-1, t, b);
    }
}

class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
