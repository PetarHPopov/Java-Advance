package Multidimensional_Arrays_LAB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSum2x2Submatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] rowCol = reader.readLine().split(", ");

        int rows = Integer.parseInt(rowCol[0]);
        int cols = Integer.parseInt(rowCol[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows ; row++) {
            String[] line = reader.readLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;

        for (int row = 0; row < rows -1 ; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currentSum = sumMatrix(matrix,row,col);
                if (currentSum > maxSum){
                    maxSum = currentSum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        System.out.println(String.format("%d %d%n%d %d%n%d"
        ,matrix[maxRow][maxCol],matrix[maxRow][maxCol + 1]
        ,matrix[maxRow + 1 ][maxCol],matrix[maxRow + 1][maxCol + 1],maxSum));

    }

    private static int sumMatrix(int[][] matrix, int row, int col) {
        return matrix[row][col] + matrix[row][col + 1]
                + matrix[row + 1][col] + matrix[row +1][col +1];
    }
}
