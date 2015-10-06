package javase01.t03;

public class Main {

    public static void main(String[] args) {
        double a = -2;
        double b = 3;
        double h = 0.15;
        double f = 0;

        for( double x = a; x <= b; x += h) {
         //   System.out.printf("1.4f ",% + java.lang.Math.tan(x) );
            f = java.lang.Math.tan(2*x)-3;
            System.out.printf("%.4f %.4f\n", x, f );
        }
    }
}
