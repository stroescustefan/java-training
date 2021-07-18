package code._4_student_effort;

import java.util.ArrayList;
import java.util.List;

public class Challenge_6 {
    public static void main(String[] args) {
        int[][] matrix = {  { 1, 2, 3, 4, 5 },
                            { 16, 17, 18, 19, 6 },
                            { 15, 24, 25, 20, 7 },
                            { 14, 23, 22, 21, 8 },
                            { 13, 12, 11, 10, 9 }
        };

        int[][] matrix2 = { { 1, 2, 3, 4},
                            { 12, 13, 14, 5 },
                            { 11, 16, 15, 6 },
                            { 10, 9, 8, 7 },
        };

        System.out.println(zigZagMatrix(matrix));
    }

    public static List<Integer> zigZagMatrix(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        for (int k = 0; k < matrix.length / 2; k++) {
            for (int j = k; j < matrix.length - k; j++) {
                result.add(matrix[k][j]);
            }

            for (int i = k + 1; i < matrix.length - k - 1; i++) {
                result.add(matrix[i][matrix.length - k - 1]);
            }

            for (int j = matrix.length - k - 1; j >= k; j--) {
                result.add(matrix[matrix.length - k - 1][j]);
            }

            for (int i = matrix.length - k - 2; i >= k + 1; i--) {
                result.add(matrix[i][k]);
            }
        }

        if (matrix.length % 2 != 0) {
            result.add(matrix[matrix.length / 2][matrix.length / 2]);
        }
        return result;
    }

}
