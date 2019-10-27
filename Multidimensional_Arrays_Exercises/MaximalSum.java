package Multidimensional_Arrays_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = line;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;

        for (int row = 0; row < rows -2; row++) {
            for (int col = 0; col < cols -2 ; col++) {
                int currentSum = sumMatrix(matrix,row,col);
                if (currentSum > maxSum){
                    maxSum = currentSum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        System.out.printf("%d %d %d%n%d %d %d%n%d %d %d%n",matrix[maxRow][maxCol] , matrix[maxRow][maxCol + 1] , matrix[maxRow][maxCol + 2]
                ,matrix[maxRow + 1][maxCol] , matrix[maxRow + 1][maxCol + 1] , matrix[maxRow + 1][maxCol + 2]
                , matrix[maxRow + 2][maxCol] , matrix[maxRow + 2][maxCol + 1] , matrix[maxRow + 2][maxCol + 2]);

    }

    private static int sumMatrix(int[][] matrix, int row, int col) {
        return matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
    }
}
