package javase01.t05;

/**
 * Created by akulakov on 30.09.2015.
 */
public class Matrix {
    private int n;
    private int[][] matrix;

    public Matrix(int n) {
        this.n = n;
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for( int j = 0; j < n; j++) {
                if( i == j || i+j == n-1 ) matrix[i][j] = 1;
                else matrix[i][j] = 0;
            }
         }
    }

    public void PrintMatrix() {
        for (int i = 0; i < n; i++) {
            for( int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
