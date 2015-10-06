package javase01.t02.main;

public class Main {

    public static void main(String[] args) {
    	int n = 20;
        float a;
        float a_min = 0;
        int i_min = 0;
        float e = 0.02f;  // заданное условие
        boolean isFound = false;

        for( int i = 1; i < n; i++) {
            a = 1/(float)((i+1)*(i+1));
            System.out.println("a(" + i + ")= " + a);
            if( a < e && isFound!=true ) {
                a_min = a;
                i_min = i;
                isFound = true; // так как последовательность убывающая, дальше можно не проверять
                // дальше только вычисляем и выводим на экран остальные элементы
            }
        }

        System.out.println("a_min = a(" + i_min + ")= " + a_min + " < e = " + e);
    }
}
