package javase02.t01;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

	    Pen pen1 = new Pen("Casio",Color.BLUE,120);
        Pen pen2 = new Pen("Yamaha",Color.RED,150);
        Pen pen3 = new Pen("Casio",Color.BLUE,120);

        out.println( pen1.equals(pen2));
        out.println( pen1.equals(pen3));

        out.println(pen1.hashCode());
        out.println(pen2.hashCode());
        out.println(pen3.hashCode());

        out.println( pen1 );
        out.println( pen2 );
        out.println( pen3 );

    }
}
