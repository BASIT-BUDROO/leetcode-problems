package SpiralMatrixII;

import java.util.Arrays;

public class SolutionMatrix {
    public int[][] generateMatrix(int n) {

        if (n == 1) {

            int[][] result = new int[1][1];
            result[0][0] = 1;
            return result;

        }

        int a = 0;
        int b = 0;
        int curr_val = 1;

        int alpha;

        int[][] result = new int[n][n];

        for (int i = 0; i < n / 2; i++) {
            alpha = i;
            a = i;
            b = i;

            result[a][b] = curr_val++;

            for (b = alpha + 1; b <= n - alpha - 1; b++) {
                result[a][b] = curr_val++;
            }
            b--;
            for (a = alpha + 1; a <= n - alpha - 1; a++) {
                result[a][b] = curr_val++;
            }
            a--;
            for (b = n - alpha - 2; b >= alpha; b--) {
                result[a][b] = curr_val++;
            }
            b++;
            for (a = n - alpha - 2; a >= alpha + 1; a--) {
                result[a][b] = curr_val++;
            }
        }

        if ((n % 2) != 0) {
            result[(n / 2)][(n / 2)] = curr_val;
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionMatrix solution = new SolutionMatrix();
        int[][] matrix = solution.generateMatrix(20);
        System.out.println(Arrays.deepToString(matrix));

    }
}
