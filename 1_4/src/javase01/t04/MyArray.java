package javase01.t04;
import java.util.Random;

/**
 * Created by akulakov on 25.09.2015.
 */
public class MyArray {
    private int n;
    private double[] m;

    public MyArray(int n) {
        this.n = n;
        m = new double[n];
        Random random = new Random();
        for(int i=0; i<n; i++) {
            m[i] = random.nextDouble();
        }
    }

    public void PrintArray() {
        for(int i=0; i<n; i++) {
            System.out.println(m[i]);
        }
    }

    public double GetMaxSumOfTwoNeirElements() {
        double sum = 0;
        double max_sum = 0;

        for(int i=0; i<n-1; i++) {

            sum = m[i] + m[i + 1];

            if( i==0 ) max_sum = sum;

            if (sum >  max_sum) {
                max_sum = sum;
            }
        }
        return max_sum;
    }
}
